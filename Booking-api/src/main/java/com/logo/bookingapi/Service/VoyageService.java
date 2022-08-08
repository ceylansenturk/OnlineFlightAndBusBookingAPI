package com.logo.bookingapi.Service;

import com.logo.bookingapi.Dto.VoyageDto;
import com.logo.bookingapi.Model.Voyage;
import com.logo.bookingapi.Model.enums.CityType;
import com.logo.bookingapi.Repository.VoyageRepository;
import com.logo.bookingapi.exceptions.RecordAlreadyPresentException;
import com.logo.bookingapi.exceptions.RecordNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class VoyageService {
    @Autowired
    private AmqpTemplate rabbitTemplate;
    @Autowired
    private VoyageRepository voyageRepository;

    public Voyage addVoyage(VoyageDto voyageDto) {

        Voyage voyage = new Voyage();
        voyage.setTransportType(voyageDto.getTransportType());
        voyage.setFirmName(voyageDto.getFirmName());
        voyage.setSourceCity(voyageDto.getSourceCity());
        voyage.setDestinationCity(voyageDto.getDestinationCity());
        voyage.setVoyageDate(voyageDto.getVoyageDate());
        voyage.setVoyageTime(voyageDto.getVoyageTime());
        voyage.setFare(voyageDto.getFare());
        voyage.setSeatCount(voyageDto.getSeatCount());
        // yeni sefer database e kaydedilir
        log.info("Sefer oluşturuldu.");
        return voyageRepository.save(voyage);
    }


    public Iterable<Voyage> viewAllVoyage() {
        return voyageRepository.findAll();
    }
    // bütün seferler sorgulanır

    //id ile sefer sorgulanır
    public Voyage viewVoyage(int voyageId) {
        Optional<Voyage> findById = voyageRepository.findById(voyageId);
        if (findById.isPresent()) {
            return findById.get();
        }
        else
            throw new RecordNotFoundException();
    }
    public List<VoyageDto> getVoyages(CityType sourceCity, CityType destinationCity, Date voyageDate) {
        List<Voyage> voyages = voyageRepository.findVoyageDetails(sourceCity, destinationCity, voyageDate);
        //şehir ve tarih şartlarını sağlayan bütün seferler availableVoyages listesine atılır ve bu liste return edilir
        List<VoyageDto> availableVoyages = new ArrayList<VoyageDto>();
        for (Voyage v : voyages) {
            VoyageDto voyage = new VoyageDto();
            voyage.setVoyageId(v.getVoyageId());
            voyage.setSourceCity(v.getSourceCity());
            voyage.setDestinationCity(v.getDestinationCity());
            voyage.setVoyageDate(v.getVoyageDate());
            voyage.setVoyageTime(v.getVoyageTime());
            voyage.setSeatCount(v.getSeatCount());
            voyage.setFirmName(v.getFirmName());
            voyage.setFare(v.getFare());
            availableVoyages.add(voyage);
        }

        return availableVoyages;
    }


    public void updateVoyage(int voyageId, int noOfSeats) throws RecordNotFoundException {
        Voyage voyage = voyageRepository.findById(voyageId).get();

        if (voyage == null) {
            throw new RecordNotFoundException();
        } else {

            int count = voyage.getSeatCount() - Integer.valueOf(noOfSeats);
            voyage.setSeatCount(count);
            voyageRepository.saveAndFlush(voyage);
            //yeni bilet alındığında alınan seat sayısı güncellenir

        }
        log.info("Sefer güncellendi.");

    }
    public String removeVoyage(Integer voyageId) {
        Optional<Voyage> findById = voyageRepository.findById(voyageId);
        if (findById.isPresent()) {
            voyageRepository.deleteById(voyageId);
            return "Sefer kaldırıldı.";
        } else
            throw new RecordNotFoundException();

    }




}
