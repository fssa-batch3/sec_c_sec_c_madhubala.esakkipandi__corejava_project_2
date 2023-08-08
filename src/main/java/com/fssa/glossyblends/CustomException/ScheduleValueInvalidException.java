package com.fssa.glossyblends.CustomException;

public class ScheduleValueInvalidException extends Exception{

	public ScheduleValueInvalidException() {
		
        super("Schedule  value is invalid.");

	}
	public ScheduleValueInvalidException(String message) {
		
		super(message);
		
	}
public ScheduleValueInvalidException(String message,Throwable cause) {
		
		super(message,cause);
		
	}
	
}
