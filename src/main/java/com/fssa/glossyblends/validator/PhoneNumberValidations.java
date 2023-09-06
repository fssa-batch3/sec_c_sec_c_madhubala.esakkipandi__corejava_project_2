package com.fssa.glossyblends.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.fssa.glossyblends.customexception.ArtistDetailsExceptions;
import com.fssa.glossyblends.errormessages.ArtistErrors;

/**
 * Validation utility class for phone number-related operations.
 */
public class PhoneNumberValidations {

	// Private constructor to prevent instantiation
	private PhoneNumberValidations() {
	}

	/**
	 * Validates a phone number using a regular expression pattern.
	 *
	 */
	// Validation for phoneNumber
	public static boolean validatePhoneNumber(long phoneNumber) throws ArtistDetailsExceptions {
	    String phoneNumberString = String.valueOf(phoneNumber);
	    
	    if (phoneNumberString.isEmpty()) {
	        throw new ArtistDetailsExceptions(ArtistErrors.INVALID_PHONE_NUMBER_NULL);
	    }
	    
	    if (!phoneNumberString.matches("^\\d{9}$")) {
	        throw new ArtistDetailsExceptions(ArtistErrors.INVALID_PHONE_NUMBER_FORMAT);
	    }
	    
	    return true;
	}

}
