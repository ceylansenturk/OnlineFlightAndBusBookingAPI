package com.logo.bookingapi.exceptions;

public class RecordAlreadyPresentException extends RuntimeException {
    public RecordAlreadyPresentException(String s) {
        super(s);
    }
}
