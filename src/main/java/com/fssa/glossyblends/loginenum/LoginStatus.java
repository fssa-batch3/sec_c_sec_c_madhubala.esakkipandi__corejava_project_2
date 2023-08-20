package com.fssa.glossyblends.loginenum;

/**
 * This enum represents the possible login status values that can occur when attempting
 * to log in a user. Each status corresponds to a specific outcome of the login attempt.
 * The enum provides a set of predefined values that can be used to represent different
 * login scenarios and outcomes in the application.
 */
public enum LoginStatus {
    /**
     * Represents a successful login attempt.
     */
    SUCCESS,
    
    /**
     * Represents a login attempt where the user was not found in the system.
     */
    USER_NOT_FOUND,
    
    /**
     * Represents a login attempt where the provided password was incorrect.
     */
    INCORRECT_PASSWORD
}
