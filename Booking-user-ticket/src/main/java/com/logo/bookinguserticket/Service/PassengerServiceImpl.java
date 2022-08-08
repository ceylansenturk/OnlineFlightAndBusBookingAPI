package com.logo.bookinguserticket.Service;

import com.logo.bookinguserticket.Dto.PassengerDto;
import com.logo.bookinguserticket.Exceptions.UserNotFoundException;
import com.logo.bookinguserticket.Model.Passenger;
import com.logo.bookinguserticket.Repository.PassengerRepository;
import com.logo.bookinguserticket.adapter.PassengerAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service(value="PassengerService")
public class PassengerServiceImpl implements PassengerService {
    @Autowired
    private PassengerRepository passengerRepository;
    // Yolcu oluşturma metodu
    @Override
    public void createPassenger(List<PassengerDto> passengersDto) throws UserNotFoundException {
        List<Passenger> passengers=new ArrayList<>();
        passengersDto.forEach(passengerDTO->{
            PassengerAdapter adapter=new PassengerAdapter();
            Passenger passenger=adapter.toEntity(passengerDTO);
            passengers.add(passenger);
        });
        passengerRepository.saveAll(passengers);
    }
}
