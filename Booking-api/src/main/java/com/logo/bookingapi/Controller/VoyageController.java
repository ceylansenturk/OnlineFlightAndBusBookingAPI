package com.logo.bookingapi.Controller;

import com.logo.bookingapi.Dto.VoyageDto;
import com.logo.bookingapi.Model.Voyage;
import com.logo.bookingapi.Model.enums.CityType;
import com.logo.bookingapi.Service.VoyageService;
import com.logo.bookingapi.Utility.MyDateEditor;
import com.logo.bookingapi.exceptions.RecordAlreadyPresentException;
import com.logo.bookingapi.exceptions.RecordNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(value="/voyage")
public class VoyageController {
    @Autowired
    VoyageService voyageService;

    @InitBinder
    public void myInitBinder(WebDataBinder binder) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        binder.registerCustomEditor(Date.class, new MyDateEditor(format));
    } // tarih formatının ayarlanması için
    // yeni sefer ekleme
    @PostMapping("/addVoyage")
    @ExceptionHandler(RecordAlreadyPresentException.class)
    public Voyage addVoyage(@RequestBody VoyageDto voyageDto) {
        return voyageService.addVoyage(voyageDto);
    }
    //bütün sefeleri sorgular
    @GetMapping("/allVoyage")
    public Iterable<Voyage> viewAllVoyage() {
        return voyageService.viewAllVoyage();
    }
    //id ile sefer arama
    @GetMapping("/{id}")
    @ExceptionHandler(RecordNotFoundException.class)
    public Voyage viewVoyage(@PathVariable("id") Integer voyageId) {
        return voyageService.viewVoyage(voyageId);
    }
    // şehir ve tarih bilgisi ile sefer sorgulama
    @GetMapping("/{sourceCity}/{destinationCity}/{voyageDate}")
    public ResponseEntity<List<VoyageDto>> getVoyageDetails(@PathVariable CityType sourceCity,
                                                            HttpServletResponse response, @PathVariable CityType destinationCity, @PathVariable Date voyageDate) {
        List<VoyageDto> availableVoyages = voyageService.getVoyages(sourceCity, destinationCity, voyageDate);
        return new ResponseEntity<List<VoyageDto>>(availableVoyages, HttpStatus.OK); }

//    @PutMapping("/updateVoyage")
//    @ExceptionHandler(RecordNotFoundException.class)
//    public Voyage modifyVoyage(@RequestBody Voyage voyage) {
//        return voyageService.modifyVoyage(voyage);
//    }
    //id ile sefer silinir
    @DeleteMapping("/deleteVoyage/{id}")
    public void removeVoyage(@PathVariable("id") Integer voyageId) {
        voyageService.removeVoyage(voyageId);
    }
    // Her yeni bilet alındığında araç kapatesi güncellenir
    @PutMapping(value = "/{voyageId}/{noOfSeats}")
    public void updateVoyageSeat(@PathVariable int voyageId, @PathVariable int noOfSeats)
            throws RecordNotFoundException {
        voyageService.updateVoyage(voyageId, noOfSeats);

    }



}
