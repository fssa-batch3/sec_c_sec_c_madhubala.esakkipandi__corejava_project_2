package com.fssa.glossyblends.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.fssa.glossyblends.customexception.DatabaseConnectionException;
import com.fssa.glossyblends.util.ConnectionUtil;
/**
 * Data Access Object (DAO) for managing login data in the database.
 */

public class ArtistLoginDAO {

    // Private constructor to prevent instantiation
    private ArtistLoginDAO() {
        
    }
    
    // Validate login using email and password
    public static boolean validateLogin(String email, String password) throws DatabaseConnectionException {
        try (Connection connection = ConnectionUtil.getConnection()) {
            try (PreparedStatement stmt = connection.prepareStatement(
                    "SELECT COUNT(*) as count FROM artists WHERE email = ? AND password = ?")) {
                stmt.setString(1, email);
                stmt.setString(2, password);

                try (ResultSet rs = stmt.executeQuery()) {
                    if (rs.next()) {
                        int count = rs.getInt("count");
                        return count > 0; // Return true if login is valid
                    }
                }
            }
        } catch (SQLException e) {
        	
            e.printStackTrace();
        }
        return false; // Return false if login validation fails
    }

    // Validate if a user with the given email exists
    public static boolean validateUserExists(String email) throws SQLException, DatabaseConnectionException {
        try (Connection connection = ConnectionUtil.getConnection()) {
            try (PreparedStatement stmt = connection.prepareStatement(
                    "SELECT COUNT(*) as count FROM artists WHERE email = ? ")) {
                stmt.setString(1, email);
              
                try (ResultSet rs = stmt.executeQuery()) {
                    if (rs.next()) {
                        int count = rs.getInt("count");
                        return count > 0; // Return true if user with the email exists
                    }
                }
                
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return false; // Return false if user validation fails or does not exist
    }
}
