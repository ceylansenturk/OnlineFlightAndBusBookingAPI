package com.logo.bookingapi.exceptions;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(){
        super("Admin not found");
    }
}
