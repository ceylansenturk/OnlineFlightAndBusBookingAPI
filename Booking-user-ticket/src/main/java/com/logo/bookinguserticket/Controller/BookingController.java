package com.logo.bookinguserticket.Controller;

import com.logo.bookinguserticket.Dto.BookingDetails;
import com.logo.bookinguserticket.Dto.PassengerDetails;
import com.logo.bookinguserticket.Dto.VoyageDto;
import com.logo.bookinguserticket.Service.BookingService;
import com.logo.bookinguserticket.Service.CircuitBreakerService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/booking")
public class BookingController {

    private Log Logger=LogFactory.getLog(this.getClass());

    @Autowired
    private BookingService bookingService;
    @Autowired
    private CircuitBreakerService circuitBreakerService;


    //sefer ve user bilgileri ile yolcu listesi post edilerek yeni bilet oluşturur
    @PostMapping("/{voyageId}/{userId}/{username}")
    public ResponseEntity<BookingDetails> bookFlight(@PathVariable("voyageId") Integer voyageId,
                                                     @PathVariable("userId") int userId,
                                                      @RequestBody PassengerDetails passengerDetails,
                                                     @PathVariable("username")String username) {

        VoyageDto voyage=circuitBreakerService.viewVoyage(voyageId);
        BookingDetails bookingDetails=bookingService.createBooking(userId, voyageId, passengerDetails, username, voyage);
        //seat sayısı ile seferdeki seat sayısı güncellenir
        int noOfSeats=bookingDetails.getPassengerList().size();
        circuitBreakerService.updateVoyageSeat(voyageId, noOfSeats);
        return new ResponseEntity<>(bookingDetails, HttpStatus.OK);
    }
}
