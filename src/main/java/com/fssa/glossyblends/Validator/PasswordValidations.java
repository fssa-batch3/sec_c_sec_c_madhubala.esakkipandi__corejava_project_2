package com.fssa.glossyblends.Validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.fssa.glossyblends.model.ErrorMessages;

public class PasswordValidations {

	public static boolean validatePassword(String password) throws IllegalArgumentException {
		if (password == null) {
			throw new IllegalArgumentException(ErrorMessages.PASSWORD_NULL);
		}

		String passwordPattern = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[a-zA-Z\\d]{8,}$";
		Pattern pattern = Pattern.compile(passwordPattern);
		Matcher matcher = pattern.matcher(password);

		boolean valid = matcher.matches();

		if (!valid) {
			throw new IllegalArgumentException(ErrorMessages.PASSWORD_INVALID_PATTERN);
		}

		return true;
	}
}
