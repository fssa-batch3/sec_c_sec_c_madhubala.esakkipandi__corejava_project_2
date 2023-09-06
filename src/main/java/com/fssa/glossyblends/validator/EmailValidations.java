package com.fssa.glossyblends.validator;

import java.util.regex.Pattern;
import java.util.regex.Matcher;
import com.fssa.glossyblends.customexception.ArtistDetailsExceptions;
import com.fssa.glossyblends.errormessages.ArtistErrors;

/**
 * Validation utility class for email validation.
 */
public class EmailValidations {

    // Private constructor to prevent instantiation
    private EmailValidations() {
    }

    /**
     * Validates the format of an email address.
     */
    public static boolean validateEmail(String email) throws ArtistDetailsExceptions {

    	String regexEmail = "^[a-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
		Pattern pattern = Pattern.compile(regexEmail); // compiles the given pattern
		Matcher matcher = pattern.matcher(email); // matcher matches the given string with compiled pattern
		boolean isMatch = matcher.matches(); // give final output as true or false
		if (isMatch != true) {

			throw new ArtistDetailsExceptions(ArtistErrors.INVALID_EMAIL_FORMAT);
		}
		return isMatch;
    }

    public static void main(String[] args) throws ArtistDetailsExceptions {
        validateEmail("dharun@gamil.com");
    }
}
