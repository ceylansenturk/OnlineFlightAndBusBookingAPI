package com.logo.bookingapi.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.logo.bookingapi.Model.enums.CityType;
import com.logo.bookingapi.Model.enums.TransportType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="voyage")
public class Voyage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int voyageId;
    @Enumerated(EnumType.STRING)
    @Column
    private TransportType transportType;

    @Column
    private String firmName;
    @NotBlank
    @Enumerated(EnumType.STRING)
    @Column
    private CityType sourceCity;
    @NotBlank
    @Enumerated(EnumType.STRING)
    @Column
    private CityType destinationCity;
    @Column
    @DateTimeFormat(pattern="yyyy-MM-dd")
    @Temporal(TemporalType.DATE)
    private Date voyageDate;
    private String voyageTime;
    @Column
    private double fare;
    @Column
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

    @Override
    public String toString() {
        return "Voyage{" +
                "voyageId=" + voyageId +
                ", transportType=" + transportType +
                ", firmName='" + firmName + '\'' +
                ", sourceCity=" + sourceCity +
                ", destinationCity=" + destinationCity +
                ", voyageDate=" + voyageDate +
                ", voyageTime='" + voyageTime + '\'' +
                ", fare=" + fare +
                ", seatCount=" + seatCount +
                '}';
    }
}
