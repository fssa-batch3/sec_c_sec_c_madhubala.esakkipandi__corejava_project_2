package com.fssa.glossyblends.errormessages;

/**
 * This class contains a collection of error messages that are related to various aspects
 * of the application, such as artist-related errors. These messages provide descriptive
 * information about the errors that can occur during the execution of the application.
 * The class is designed to provide constant error message strings that can be used
 * throughout the application's codebase.
 */
public class ErrorMessages {

    /**
     * Private constructor to prevent instantiation of this utility class.
     */
    private ErrorMessages() {
        // Private constructor to prevent instantiation
    }

    // Artist-related Errors

    /**
     * Error message indicating that an artist's ID cannot be null.
     */
    public static final String INVALID_ARTIST_ID_NULL = "Artist ID can't be null";

    /**
     * Error message indicating that a username cannot be null.
     */
    public static final String INVALID_USERNAME_NULL = "Username can't be null";

    /**
     * Error message indicating that an email address cannot be null.
     */
    public static final String INVALID_EMAIL_NULL = "Email can't be null";

    /**
     * Error message indicating that a phone number cannot be null.
     */
    public static final String INVALID_PHONE_NUMBER_NULL = "Phone number can't be NULL";

    /**
     * Error message indicating that years of experience cannot be negative.
     */
    public static final String INVALID_YEARS_OF_EXPERIENCE_NEGATIVE = "Years of experience can't be negative";

    /**
     * Error message indicating that a location cannot be empty.
     */
    public static final String INVALID_LOCATION_NULL = "Location can't be empty";

    /**
     * Error message indicating that an average rating cannot be negative.
     */
    public static final String INVALID_AVERAGE_RATING_NEGATIVE = "Average rating can't be negative";

    /**
     * Error message indicating that a phone number does not match the correct format.
     */
    public static final String INVALID_PHONE_NUMBER_FORMAT = "Phone number does not match the correct format";

    /**
     * Error message indicating that an email address does not match the correct format.
     */
    public static final String INVALID_EMAIL_FORMAT = "Email does not match the correct format";

    /**
     * Error message indicating that a password cannot be null.
     */
    public static final String INVALID_PASSWORD_NULL = "Password is null";

    /**
     * Error message indicating that a password's pattern is invalid.
     */
    public static final String INVALID_PASSWORD_PATTERN = "Password pattern is invalid";

    /**
     * Error message indicating that a location is invalid.
     */
    public static final String INVALID_LOCATION = "Invalid location";

    /**
     * Error message indicating that a password is null.
     */
    public static final String PASSWORD_NULL = "Password null";

    /**
     * Error message indicating that a language should not be null.
     */
    public static final String INVALID_LANGUAGE = "Language should not be null";
}
