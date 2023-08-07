package com.fssa.glossyblends.Validator;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

import com.fssa.glossyblends.model.Artist.ErrorMessages;
import com.fssa.glossyblends.model.Artist.schedule;

public class ScheduleValidations {

	 public static boolean validateSchedule(schedule listOfSchedule) throws IllegalArgumentException {
	        try {
	            validateName(listOfSchedule.getEventName());
	            validateDate(listOfSchedule.getDate());
	            validateTimeOfEvent(listOfSchedule.getTimeOfEvent());
	            return true;
	        } catch (IllegalArgumentException ex) {
	            throw ex; // Rethrow the caught exception
	        }
	    }

  

	public static boolean validateName(String eventname) throws IllegalArgumentException {

        if (eventname == null) {
            throw new IllegalArgumentException(ErrorMessages.INVALI_EVENT_NAME_NULL);
        }

        ArtistNameValidations.validateName(eventname);
        return true;
    }

	public static boolean validateDate(LocalDate date) throws IllegalArgumentException {
        if (date == null) {
            throw new IllegalArgumentException(ErrorMessages.DATE_EVENT_NAME_NULL);
        }
        LocalDate currentDate = LocalDate.now();

        if (date.isBefore(currentDate)) {
            throw new IllegalArgumentException(ErrorMessages.DATE_EVENT_PASSED);
        }
        return true;
    }

    public static boolean validateTimeOfEvent(LocalDateTime timeOfEvent) throws IllegalArgumentException {
        if (timeOfEvent == null) {
            throw new IllegalArgumentException(ErrorMessages.TIME_OF_EVENT_NULL);
        }
        return true;
    }




	
}
