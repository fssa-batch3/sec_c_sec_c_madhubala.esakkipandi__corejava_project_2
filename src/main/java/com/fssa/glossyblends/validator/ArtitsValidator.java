package com.fssa.glossyblends.validator;

import java.util.List;
import java.util.regex.Pattern;

import com.fssa.glossyblends.customexception.ArtistDetailsExceptions;
import com.fssa.glossyblends.customexception.ScheduleValueInvalidException;
import com.fssa.glossyblends.customexception.ServiceValueInvalidException;
import com.fssa.glossyblends.errormessages.ArtistErrors;
import com.fssa.glossyblends.errormessages.ScheduleErrors;
import com.fssa.glossyblends.model.Artist;
import com.fssa.glossyblends.model.Artist.gender;
import com.fssa.glossyblends.model.Schedule;
import com.fssa.glossyblends.model.Services;

/**
 * Validation utility class for validating Artist objects and associated data.
 */
public class ArtitsValidator {

	
	// Private constructor to prevent instantiation
	private ArtitsValidator() {
	}

	/**
	 * Validates an Artist object.
	 *
	 */
	public static boolean validateArtist(Artist artist) throws ArtistDetailsExceptions {
		if (artist == null) {
			throw new ArtistDetailsExceptions("Artist object is null");
		}

		validateUsername(artist.getUsername());
		validatePassword(artist.getPassword());
		validateEmail(artist.getEmail());
		validatePhoneNumber(artist.getPhonenNumber());
		validateYearsOfExperience(artist.getYearsOfExperience());
		validateIsAvailable(artist.isAvailable());
		validateLanguagesSpoken(artist.getLanguagesSpoken());
		validateLocation(artist.getLocation());
		validateGender(artist.getGenderOfArtist());

		return true;
	}

	// Validations for a list of provided services
	public static boolean validateService(List<Services> providingServices)
			throws IllegalArgumentException, ServiceValueInvalidException {
		for (Services service : providingServices) {
			ServiceValidations.validateService(service);
		}
		return true;
	}

	// Validations for a list of schedules
	public static boolean validateschedule(List<Schedule> scheduleList) throws ScheduleValueInvalidException, ArtistDetailsExceptions {
		if (scheduleList == null || scheduleList.isEmpty()) {
			throw new ScheduleValueInvalidException(ScheduleErrors.SCHEDULE_NULL_INVALID);
		}

		for (Schedule sch : scheduleList) {
			ScheduleValidations.validateSchedule(sch);
		}
		return true;
	}

	// Validation for userName
	public static boolean validateUsername(String username) throws ArtistDetailsExceptions {
		if (username == null) {
			throw new ArtistDetailsExceptions(ArtistErrors.INVALID_USERNAME_NULL);
		}

		ArtistNameValidations.validateName(username);

		return true;
	}

	// Validation for password
	public static boolean validatePassword(String password) throws ArtistDetailsExceptions {
		PasswordValidations.validatePassword(password);
		return true;
	}

	// Validation for email
	public static boolean validateEmail(String email) throws ArtistDetailsExceptions {
		if (email == null || email.trim().isEmpty()) {
			throw new ArtistDetailsExceptions(ArtistErrors.INVALID_EMAIL_NULL);
		}
		EmailValidations.validateEmail(email);
		return true;
	}

	// Validation for phoneNumber
	public static boolean validatePhoneNumber(String phoneNumber) throws ArtistDetailsExceptions {
		if (phoneNumber == null || phoneNumber.trim().isEmpty()) {
			throw new ArtistDetailsExceptions(ArtistErrors.INVALID_PHONE_NUMBER_NULL);
		}
		PhoneNumberValidations.validateNumber(phoneNumber);
		return true;
	}

	// Validation of years of experience
	public static boolean validateYearsOfExperience(int yearsOfExperience) throws ArtistDetailsExceptions {
		if (yearsOfExperience <= 0) {
			throw new ArtistDetailsExceptions(ArtistErrors.INVALID_YEARS_OF_EXPERIENCE_NEGATIVE);
		}
		return true;
	}

	// Validation for availability
	public static boolean validateIsAvailable(boolean isAvailable) throws ArtistDetailsExceptions {
		
	
	
		return true;
	}

	// Validation for languagesSpoken
	public static boolean validateLanguagesSpoken(String languageSpoken) throws ArtistDetailsExceptions {
		if (languageSpoken == null || languageSpoken.isEmpty()) {
			throw new ArtistDetailsExceptions(ArtistErrors.INVALID_LANGUAGE);
		}
		return true;
	}

	
	// Validation for location
	public static boolean validateLocation(String location) throws ArtistDetailsExceptions {
		if (location == null) {
			throw new ArtistDetailsExceptions(ArtistErrors.INVALID_LOCATION_NULL);
		}

		List<String> allowedLocations = LocationValidator.getAllowedLocations();
		if (!allowedLocations.contains(location)) {
			throw new ArtistDetailsExceptions(ArtistErrors.INVALID_LOCATION);
		}
		return true;
	}

	
	

	// Validate gender
	public static boolean validateGender(gender genderOfArtist) throws ArtistDetailsExceptions {
		if (genderOfArtist == null) {
			throw new ArtistDetailsExceptions("Gender of artist is required");
		}
		return true;
		
	}
	
}
