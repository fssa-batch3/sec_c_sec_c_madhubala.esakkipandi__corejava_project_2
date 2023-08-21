package com.fssa.glossyblends.validator;

import java.util.List;
import java.util.regex.Pattern;

import com.fssa.glossyblends.customexception.ArtistDetailsInvalidExceptions;
import com.fssa.glossyblends.customexception.ScheduleValueInvalidException;
import com.fssa.glossyblends.customexception.ServiceValueInvalidException;
import com.fssa.glossyblends.errormessages.ErrorMessages;
import com.fssa.glossyblends.errormessages.ScheduleErrorMessages;
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
	public static boolean validateArtist(Artist artist) throws ArtistDetailsInvalidExceptions {
		if (artist == null) {
			throw new ArtistDetailsInvalidExceptions("Artist object is null");
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
	public static boolean validateschedule(List<Schedule> scheduleList) throws ScheduleValueInvalidException, ArtistDetailsInvalidExceptions {
		if (scheduleList == null || scheduleList.isEmpty()) {
			throw new ScheduleValueInvalidException(ScheduleErrorMessages.SCHEDULE_NULL_INVALID);
		}

		for (Schedule sch : scheduleList) {
			ScheduleValidations.validateSchedule(sch);
		}
		return true;
	}

	// Validation for userName
	public static boolean validateUsername(String username) throws ArtistDetailsInvalidExceptions {
		if (username == null) {
			throw new ArtistDetailsInvalidExceptions(ErrorMessages.INVALID_USERNAME_NULL);
		}

		ArtistNameValidations.validateName(username);

		return true;
	}

	// Validation for password
	public static boolean validatePassword(String password) throws ArtistDetailsInvalidExceptions {
		PasswordValidations.validatePassword(password);
		return true;
	}

	// Validation for email
	public static boolean validateEmail(String email) throws ArtistDetailsInvalidExceptions {
		if (email == null || email.trim().isEmpty()) {
			throw new ArtistDetailsInvalidExceptions(ErrorMessages.INVALID_EMAIL_NULL);
		}
		EmailValidations.validateEmail(email);
		return true;
	}

	// Validation for phoneNumber
	public static boolean validatePhoneNumber(String phoneNumber) throws ArtistDetailsInvalidExceptions {
		if (phoneNumber == null || phoneNumber.trim().isEmpty()) {
			throw new ArtistDetailsInvalidExceptions(ErrorMessages.INVALID_PHONE_NUMBER_NULL);
		}
		PhoneNumberValidations.validateNumber(phoneNumber);
		return true;
	}

	// Validation of years of experience
	public static boolean validateYearsOfExperience(int yearsOfExperience) throws ArtistDetailsInvalidExceptions {
		if (yearsOfExperience <= 0) {
			throw new ArtistDetailsInvalidExceptions(ErrorMessages.INVALID_YEARS_OF_EXPERIENCE_NEGATIVE);
		}
		return true;
	}

	// Validation for availability
	public static boolean validateIsAvailable(boolean isAvailable) throws ArtistDetailsInvalidExceptions {
		
	
	
		return true;
	}

	// Validation for languagesSpoken
	public static boolean validateLanguagesSpoken(String languageSpoken) throws ArtistDetailsInvalidExceptions {
		if (languageSpoken == null || languageSpoken.isEmpty()) {
			throw new ArtistDetailsInvalidExceptions(ErrorMessages.INVALID_LANGUAGE);
		}
		return true;
	}

	
	// Validation for location
	public static boolean validateLocation(String location) throws ArtistDetailsInvalidExceptions {
		if (location == null) {
			throw new ArtistDetailsInvalidExceptions(ErrorMessages.INVALID_LOCATION_NULL);
		}

		List<String> allowedLocations = LocationValidator.getAllowedLocations();
		if (!allowedLocations.contains(location)) {
			throw new ArtistDetailsInvalidExceptions(ErrorMessages.INVALID_LOCATION);
		}
		return true;
	}

	// Validation for social media links
	public static boolean validateSocialMediaLinks(List<String> socialMediaLinks) throws ArtistDetailsInvalidExceptions {
		if (socialMediaLinks == null || socialMediaLinks.isEmpty()) {
			throw new ArtistDetailsInvalidExceptions("Social media links cannot be empty or null.");
		}

		for (String link : socialMediaLinks) {
			if (!isValidSocialMediaLink(link)) {
				throw new ArtistDetailsInvalidExceptions("Invalid social media link: " + link);
			}
		}
		return true;
	}

	// Validate social media link
	private static boolean isValidSocialMediaLink(String link) {
		if (link == null || link.trim().isEmpty()) {
			return false;
		}
		Pattern pattern = Pattern.compile("^https?://");
		return pattern.matcher(link).find();
	}

	// Validate gender
	public static boolean validateGender(gender genderOfArtist) throws ArtistDetailsInvalidExceptions {
		if (genderOfArtist == null) {
			throw new ArtistDetailsInvalidExceptions("Gender of artist is required");
		}
		return true;
		
	}
	
}
