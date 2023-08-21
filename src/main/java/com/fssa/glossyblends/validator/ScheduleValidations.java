package com.fssa.glossyblends.validator;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.fssa.glossyblends.customexception.ArtistDetailsInvalidExceptions;
import com.fssa.glossyblends.customexception.ScheduleValueInvalidException;
import com.fssa.glossyblends.errormessages.ScheduleErrorMessages;
import com.fssa.glossyblends.model.Schedule;

public class ScheduleValidations {

	private ScheduleValidations() {
		
	}

	public static boolean validateSchedule(Schedule listOfSchedule) throws ScheduleValueInvalidException, ArtistDetailsInvalidExceptions {
		try {
			validateName(listOfSchedule.getEventName());
			validateDate(listOfSchedule.getDate());
			validateTimeOfEvent(listOfSchedule.getTimeOfEvent());
		return true;
		} catch (ScheduleValueInvalidException ex) {
			ex.getMessage();
		}
		return false;
	}

	public static boolean validateName(String eventname) throws ScheduleValueInvalidException, ArtistDetailsInvalidExceptions {
		if (eventname == null) {
			throw new ScheduleValueInvalidException(ScheduleErrorMessages.INVALID_EVENT_NAME_NULL);
			
		}
		ArtistNameValidations.validateName(eventname);
		return true;
	}

	public static boolean validateDate(LocalDate date) throws ScheduleValueInvalidException {
		if (date == null) {
			throw new ScheduleValueInvalidException(ScheduleErrorMessages.INVALID_DATE_NULL);
		}
		LocalDate currentDate = LocalDate.now();
		if (date.isBefore(currentDate)) {
			throw new ScheduleValueInvalidException(ScheduleErrorMessages.INVALID_DATE_EVENT_PASSED);
		}
		return true;
	}

	public static boolean validateTimeOfEvent(LocalDateTime timeOfEvent) throws ScheduleValueInvalidException {
		if (timeOfEvent == null) {
			throw new ScheduleValueInvalidException(ScheduleErrorMessages.INVALID_TIME_OF_EVENT_NULL);
		}
		return true;
	}
}
