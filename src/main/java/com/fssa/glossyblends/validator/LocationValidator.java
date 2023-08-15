package com.fssa.glossyblends.validator;

import java.util.Arrays;
import java.util.List;

/**
 * Validation utility class for location-related operations.
 */
public class LocationValidator {
    
    // Private constructor to prevent instantiation
    private LocationValidator() {
    }
    
    // List of allowed locations
    private static final List<String> allowedLocations = Arrays.asList(
        "chennai", "tirunelveli", "coimbatore", "trichy", 
        "madurai", "salem", "erode", "vellore", 
        "tuticorin", "thoothukudi", "kanyakumari", "thanjavur", 
        "kanchipuram", "thiruvallur", "tiruppur", "karur", 
        "virudhunagar", "nagercoil", "ooty", "krishnagiri", 
        "sivaganga", "cuddalore", "ranipet", "nellai", 
        "dharmapuri", "namakkal", "sankarankovil", "rishivandiyam", 
        "thiruvarur", "theni", "pollachi", "mayiladuthurai"
    );

    /**
     * Get the list of allowed locations.
     *
     * @return List of allowed locations
     */
    public static List<String> getAllowedLocations() {
        return allowedLocations;
    }
}
