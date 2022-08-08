package com.logo.bookinguserticket.Service;


import com.logo.bookinguserticket.Client.VoyageFeign;
import com.logo.bookinguserticket.Dto.VoyageDto;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value="circuitBreakerService")
public class CircuitBreakerService {
    @Autowired
    private VoyageFeign voyageFeign;

    public CircuitBreakerService() {
    }

    @CircuitBreaker(name="bookingService")
    public VoyageDto viewVoyage(Integer voyageId){
        return voyageFeign.viewVoyage(voyageId);
    }

    @CircuitBreaker(name="bookingService")
    public void updateVoyageSeat(int voyageId, int noOfSeats) {
        voyageFeign.updateVoyageSeat(voyageId, noOfSeats);
    }
}
