package com.fssa.glossyblends.CustomException;

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
