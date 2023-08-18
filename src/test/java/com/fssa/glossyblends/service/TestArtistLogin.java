package com.fssa.glossyblends.service;

import java.sql.SQLException;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import com.fssa.glossyblends.artistservicelayer.ArtistLogin;
import com.fssa.glossyblends.customexception.DatabaseConnectionException;
import com.fssa.glossyblends.loginenum.LoginStatus;

/**
 * Unit tests for artist login functionality.
 */
class TestArtistLogin {

    /**
     * Test logging in with a valid user.
     * @throws DatabaseConnectionException 
     *
    */
	
    @Test
    void testValidUser() throws SQLException, DatabaseConnectionException {
        ArtistLogin artistLog = new ArtistLogin();

        LoginStatus isExists = artistLog.login("joo12@example.com", "TestPassword123");

        Assertions.assertEquals(LoginStatus.SUCCESS, isExists);
    }

    /**
     * Test logging in with a valid user but incorrect password.
     * @throws DatabaseConnectionException 
     */
    @Test
    void testValidUserWithInCorrectPassword() throws SQLException, DatabaseConnectionException {
        ArtistLogin artistLog = new ArtistLogin();

        LoginStatus isExists = artistLog.login("joo12@example.com", "TestPpassword123");

        Assertions.assertEquals(LoginStatus.INCORRECT_PASSWORD, isExists);
    }

    /**
     * Test logging in with an invalid user email.
     * @throws DatabaseConnectionException 
     *
     */
    @Test
    void testValidUserWithInValidUserEmail() throws SQLException, DatabaseConnectionException {
        ArtistLogin artistLog = new ArtistLogin();

        LoginStatus isExists = artistLog.login("j@example.com", "TestPpassword123");

        Assertions.assertEquals(LoginStatus.USER_NOT_FOUND, isExists);
    }
    
}
