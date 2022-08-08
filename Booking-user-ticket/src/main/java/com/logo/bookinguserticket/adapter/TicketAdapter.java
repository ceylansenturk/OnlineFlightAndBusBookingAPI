package com.logo.bookinguserticket.adapter;

import com.logo.bookinguserticket.Dto.TicketDTO;
import com.logo.bookinguserticket.Model.Ticket;

public class TicketAdapter {
    public Ticket toEntity(TicketDTO ticketDTO) {
        Ticket ticket=new Ticket();
        ticket.setFirmName(ticketDTO.getFirmName());
        ticket.setTransportType(ticketDTO.getTransportType());
        ticket.setBookingDate(ticketDTO.getBookingDate());
        ticket.setVoyageDate(ticketDTO.getVoyageDate());
        ticket.setVoyageTime(ticketDTO.getVoyageTime());
        ticket.setVoyageId(ticketDTO.getVoyageId());
        ticket.setNoOfSeats(ticketDTO.getNoOfSeats());
        ticket.setPnr(ticketDTO.getPnr());
        ticket.setTotalfare(ticketDTO.getTotalfare());
        ticket.setUserId(ticketDTO.getUserId());
        return ticket;
    }
}
