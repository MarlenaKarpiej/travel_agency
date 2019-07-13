package com.sda.travel_agency.exception;

public class PasswordDoNotMatchException extends RuntimeException {
    public PasswordDoNotMatchException(String message) {
        super(message);
    }
}
