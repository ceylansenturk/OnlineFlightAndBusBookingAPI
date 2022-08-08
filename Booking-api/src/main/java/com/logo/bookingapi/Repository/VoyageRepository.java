package com.logo.bookingapi.Repository;

import com.logo.bookingapi.Model.Voyage;
import com.logo.bookingapi.Model.enums.CityType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.Date;

import java.util.List;
import java.util.Optional;

public interface VoyageRepository  extends JpaRepository<Voyage, Integer> {


    Optional<Voyage> findById(Integer voyageId);

//    public Voyage modifyVoyage(Voyage voyage);
   // public ResponseEntity<?> addVoyage(Voyage voyage);

    @Query("select v from Voyage v where v.sourceCity=:sourceCity and v.destinationCity=:destinationCity and v.voyageDate=:voyageDate")
    public List<Voyage> findVoyageDetails(@Param("sourceCity") CityType sourceCity, @Param("destinationCity") CityType destinationCity, @Param("voyageDate") Date date);
}
