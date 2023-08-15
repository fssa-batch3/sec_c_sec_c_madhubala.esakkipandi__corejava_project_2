package com.fssa.glossyblends.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.fssa.glossyblends.errormessages.ErrorMessages;

/**
 * Validation utility class for password-related operations.
 */
public class PasswordValidations {

    // Private constructor to prevent instantiation
    private PasswordValidations() {
    }

    // Regular expression for enforcing password complexity:
    private static final String COMPLEXITY_PATTERN = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[a-zA-Z\\d]{8,}$";

    /**
     * Validates a password for complexity and format.
     *
     * @param password The password to validate
     * @return True if the password is valid
     * @throws IllegalArgumentException if the password is null or does not meet complexity requirements
     */
    public static boolean validatePassword(String password) throws IllegalArgumentException {
        if (password == null) {
            throw new IllegalArgumentException(ErrorMessages.PASSWORD_NULL);
        } 

        // Compile the pattern for password complexity
        Pattern pattern = Pattern.compile(COMPLEXITY_PATTERN);

        // Match the pattern against the given password
        Matcher matcher = pattern.matcher(password);

        // Check if the password matches the complexity pattern
        boolean valid = matcher.matches();

        if (!valid) {
            // Throw an exception if the password does not meet complexity requirements
            throw new IllegalArgumentException(ErrorMessages.INVALID_PASSWORD_PATTERN);
        }

        return true;
    }
}
