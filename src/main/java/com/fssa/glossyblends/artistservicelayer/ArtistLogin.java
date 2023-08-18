package com.fssa.glossyblends.artistservicelayer;

import java.sql.SQLException;

import com.fssa.glossyblends.customexception.DatabaseConnectionException;
import com.fssa.glossyblends.dao.ArtistLoginDAO;
import com.fssa.glossyblends.loginenum.LoginStatus;

public class ArtistLogin {

  
    
    // Method to handle artist login
    public LoginStatus login(String username, String password) throws SQLException, DatabaseConnectionException {
        // Check if user (email) exists in the database
        boolean userExists = ArtistLoginDAO.validateUserExists(username);
        if (userExists) {
            // Validate login using the ArtistLoginDAO
            boolean isValidLogin = ArtistLoginDAO.validateLogin(username, password);
            if (isValidLogin) {
                return LoginStatus.SUCCESS;
            } else {
                return LoginStatus.INCORRECT_PASSWORD; // Incorrect password
            }
        } else {
            return LoginStatus.USER_NOT_FOUND; // User not found
        }
    }
}
