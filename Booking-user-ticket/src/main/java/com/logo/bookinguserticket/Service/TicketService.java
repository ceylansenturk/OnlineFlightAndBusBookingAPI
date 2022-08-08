package com.logo.bookinguserticket.Service;

import com.logo.bookinguserticket.Dto.TicketDTO;
import com.logo.bookinguserticket.Exceptions.RecordNotFoundException;

import java.util.List;

public interface TicketService {
    public void createTicket(TicketDTO ticketDTO) throws RecordNotFoundException;
    public List<TicketDTO> viewTicket(String userId) throws RecordNotFoundException;

//    public Integer getTotalFare() throws RecordNotFoundException;
   public double showTotalFare();

}
