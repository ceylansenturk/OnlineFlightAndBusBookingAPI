package com.logo.bookinguserticket.Dto;

import com.logo.bookinguserticket.Model.Enums.TransportType;
import lombok.Data;

import java.util.Date;

@Data
public class TicketDTO {


    private int pnr;
    private String firmName;

    private TransportType transportType;
    private Date bookingDate;
    private Date voyageDate;
    private String voyageTime;
    private double totalfare;
    private int voyageId;
    private String userId;
    private int noOfSeats;

    public TicketDTO() {
    }

    public int getPnr() {
        return pnr;
    }

    public void setPnr(int pnr) {
        this.pnr = pnr;
    }

    public String getFirmName() {
        return firmName;
    }

    public void setFirmName(String firmName) {
        this.firmName = firmName;
    }

    public TransportType getTransportType() {
        return transportType;
    }

    public void setTransportType(TransportType transportType) {
        this.transportType = transportType;
    }

    public Date getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(Date bookingDate) {
        this.bookingDate = bookingDate;
    }

    public Date getVoyageDate() {
        return voyageDate;
    }

    public void setVoyageDate(Date voyageDate) {
        this.voyageDate = voyageDate;
    }

    public String getVoyageTime() {
        return voyageTime;
    }

    public void setVoyageTime(String voyageTime) {
        this.voyageTime = voyageTime;
    }

    public double getTotalfare() {
        return totalfare;
    }

    public void setTotalfare(double totalfare) {
        this.totalfare = totalfare;
    }

    public int getVoyageId() {
        return voyageId;
    }

    public void setVoyageId(int voyageId) {
        this.voyageId = voyageId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public int getNoOfSeats() {
        return noOfSeats;
    }

    public void setNoOfSeats(int noOfSeats) {
        this.noOfSeats = noOfSeats;
    }
}
