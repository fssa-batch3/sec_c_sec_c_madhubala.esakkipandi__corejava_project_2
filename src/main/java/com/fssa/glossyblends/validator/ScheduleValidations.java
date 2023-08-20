package com.fssa.glossyblends.validator;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.fssa.glossyblends.customexception.ScheduleValueInvalidException;
import com.fssa.glossyblends.errormessages.ErrorMessages;
import com.fssa.glossyblends.errormessages.SchduleErrorMessages;
import com.fssa.glossyblends.model.Schedule;

public class ScheduleValidations {
	private static final ScheduleValidations instance = new ScheduleValidations();

	private ScheduleValidations() {
	}

	public static boolean validateSchedule(Schedule listOfSchedule) throws ScheduleValueInvalidException {
		try {
			validateName(listOfSchedule.getEventName());
			validateDate(listOfSchedule.getDate());
			validateTimeOfEvent(listOfSchedule.getTimeOfEvent());
			return true;
		} catch (ScheduleValueInvalidException ex) {
			ex.printStackTrace();
		}
		return false;
	}

	public static boolean validateName(String eventname) throws ScheduleValueInvalidException {
		if (eventname == null) {
			throw new ScheduleValueInvalidException(SchduleErrorMessages.INVALID_EVENT_NAME_NULL);
		}
		ArtistNameValidations.validateName(eventname);
		return true;
	}

	public static boolean validateDate(LocalDate date) throws ScheduleValueInvalidException {
		if (date == null) {
			throw new ScheduleValueInvalidException(SchduleErrorMessages.INVALID_DATE_NULL);
		}
		LocalDate currentDate = LocalDate.now();
		if (date.isBefore(currentDate)) {
			throw new ScheduleValueInvalidException(SchduleErrorMessages.INVALID_DATE_EVENT_PASSED);
		}
		return true;
	}

	public static boolean validateTimeOfEvent(LocalDateTime timeOfEvent) throws ScheduleValueInvalidException {
		if (timeOfEvent == null) {
			throw new ScheduleValueInvalidException(SchduleErrorMessages.INVALID_TIME_OF_EVENT_NULL);
		}
		return true;
	}
}
