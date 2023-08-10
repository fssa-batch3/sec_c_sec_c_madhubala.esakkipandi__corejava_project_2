package com.fssa.glossyblends.customexception;

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
