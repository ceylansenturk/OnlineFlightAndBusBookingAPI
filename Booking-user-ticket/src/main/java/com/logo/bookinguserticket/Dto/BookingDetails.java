package com.logo.bookinguserticket.Dto;

import lombok.Data;

import java.util.List;

@Data
public class BookingDetails {
    private int pnr;
    private double totalFare;

    private List<PassengerDto> passengerList;



    public int getPnr() {
        return pnr;
    }
    public void setPnr(int pnr) {
        this.pnr = pnr;
    }
    public double getTotalFare() {
        return totalFare;
    }
    public void setTotalFare(double totalFare) {
        this.totalFare = totalFare;
    }
    public List<PassengerDto> getPassengerList() {
        return passengerList;
    }
    public void setPassengerList(List<PassengerDto> passengerList) {
        this.passengerList = passengerList;
    }
}
