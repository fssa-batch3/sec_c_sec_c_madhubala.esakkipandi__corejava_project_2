package com.fssa.glossyblends.util;

import java.sql.Connection;
import java.sql.DriverManager;

import com.fssa.glossyblends.customexception.DAOException;

public class ConnectionUtil {

	public static Connection getConnection() throws DAOException {
		Connection con = null;

//
//        String url=System.getenv("DATABASE_HOST");
//        String userName =System.getenv("DATABASE_USERNAME");
//        String passWord =System.getenv("DATABASE_PASSWORD");

		String url = "jdbc:mysql://localhost:3306/glossyblendsweb";
		String userName = "root";
		String passWord = "123456";

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url, userName, passWord);
		} catch (Exception e) {
			e.printStackTrace();
			throw new DAOException("Unable to connect to the database " + e.getMessage());
		}
		return con;
	}

}
