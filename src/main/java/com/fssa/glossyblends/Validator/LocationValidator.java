package com.fssa.glossyblends.Validator;
import java.util.Arrays;
import java.util.List;

public class LocationValidator {
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

    // Method to get the allowed locations
    public static List<String> getAllowedLocations() {
        return allowedLocations;
    }
}
