package com.fssa.glossyblends.errormessages;

public class ErrorMessages {

    private ErrorMessages() {
        // Private constructor to prevent instantiation
    }

    // Student-related Errors
    public static final String INVALID_STUDENT_NULL = "Student can't be null";

    // Artist-related Errors
    public static final String INVALID_ARTIST_ID_NULL = "Artist ID can't be null";
    public static final String INVALID_USERNAME_NULL = "Username can't be null";
    public static final String INVALID_EMAIL_NULL = "Email can't be null";
    public static final String INVALID_PHONE_NUMBER_NULL = "Phone number can't be NULL";
    public static final String INVALID_YEARS_OF_EXPERIENCE_NEGATIVE = "Years of experience can't be negative";
    public static final String INVALID_LOCATION_NULL = "Location can't be empty";
    public static final String INVALID_AVERAGE_RATING_NEGATIVE = "Average rating can't be negative";
    public static final String INVALID_PHONE_NUMBER_FORMAT = "Phone number not matches the correct format";
    public static final String INVALID_EMAIL_FORMAT = "Email not matches the correct format";
    public static final String INVALID_PASSWORD_NULL = "Password is null";
    public static final String INVALID_PASSWORD_PATTERN = "Password pattern is invalid";
    public static final String INVALID_LOCATION = "Invalid location";
    public static final String PASSWORD_NULL = "Pasword null";
    // Service-related Errors
    public static final String INVALID_SERVICE_OBJECT_NULL = "Service object can't be null";
    public static final String INVALID_SERVICE_NAME_NULL = "Service name can't be null";
    public static final String INVALID_SERVICE_PRICE_NULL = "Service price can't be null";
    public static final String INVALID_SERVICE_URL_NULL = "Service URL can't be null";
    public static final String INVALID_SERVICE_NAME_PATTERN = "Service name doesn't match the appropriate text format";
    public static final String INVALID_SERVICE_IMAGE_URL_FORMAT_PATTERN = "Service URL doesn't match the appropriate URL format";

    // Post-related Errors
    public static final String INVALID_POST_DESCRIPTION_NULL = "Post description is null";
    public static final String INVALID_POST_TITLE_NULL = "Post title is null";
    public static final String INVALID_POST_ID_NULL = "Post ID is null";
    public static final String DESCRIPTION_LENGTH_FORMAT = "Description length should be greater than 15";
    public static final String INVALID_SERVICE_FAIL_MSG = "Service name invalid, failed";

    
    // Event Schedule-related Errors
    public static final String INVALID_EVENT_NAME_NULL = "Event name is null";
    public static final String INVALID_DATE_EVENT_NULL = "Date of the event is null";
    public static final String INVALID_DATE_EVENT_PASSED = "Date of the event is already passed";
    public static final String INVALID_DATE_NULL="Date of the schedule is  null";
    public static final String INVALID_TIME_OF_EVENT_NULL = "Time of the event is null";
    public static final String INVALID_IMAGE_URL = "Invalid image URL";
    public static final String INVALID_LANGUAGE_NULL = "Invalid language is null";
    public static final String SCHEDULE_NULL_INVALID = "Schedule is null, invalid";

	


    
}
