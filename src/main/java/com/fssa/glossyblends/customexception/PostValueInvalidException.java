package com.fssa.glossyblends.customexception;

public class PostValueInvalidException extends Exception {
    public PostValueInvalidException() {
        super("Post value is invalid.");
    }

    public PostValueInvalidException(String message) {
        super(message);
    }

    public PostValueInvalidException(String message, Throwable cause) {
        super(message, cause);
    }
}
