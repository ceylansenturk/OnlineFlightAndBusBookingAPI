package com.logo.bookinguserticket.Controller;

import com.logo.bookinguserticket.Dto.TicketDTO;
import com.logo.bookinguserticket.Repository.TicketRepository;
import com.logo.bookinguserticket.Service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@RequestMapping("/ticket")
public class TicketController {
    @Autowired
    private TicketService ticketService;
    @Autowired
    private TicketRepository ticketRepository;

    // id ile bilet sorgulanır
    @GetMapping("/{userId}")
    public ResponseEntity<List<TicketDTO>> viewTicket(@PathVariable String userId,
                                                      HttpServletResponse response) {
        List<TicketDTO> availableTickets = ticketService.viewTicket(userId);
        return new ResponseEntity<List<TicketDTO>>(availableTickets, HttpStatus.OK); }
//    @GetMapping("/totalfare")
//    public double showTotalFare(){
//        return ticketService.showTotalFare();
//    }

}
