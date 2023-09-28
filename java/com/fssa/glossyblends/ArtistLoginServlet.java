package com.fssa.glossyblends;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fssa.glossyblends.customexception.DAOException;
import com.fssa.glossyblends.loginenum.LoginStatus;
import com.fssa.glossyblends.model.Artist;
import com.fssa.glossyblends.service.ArtistLogin;
import com.fssa.glossyblends.service.ArtistService;

/**
 * Servlet implementation class ArtistLoginServlet
 */

@WebServlet("/ArtistLoginServlet")
public class ArtistLoginServlet extends HttpServlet {
	private ArtistLogin artistLogin = new ArtistLogin();

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String email = request.getParameter("email");
		String password = request.getParameter("password");

		try {
			LoginStatus loginStatus = artistLogin.login(email, password);

			if (loginStatus == LoginStatus.SUCCESS) {
				HttpSession session = request.getSession(true);
				session.setAttribute("email", email);
				
				ArtistService artistser=new ArtistService();
				int id=artistser.getArtistIdByEmail(email);
				Artist artist=artistser.getArtistById(id);
				session.setAttribute("artist", artist);
				session.setAttribute("loggedIn", true);
				request.setAttribute("successPath", "ArtistEnter.jsp");
				request.setAttribute("successMsg", "Successfully LoggedIn");
				
				
				request.getRequestDispatcher("ArtistEnter.jsp").forward(request, response);

			} else {
				if (loginStatus == LoginStatus.INCORRECT_PASSWORD) {
					request.setAttribute("passwordError", "Incorrect password. Please try again.");
					request.setAttribute("pathd", "Artist.jsp");

				} else if (loginStatus == LoginStatus.USER_NOT_FOUND) {
					request.setAttribute("emailError", "User not found. Please register first.");
					request.setAttribute("pathd", "Artist.jsp");

				}


				request.getRequestDispatcher("Artist.jsp").forward(request, response);

			}
		} catch (SQLException | DAOException e) {
			e.printStackTrace();
		}
	}
}
