package com.logo.bookinguserticket.Dto;

import com.logo.bookinguserticket.Model.Enums.CityType;
import com.logo.bookinguserticket.Model.Enums.TransportType;
import lombok.Data;

import java.util.Date;
@Data
public class VoyageDto {
    private Integer voyageId;
    private TransportType transportType;
    private String firmName;
    private CityType sourceCity;
    private CityType destinationCity;
    private Date voyageDate;
    private String voyageTime;
    private double fare;
    private Integer seatCount;

    public VoyageDto() {
    }

    public VoyageDto(Integer voyageId, TransportType transportType, String firmName, CityType sourceCity, CityType destinationCity, Date voyageDate, String voyageTime, double fare, Integer seatCount) {
        this.voyageId = voyageId;
        this.transportType = transportType;
        this.firmName = firmName;
        this.sourceCity = sourceCity;
        this.destinationCity = destinationCity;
        this.voyageDate = voyageDate;
        this.voyageTime = voyageTime;
        this.fare = fare;
        this.seatCount = seatCount;
    }

    public Integer getVoyageId() {
        return voyageId;
    }

    public void setVoyageId(Integer voyageId) {
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
