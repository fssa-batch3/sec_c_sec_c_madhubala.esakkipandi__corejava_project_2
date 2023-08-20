package com.fssa.glossyblends.errormessages;

/**
 * This class contains a collection of error messages that are related to various aspects
 * of the application, specifically related to posts. These messages provide descriptive
 * information about the errors that can occur during the creation or handling of posts.
 * The class is designed to provide constant error message strings that can be used
 * throughout the application's codebase.
 */
public class PostErrorMessages {

    /**
     * Error message indicating that a post's description cannot be null.
     */
    public static final String INVALID_POST_DESCRIPTION_NULL = "Post description is null";

    /**
     * Error message indicating that a post's title cannot be null.
     */
    public static final String INVALID_POST_TITLE_NULL = "Post title is null";

    /**
     * Error message indicating that a post's ID cannot be null.
     */
    public static final String INVALID_POST_ID_NULL = "Post ID is null";

    /**
     * Error message indicating that a description length should be greater than 15 characters.
     */
    public static final String DESCRIPTION_LENGTH_FORMAT = "Description length should be greater than 15";

    /**
     * Error message indicating that a service name is invalid and the operation failed.
     */
    public static final String INVALID_SERVICE_FAIL_MSG = "Service name invalid, failed";

    /**
     * Error message indicating that the URL of an image cannot be null.
     */
    public static final String INVALID_IMAGE_URL_NULL = "URL of the image can't be null";

    /**
     * Error message indicating that the URL of an image should be in the correct URL format.
     */
    public static final String INVALID_IMAGE_URL_FORMAT = "URL of the image should be in correct URL format";
}
