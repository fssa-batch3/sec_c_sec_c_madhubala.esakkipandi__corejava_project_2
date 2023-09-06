package com.fssa.glossyblends.customexception;

public class PostValueInvalidException extends Exception {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	  public PostValueInvalidException() {
	        super("ERror in validations");
	    }


    public PostValueInvalidException(String message) {
        super(message);
    }

 
}
