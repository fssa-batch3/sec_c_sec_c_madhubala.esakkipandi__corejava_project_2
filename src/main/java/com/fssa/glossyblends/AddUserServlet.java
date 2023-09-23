package com.fssa.glossyblends;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fssa.glossyblends.customexception.ArtistDetailsExceptions;
import com.fssa.glossyblends.customexception.DAOException;
import com.fssa.glossyblends.model.User;
import com.fssa.glossyblends.service.UserService;

/**
 * Servlet implementation class AddUserServlet
 */
@WebServlet("/AddUserServlet")
public class AddUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		UserService userservice = new UserService();

		String email = request.getParameter("email");
		String name = request.getParameter("name");

		String password = request.getParameter("password");
		String repeatPassword = request.getParameter("repeat-password");
		User user = new User();

		user.setEmail(email);
		user.setName(name);
		user.setPassword(password);
		user.setRepeatPassword(repeatPassword);
		boolean added = false;

		try {
			added = userservice.addUser(user, email);

		} catch (ArtistDetailsExceptions | DAOException | SQLException e) {

			request.setAttribute("Error", e.getMessage());
			request.setAttribute("ErrorPath", "signUp.jsp");
			request.getRequestDispatcher("signUp.jsp").forward(request, response);
			e.printStackTrace();
		}

		if (added) {
			request.setAttribute("email", email);
			HttpSession session = request.getSession(true);
			session.setAttribute("email", email);
			session.setAttribute("loggedInSuccess", true);
			request.setAttribute("name", name);

			request.setAttribute("Succses", "Successfully SignUp");
			request.getRequestDispatcher("ArtistFeature.jsp").forward(request, response);

		}

	}
}
