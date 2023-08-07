package com.fssa.glossyblends.CustomException;

public class ServiceValueInvalidException extends Exception {
    public ServiceValueInvalidException() {
        super("Service value is invalid.");
    }

    public ServiceValueInvalidException(String message) {
        super(message);
    }

    public ServiceValueInvalidException(String message, Throwable cause) {
        super(message, cause);
    }
}
