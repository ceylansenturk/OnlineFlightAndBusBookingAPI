package com.logo.bookinguserticket.Service;

import com.logo.bookinguserticket.Dto.TicketDTO;
import com.logo.bookinguserticket.Exceptions.RecordNotFoundException;
import com.logo.bookinguserticket.Model.Ticket;
import com.logo.bookinguserticket.Repository.TicketRepository;
import com.logo.bookinguserticket.Repository.UserRepository;
import com.logo.bookinguserticket.adapter.TicketAdapter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Slf4j
@Service(value = "TicketService")
public class TicketServiceImpl implements TicketService {
    @Autowired
    private TicketRepository ticketRepository;

    @Autowired
    private UserRepository userRepository;

    @Override //bilet oluşturma methodu
    public void createTicket(TicketDTO ticketDTO) throws RecordNotFoundException {
        TicketAdapter adapter = new TicketAdapter();
        Ticket ticket = adapter.toEntity(ticketDTO);
        ticketRepository.save(ticket);

    }

    @Override
    // kullanıcının aldığı biletleri userId ile sorgulamaya yarayan method
    public List<TicketDTO> viewTicket(String userId) throws RecordNotFoundException {
        List<Ticket> tickets = ticketRepository.findByUserid(userId);

        List<TicketDTO> availableTickets = new ArrayList<TicketDTO>();
        for (Ticket t : tickets) {
            TicketDTO ticket = new TicketDTO();
            ticket.setPnr(t.getPnr());
            ticket.setUserId(t.getUserId());
            ticket.setTransportType(t.getTransportType());
            ticket.setBookingDate(t.getBookingDate());
            ticket.setVoyageDate(t.getVoyageDate());
            ticket.setVoyageTime(t.getVoyageTime());
            ticket.setTotalfare(t.getTotalfare());
            ticket.setFirmName(t.getFirmName());
            ticket.setVoyageId(t.getVoyageId());
            ticket.setNoOfSeats(t.getNoOfSeats());
            availableTickets.add(ticket);
        }

        return availableTickets;
    }
    List<TicketDTO> ticketList;
    public List<TicketDTO> getTicketList() {
        return ticketList;
    }


//    @Override
//    public double showTotalFare(){
//        double result= 0;
//        List<TicketDTO> ticketDTOList= new ArrayList<>();
//        for(TicketDTO tickets : getTicketList())  {
//            ticketDTOList.add(tickets);

//        }
//        for (int i=0; i<getTicketList().size();i++) {
//           result += ticketDTOList.get(i).getTotalfare();
//        }
//        log.info("Result");
//        return result;
//    }

}
