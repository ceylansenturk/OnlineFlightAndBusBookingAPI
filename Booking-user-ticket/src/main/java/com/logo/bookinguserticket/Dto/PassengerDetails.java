package com.logo.bookinguserticket.Dto;

import java.util.List;

public class PassengerDetails {
//    @NotEmpty(message = "Passenger List cannot be empty for booking!")
    List<PassengerDto> passengerList;

    public PassengerDetails() {
        super();
    }

    public List<PassengerDto> getPassengerList() {
        return passengerList;
    }

    public void setPassengerList(List<PassengerDto> passengerList) {
        this.passengerList = passengerList;
    }

    @Override
    public String toString() {
        return "PassengerDetails [passengerList=" + passengerList + "]";
    }

}
