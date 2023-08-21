package com.fssa.glossyblends.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.fssa.glossyblends.customexception.ArtistDetailsInvalidExceptions;
import com.fssa.glossyblends.errormessages.ErrorMessages;

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
	public static boolean validateNumber(String number) throws ArtistDetailsInvalidExceptions {

		// Regular expression pattern for a valid phone number
		String mobilePattern = "^\\d{7,15}$";

		// Compile the pattern
		Pattern pattern = Pattern.compile(mobilePattern);

		// Match the pattern against the given phone number
		Matcher patternMatching = pattern.matcher(number);

		// Check if the phone number matches the pattern
		boolean isValid = patternMatching.matches();

		if (!isValid) {
			// Throw an exception if the phone number format is invalid
			throw new ArtistDetailsInvalidExceptions(ErrorMessages.INVALID_PHONE_NUMBER_FORMAT);
		}
		return true;
	}
}
