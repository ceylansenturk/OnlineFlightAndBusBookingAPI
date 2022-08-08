package com.logo.bookinguserticket.Model;

import com.logo.bookinguserticket.Model.Enums.TransportType;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Ticket_Details")
public class Ticket {
    @Id
    private int pnr;
    @Column
    private String firmName;

    @Enumerated(EnumType.STRING)
    @Column
    private TransportType transportType;
    @Temporal(TemporalType.DATE)
    private Date bookingDate;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    @Temporal(TemporalType.DATE)
    private Date voyageDate;
    @Column
    private String voyageTime;
    @Column
    private double totalfare;
    @Column
    private int voyageId;
    @Column
    private String userId;
    @Column
    private int noOfSeats;

    public Ticket() {
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
