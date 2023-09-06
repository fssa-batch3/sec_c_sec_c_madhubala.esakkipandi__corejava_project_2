package com.fssa.glossyblends.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.fssa.glossyblends.customexception.ArtistDetailsExceptions;
import com.fssa.glossyblends.errormessages.ArtistErrors;
import com.fssa.glossyblends.errormessages.ServiceErrors;

public class ArtistNameValidations {
	private ArtistNameValidations() {// default constructor for namevalidation with private access modifier

	}

	public static boolean validateName(String name) throws ArtistDetailsExceptions {

		String serviceNameValidationPattern = "^[a-zA-Z\\s]+$";// pattern for name using regex

		Pattern pattern = Pattern.compile(serviceNameValidationPattern);// compile the regex pattern

		Matcher emialValidation = pattern.matcher(name);// checking the name with the regex pattern
		boolean isValid = emialValidation.matches();// it return the boolean value according to the input string

		if (!isValid) {// if not valid it will throw exception

			throw new ArtistDetailsExceptions(ArtistErrors.INVALID_USERNAME_PATTERN);

		}
		return false;// otherwise return true

	}

}
