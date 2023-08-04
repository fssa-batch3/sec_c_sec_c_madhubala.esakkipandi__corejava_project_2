package com.fssa.glossyblends.Validator;

import java.util.List;
import java.util.regex.Pattern;

import com.fssa.glossyblends.CustomException.PostValueInvalidException;
import com.fssa.glossyblends.CustomException.ServiceValueInvalidException;
//import com.fssa.glossyblends.Validator.ServiceValidations;
import com.fssa.glossyblends.model.Artist.Artist;
import com.fssa.glossyblends.model.Artist.ErrorMessages;
import com.fssa.glossyblends.model.Artist.Post;
import com.fssa.glossyblends.model.Artist.Services;
import com.fssa.glossyblends.model.Artist.schedule;

public class ArtitsValidator {
	public static boolean validateArtist(Artist artist)
			throws IllegalArgumentException, PostValueInvalidException, ServiceValueInvalidException {
		if (artist == null) {
			throw new IllegalArgumentException("Artist object is null");
		}
		

//        validateArtistId(artist.getArtistId());
		validateUsername(artist.getUsername());
		validatePassword(artist.getPassword());
		validateEmail(artist.getEmail());
		validatePhoneNumber(artist.getPhone_number());
		validateYearsOfExperience(artist.getYearsOfExperience());
		validateIsAvailable(artist.isAvailable());
//        validateSocialMediaLinks(artist.getSocialMediaLinks());
		validateLanguagesSpoken(artist.getLanguagesSpoken());
		validateLocation(artist.getLocation());
//        validatePost(artist.getWorkLink()); 
		// Corrected method name here, using getWorkLink()
//        validateschedule(artist.getWorkingDaysCalender());

//        validateService(artist.getProvidingServices());

//    

		return true;

	}

//	validations for service list in artist class
	public static boolean validateService(List<Services> providingServices)
			throws IllegalArgumentException, ServiceValueInvalidException {
		for (Services service : providingServices) {

			ServiceValidations.validateService(service);
		}

		return true;
	}

	// Validations for list of posts
//  public static boolean validatePost(List<Post> postWorks) throws PostValueInvalidException {
//       for (Post post : postWorks) {
//           PostValidations.validatePost(post);
//       }
//      return true;
//    }

	// Validations for list of posts
	public static boolean validateschedule(List<schedule> scheduleList) throws PostValueInvalidException {
		if (scheduleList == null || scheduleList.isEmpty()) {
			throw new PostValueInvalidException(ErrorMessages.SHEDULE_NULL_INVALID);
		}

		for (schedule sch : scheduleList) {
			ScheduleValidations.validateSchedule(sch);
		}

		return true;
	}

	// Validation for userName
	public static boolean validateUsername(String username) throws IllegalArgumentException {
		if (username == null) {
			throw new IllegalArgumentException(ErrorMessages.INVALID_USERNAME_NULL);
		}

		ArtistNameValidations.validateName(username);

		return true;

	}

	// Validation for password
	public static boolean validatePassword(String password) throws IllegalArgumentException {

		PasswordValidations.ValidatePassword(password);
		return true;

	}

//validation for email
	public static boolean validateEmail(String email) throws IllegalArgumentException {
		if (email == null || email.trim().isEmpty()) {
			throw new IllegalArgumentException(ErrorMessages.INVALID_EMAIL_NULL);
		}

		EmailValidations.validateEmail(email);
		return true;
	}

	// Validation for phoneNumber
	public static boolean validatePhoneNumber(String phoneNumber) throws IllegalArgumentException {
		if (phoneNumber == null || phoneNumber.trim().isEmpty()) {
			throw new IllegalArgumentException(ErrorMessages.INVALID_PHONE_NUMBER_NULL);
		}
		phoneNumberValidations.validateNumber(phoneNumber);
		return true;
	}

	// validation of year of experience

	public static boolean validateYearsOfExperience(int yearsOfExperience) throws IllegalArgumentException {

		if (yearsOfExperience <= 0) {
			throw new IllegalArgumentException(ErrorMessages.INVALID_YEARS_OF_EXPERIENCE_NEGATIVE);
		}
		return true;

	}

	public static boolean validateIsAvailable(boolean isAvailable) throws IllegalArgumentException {
		return true;
	}

	// Validation for languagesSpoken
	public static boolean validateLanguagesSpoken(String languageSpoken) throws IllegalArgumentException {
		if (languageSpoken == null || languageSpoken.isEmpty()) {
			throw new IllegalArgumentException(ErrorMessages.INVALID_LANGUAGE_NULL);
		}
		return true;
	}

	// validate location
	public static boolean validateLocation(String location) throws IllegalArgumentException {
		if (location == null) {
			throw new IllegalArgumentException(ErrorMessages.INVALID_LOCATION_NULL);
		}

		List<String> allowedLocations = LocationValidator.getAllowedLocations();
		if (!allowedLocations.contains(location)) {
			throw new IllegalArgumentException(ErrorMessages.INVALID_LOCATION);
		}
		return true;
	}

	// validation for ssocial media link

	public static boolean validateSocialMediaLinks(List<String> socialMediaLinks) throws IllegalArgumentException {
		if (socialMediaLinks == null || socialMediaLinks.isEmpty()) {
			throw new IllegalArgumentException("Social media links cannot be empty or null.");
		}

		for (String link : socialMediaLinks) {
			if (!isValidSocialMediaLink(link)) {
				throw new IllegalArgumentException("Invalid social media link: " + link);
			}
		}

		return true;
	}

	// Helper method to check if a single social media link is valid
	private static boolean isValidSocialMediaLink(String link) throws IllegalArgumentException {
		if (link == null || link.trim().isEmpty()) {
			return false;
		}

		Pattern pattern = Pattern.compile("^https?://");

		return pattern.matcher(link).find();

	}
}
