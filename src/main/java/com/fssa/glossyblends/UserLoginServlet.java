package com.fssa.glossyblends;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fssa.glossyblends.customexception.DAOException;
import com.fssa.glossyblends.loginenum.LoginStatus;
import com.fssa.glossyblends.model.User;
import com.fssa.glossyblends.service.UserService;
import com.fssa.glossyblends.service.userLogin;

/**
 * Servlet implementation class UserLogin
 */
@WebServlet("/UserLoginServlet")
public class UserLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */

	private userLogin Userslogin = new userLogin();

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		User user = new User();

		String email = request.getParameter("email");
		String password = request.getParameter("password");

		user.setAddress(email);
		user.setPassword(password);

		try {
			LoginStatus loginStatus = Userslogin.login(email, password);

			if (loginStatus == LoginStatus.SUCCESS) {

				HttpSession session = request.getSession(true);
				session.setAttribute("email", email);
				session.setAttribute("loggedInSuccess", true);

				
				UserService users= new UserService();
			User us=	users.getUserByEmail(email);
			session.setAttribute("user", us);
		
			boolean rememberMe = request.getParameter("rememberMe") != null;

			if (rememberMe) {
			    // Create a cookie with the user's email or username
			    Cookie userCookie = new Cookie("rememberedUser", email);
			    userCookie.setMaxAge(30 * 24 * 60 * 60); 
			    response.addCookie(userCookie);
			}

			// Check the email and password, perform login logic, and handle errors.

				request.setAttribute("SuccessLoggedIn", "Successfully LoggedIn");
				
				
				request.getRequestDispatcher("ArtistFeature.jsp").forward(request, response);

			} else {
				String emailError = null;
				String passwordError = null;

				if (loginStatus == LoginStatus.INCORRECT_PASSWORD) {
					passwordError = "Incorrect password. Please try again.";
				} else if (loginStatus == LoginStatus.USER_NOT_FOUND) {
					emailError = "User not found. Please register first.";
				}

				request.setAttribute("emailError", emailError);
				request.setAttribute("passwordError", passwordError);

				request.getRequestDispatcher("Login.jsp").forward(request, response);
			}
		} catch (SQLException | DAOException e) {
			e.printStackTrace();
			response.sendRedirect("Login.jsp");

		}
	}

}
