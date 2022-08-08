package com.logo.bookinguserticket.Service;

import com.logo.bookinguserticket.Dto.BookingDetails;
import com.logo.bookinguserticket.Dto.PassengerDetails;
import com.logo.bookinguserticket.Dto.VoyageDto;

public interface BookingService {
    public BookingDetails createBooking(int userId,Integer voyageId, PassengerDetails passengerDetails, String username, VoyageDto voyage);
}
