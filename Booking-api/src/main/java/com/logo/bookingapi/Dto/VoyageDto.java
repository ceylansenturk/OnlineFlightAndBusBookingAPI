package com.logo.bookingapi.Dto;

import com.logo.bookingapi.Model.enums.CityType;
import com.logo.bookingapi.Model.enums.TransportType;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;
import java.util.Date;

@Data
public class VoyageDto {
    private int voyageId;
    private TransportType transportType;
    private String firmName;
    private CityType sourceCity;
    private CityType destinationCity;
    private Date voyageDate;
    private String voyageTime;
    private double fare;
    private Integer seatCount;

    public int getVoyageId() {
        return voyageId;
    }

    public void setVoyageId(int voyageId) {
        this.voyageId = voyageId;
    }

    public TransportType getTransportType() {
        return transportType;
    }

    public void setTransportType(TransportType transportType) {
        this.transportType = transportType;
    }

    public String getFirmName() {
        return firmName;
    }

    public void setFirmName(String firmName) {
        this.firmName = firmName;
    }

    public CityType getSourceCity() {
        return sourceCity;
    }

    public void setSourceCity(CityType sourceCity) {
        this.sourceCity = sourceCity;
    }

    public CityType getDestinationCity() {
        return destinationCity;
    }

    public void setDestinationCity(CityType destinationCity) {
        this.destinationCity = destinationCity;
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

    public double getFare() {
        return fare;
    }

    public void setFare(double fare) {
        this.fare = fare;
    }

    public Integer getSeatCount() {
        return seatCount;
    }

    public void setSeatCount(Integer seatCount) {
        this.seatCount = seatCount;
    }
}
