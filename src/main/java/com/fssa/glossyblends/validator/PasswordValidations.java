package com.fssa.glossyblends.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.fssa.glossyblends.model.ErrorMessages;

public class PasswordValidations {

private PasswordValidations() {
		
		
	}
	 private static final String COMPLEXITY_PATTERN = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[a-zA-Z\\d]{8,}$";

	    // Regular expression for enforcing password complexity:
	    
	    public static boolean validatePassword(String password) throws IllegalArgumentException {
	        if (password == null) {
	            throw new IllegalArgumentException(ErrorMessages.PASSWORD_NULL);
	        }
        Pattern pattern = Pattern.compile(COMPLEXITY_PATTERN);
        Matcher matcher = pattern.matcher(password);
        boolean valid = matcher.matches();

	

		if (!valid) {
			throw new IllegalArgumentException(ErrorMessages.PASSWORD_INVALID_PATTERN);
		}

		return true;
	}
}
