package com.fssa.glossyblends.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.fssa.glossyblends.customexception.ArtistDetailsExceptions;
import com.fssa.glossyblends.errormessages.ArtistErrors;

/**
 * Validation utility class for password-related operations.
 */
public class PasswordValidations {

	// Private constructor to prevent instantiation
	private PasswordValidations() {
	}

	// Regular expression for enforcing password complexity:
	private static final String SECRET_PATTERN = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[a-zA-Z\\d]{8,}$";

	public static boolean validatePassword(String password) throws ArtistDetailsExceptions {
		if (password == null) {
			throw new ArtistDetailsExceptions(ArtistErrors.PASSWORD_NULL);
		}

		// Compile the pattern for password complexity
		Pattern pattern = Pattern.compile(SECRET_PATTERN);

		// Match the pattern against the given password
		Matcher matcher = pattern.matcher(password);

		// Check if the password matches the complexity pattern
		boolean valid = matcher.matches();

		if (!valid) {
			// Throw an exception if the password does not meet complexity requirements
			throw new ArtistDetailsExceptions(ArtistErrors.INVALID_PASSWORD_PATTERN);
		}

		return true;
	}
}
