package com.logo.bookinguserticket.adapter;

import com.logo.bookinguserticket.Dto.PassengerDto;
import com.logo.bookinguserticket.Model.Passenger;
import com.logo.bookinguserticket.Model.Ticket;

public class PassengerAdapter {
    public Passenger toEntity(PassengerDto passengerDto) {
        Passenger passenger=new Passenger();
        passenger.setPassengerAge(passengerDto.getPassengerAge());
        passenger.setPassengerGender(passengerDto.getPassengerGender());
        passenger.setPassengerName(passengerDto.getPassengerName());
        TicketAdapter adapter=new TicketAdapter();
        Ticket ticket=adapter.toEntity(passengerDto.getTicket());
        passenger.setTicket(ticket);
        return passenger;
    }
}
