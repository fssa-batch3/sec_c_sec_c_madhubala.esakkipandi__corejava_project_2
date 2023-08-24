package com.fssa.glossyblends.validator;

import java.util.regex.Pattern;

import com.fssa.glossyblends.customexception.ArtistDetailsExceptions;
import com.fssa.glossyblends.errormessages.ArtistErrors;
import java.util.regex.Matcher;

/**
 * Validation utility class for email validation.
 */
public class EmailValidations {

	// Private constructor to prevent instantiation
	private EmailValidations() {
	}

	/**
	 * Validates the format of an email address.
	 *
	 */
	public static void validateEmail(String email) throws ArtistDetailsExceptions {

		if (email == null) {
			throw new ArtistDetailsExceptions(ArtistErrors.INVALID_EMAIL_NULL);
		}

		// Regular expression pattern to match valid email addresses
		String regex = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(email);

		// Check if the email matches the pattern
		if (!matcher.matches()) {
			throw new ArtistDetailsExceptions(ArtistErrors.INVALID_EMAIL_FORMAT);
		}
	}
}
