package com.fssa.glossyblends.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.fssa.glossyblends.errormessages.ErrorMessages;
import com.fssa.glossyblends.errormessages.ServiceErrorMessges;

public class ArtistNameValidations {
	private ArtistNameValidations() {// default constructor for namevalidation with private access modifier

	}

	public static boolean validateName(String name) throws IllegalArgumentException {

		String serviceNameValidationPattern = "^[a-zA-Z\\s]+$";// pattern for name using regex

		Pattern pattern = Pattern.compile(serviceNameValidationPattern);// compile the regex pattern

		Matcher emialValidation = pattern.matcher(name);// checking the name with the regex pattern
		boolean isValid = emialValidation.matches();// it return the boolean value according to the input string

		if (!isValid) {// if not valid it will throw exception

			throw new IllegalArgumentException(ServiceErrorMessges.INVALID_SERVICE_NAME_PATTERN);

		}
		return true;// otherwise return true

	}

}
