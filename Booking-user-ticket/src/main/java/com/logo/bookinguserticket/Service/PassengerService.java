package com.logo.bookinguserticket.Service;

import com.logo.bookinguserticket.Dto.PassengerDto;
import com.logo.bookinguserticket.Exceptions.UserNotFoundException;

import java.util.List;

public interface PassengerService {
    public void createPassenger(List<PassengerDto> passengersDto) throws UserNotFoundException;
}
