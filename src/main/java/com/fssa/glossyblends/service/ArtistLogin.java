package com.fssa.glossyblends.service;

import java.sql.SQLException;

import com.fssa.glossyblends.customexception.DAOException;
import com.fssa.glossyblends.dao.ArtistLoginDAO;
import com.fssa.glossyblends.loginenum.LoginStatus;

public class ArtistLogin {

	public static boolean validateUserEmail(String username) throws SQLException, DAOException {

		boolean userExists = ArtistLoginDAO.validateUserExists(username);

		if (userExists) {
			return true;
		}
		return false;

	}

	public LoginStatus login(String username, String password) throws SQLException, DAOException {

		boolean exits = validateUserEmail(username);
		if (exits) {
			boolean isValidLogin = ArtistLoginDAO.validateLogin(username, password);
			if (isValidLogin) {
				return LoginStatus.SUCCESS;
			} else {
				return LoginStatus.INCORRECT_PASSWORD;
			}
		} else {
			return LoginStatus.USER_NOT_FOUND; 
		}
	}

}
