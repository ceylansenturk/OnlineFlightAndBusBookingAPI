package com.logo.bookingapi.exceptions;

public class RecordNotFoundException extends RuntimeException{
    public RecordNotFoundException(){
        super("Sefer bulunamad─▒.");
    }
}
