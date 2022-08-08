package com.logo.bookinguserticket.Service;

import com.logo.bookinguserticket.Client.PaymentClient;
import com.logo.bookinguserticket.Dto.*;
import com.logo.bookinguserticket.Exceptions.RecordNotFoundException;
import com.logo.bookinguserticket.Exceptions.UserNotFoundException;
import com.logo.bookinguserticket.Model.Enums.UserType;
import com.logo.bookinguserticket.Model.User;
import com.logo.bookinguserticket.Repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
@Slf4j
@Service(value="bookingService")
public class BookingServiceImpl implements BookingService {
    @Autowired
    private TicketService ticketService;

    @Autowired
    private PassengerService passengerService;

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PaymentClient paymentClient;
    @Autowired
    private RabbitMQService rabbitMQService;

    @Override
    public BookingDetails createBooking(int userId, Integer voyageId, PassengerDetails passengerDetails, String username, VoyageDto voyage) {
        int gender=0;
        User foundUser = userRepository.findById(userId).orElseThrow(() -> new UserNotFoundException());
        boolean isExists = passengerDetails.getPassengerList().isEmpty();
        if (isExists)
            throw new UserNotFoundException();
        List<PassengerDto> passengerList = new ArrayList<PassengerDto>();
        for (PassengerDto passengers : passengerDetails.getPassengerList()) {
            passengerList.add(passengers);

        }
        // Kullanıcı bireysel ve eklediği yolcu listesinin size ı 5ten büyükse bilet alamaz
        if (foundUser.getUserType().equals(UserType.INDIVIDUAL) && passengerDetails.getPassengerList().size() > 5) {
                log.info("Passenger limit is 5!");
            throw new RecordNotFoundException();
            // Kullanıcı kurumsal ve eklediği yolcu listesi size ı 20den büyükse bilet alamaz
        } else if (foundUser.getUserType().equals(UserType.CORPORATE)&&passengerDetails.getPassengerList().size() > 20) {
                log.info("Passenger limit is 20!");
            throw new RecordNotFoundException();
        } else {
            // Eğer yolcu bireysel ise eklediği yolcu listesindeki erkekler sayılır. En fazla 2 erkek için bilet alabilir
            if (foundUser.getUserType().equals(UserType.INDIVIDUAL)) {
                for (int i = 0; i < passengerDetails.getPassengerList().size(); i++) {
                    if (passengerList.get(i).getPassengerGender().equals("Male")) {
                        gender += 1;

                    }
                }
            }
                if (gender > 2) {
                    log.info("Male passenger limit is 2!");
                    throw new RecordNotFoundException();
                } else {

                    TicketDTO ticket = new TicketDTO();
                    int noOfSeats;
                    int pnr = (int) (Math.random() * 1858955); // Her bilete random pnr atanır
                    ticket.setPnr(pnr);

                    double fare = voyage.getFare();
                    double totalFare = fare * (passengerDetails.getPassengerList().size());
                    // ödenecek toplam ücret yolcu sayısı * sefer ücreti şeklünde hesaplanır


                    BookingDetails bookingDetails = new BookingDetails();
                    bookingDetails.setPassengerList(passengerDetails.getPassengerList());
                    bookingDetails.setPnr(pnr);
                    bookingDetails.setTotalFare(totalFare);

                    ticket.setBookingDate(new Date()); // Biletin alındığı tarih
                    System.out.println(ticket.getBookingDate());
                    ticket.setFirmName(voyage.getFirmName()); // Biletin alındığı firma ismi seferden alınır
                    ticket.setTransportType(voyage.getTransportType());// ulaşım tipi seferden alınır
                    ticket.setVoyageDate(voyage.getVoyageDate()); // sefer tarihi seferden alınır
                    ticket.setVoyageTime(voyage.getVoyageTime());// sefer saati seferden alınır
                    ticket.setVoyageId(voyage.getVoyageId()); // sefer id si seferden alınr
                    ticket.setUserId(String.valueOf(userId));// user id requestdeki userid alınır
                    ticket.setTotalfare(totalFare);
                    noOfSeats = passengerDetails.getPassengerList().size();// noofseat yolcu listesinin size ı olarak alınır
                    ticket.setNoOfSeats(noOfSeats);

                    ticketService.createTicket(ticket);
                    PaymentDto paymentDto = new PaymentDto();
                    paymentDto.setAmount(ticket.getTotalfare());
                    paymentDto.setEmail(foundUser.getEmail());
                    paymentDto.setPaymentTime(LocalDateTime.now());
                    paymentDto.setCardNumber(paymentDto.getCardNumber());
                    paymentDto.setCurrencyType(paymentDto.getCurrencyType());
                    paymentDto.setSecurityCode(paymentDto.getSecurityCode());
                    paymentClient.createPayment(paymentDto);
                    log.info("ödeme yapıldı");

                    for (PassengerDto passenger : bookingDetails.getPassengerList()) {
                        passenger.setTicket(ticket);

                    }
                    passengerService.createPassenger(bookingDetails.getPassengerList());
                    rabbitMQService.sendMessage(foundUser.getPhone());
                    log.info("Booking completed!");
                    return bookingDetails;
                }

            }

        }

    }


