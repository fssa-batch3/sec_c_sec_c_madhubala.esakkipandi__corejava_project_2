package com.fssa.glossyblends.validator;

import java.util.regex.Pattern;

import com.fssa.glossyblends.model.ErrorMessages;

import java.util.regex.Matcher;

public class EmailValidations {

	// Validation for email
	public static void validateEmail(String email) throws IllegalArgumentException {

		if (email == null) {

			throw new IllegalArgumentException(ErrorMessages.INVALID_EMAIL_NULL);

		}

		String regex = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(email);
		if (!matcher.matches()) {
			throw new IllegalArgumentException(ErrorMessages.INVALID_EMAIL_FORMAT);
		}
	}
}