package com.fssa.glossyblends.errormessages;

/**
 * This class contains a collection of error messages that are related to various aspects
 * of the application, specifically related to scheduling and events. These messages
 * provide descriptive information about the errors that can occur during the scheduling
 * and handling of events. The class is designed to provide constant error message strings
 * that can be used throughout the application's codebase.
 */
public class SchduleErrorMessages {

    /**
     * Error message indicating that an event name cannot be null.
     */
    public static final String INVALID_EVENT_NAME_NULL = "Event name is null";

    /**
     * Error message indicating that the date of an event cannot be null.
     */
    public static final String INVALID_DATE_EVENT_NULL = "Date of the event is null";

    /**
     * Error message indicating that the date of an event is already in the past.
     */
    public static final String INVALID_DATE_EVENT_PASSED = "Date of the event is already passed";

    /**
     * Error message indicating that the date of a schedule cannot be null.
     */
    public static final String INVALID_DATE_NULL = "Date of the schedule is null";

    /**
     * Error message indicating that the time of an event cannot be null.
     */
    public static final String INVALID_TIME_OF_EVENT_NULL = "Time of the event is null";

    /**
     * Error message indicating that an image URL is invalid.
     */
    public static final String INVALID_IMAGE_URL = "Invalid image URL";

    /**
     * Error message indicating that a language cannot be null.
     */
    public static final String INVALID_LANGUAGE_NULL = "Invalid language is null";

    /**
     * Error message indicating that a schedule is null and invalid.
     */
    public static final String SCHEDULE_NULL_INVALID = "Schedule is null, invalid";
}
