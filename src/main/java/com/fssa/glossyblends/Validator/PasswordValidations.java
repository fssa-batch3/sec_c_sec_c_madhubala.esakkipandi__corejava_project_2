package com.fssa.glossyblends.Validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.fssa.glossyblends.model.ErrorMessages;

public class PasswordValidations {

	private static final String PASSWORD_PATTERN = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[a-zA-Z\\d]{8,}$";

    public static boolean validatePassword(String password) throws IllegalArgumentException {
        if (password == null) {
            throw new IllegalArgumentException(ErrorMessages.PASSWORD_NULL);
        }

        Pattern pattern = Pattern.compile(PASSWORD_PATTERN);
        Matcher matcher = pattern.matcher(password);
        boolean valid = matcher.matches();

	

		if (!valid) {
			throw new IllegalArgumentException(ErrorMessages.PASSWORD_INVALID_PATTERN);
		}

		return true;
	}
}
