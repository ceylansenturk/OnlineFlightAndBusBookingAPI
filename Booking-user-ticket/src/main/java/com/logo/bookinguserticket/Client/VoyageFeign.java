package com.logo.bookinguserticket.Client;


import com.logo.bookinguserticket.Dto.VoyageDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

@FeignClient( url="${booking.url}",value="Booking-api")
public interface VoyageFeign {
        @GetMapping("/voyage/{id}")
        VoyageDto viewVoyage(@PathVariable("id") Integer voyageId);

        @PutMapping(value = "/voyage/{voyageId}/{noOfSeats}")
        void updateVoyageSeat(@PathVariable int voyageId, @PathVariable int noOfSeats);

}

