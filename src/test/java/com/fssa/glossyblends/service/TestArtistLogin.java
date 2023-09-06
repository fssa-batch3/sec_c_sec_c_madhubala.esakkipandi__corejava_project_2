package com.fssa.glossyblends.service;

import java.sql.SQLException;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.fssa.glossyblends.customexception.DAOException;
import com.fssa.glossyblends.loginenum.LoginStatus;
import com.fssa.glossyblends.service.ArtistLogin;

/**
 * Unit tests for artist login functionality.
 */
class TestArtistLogin {

    /**
     * Test logging in with a valid user.
     * @throws DAOexception 
     *
    */
	
    @Test
    void testValidUser() throws SQLException, DAOException {
        ArtistLogin artistLog = new ArtistLogin();

        LoginStatus isExists = artistLog.login("joo12@example.com", "TestPassword123");

        Assertions.assertEquals(LoginStatus.SUCCESS, isExists);
    }

    /**
     * Test logging in with a valid user but incorrect password.
     * @throws DAOexception 
     */
    @Test
    void testValidUserWithInCorrectPassword() throws SQLException, DAOException {
        ArtistLogin artistLog = new ArtistLogin();

        LoginStatus isExists = artistLog.login("joo12@example.com", "TestPpassword123");

        Assertions.assertEquals(LoginStatus.INCORRECT_PASSWORD, isExists);
    }

    /**
     * Test logging in with an invalid user email.
     * @throws DAOexception 
     *
     */
    @Test
    void testValidUserWithInValidUserEmail() throws SQLException, DAOException {
        ArtistLogin artistLog = new ArtistLogin();

        LoginStatus isExists = artistLog.login("j@example.com", "TestPpassword123");

        Assertions.assertEquals(LoginStatus.USER_NOT_FOUND, isExists);
    }
    
}
