package com.logo.bookinguserticket.Exceptions;

public class RecordNotFoundException extends RuntimeException {
    public RecordNotFoundException(){
        super("Sefer bulunamadı.");
    }
}
