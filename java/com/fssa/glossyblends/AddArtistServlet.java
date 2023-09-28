package com.fssa.glossyblends;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fssa.glossyblends.customexception.ArtistDetailsExceptions;
import com.fssa.glossyblends.customexception.DAOException;
import com.fssa.glossyblends.model.*;
import com.fssa.glossyblends.model.Artist.gender;
import com.fssa.glossyblends.service.*;

/**
 * Servlet implementation class AddArtistServlet
 */
@WebServlet("/AddArtistServlet")
public class AddArtistServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddArtistServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		ArtistService artistService = new ArtistService();

		String name = request.getParameter("username");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String experience = request.getParameter("expernice-artist");
		long number = Long.parseLong(request.getParameter("number-artist"));
		String link = request.getParameter("link_url");
		String city = request.getParameter("locality");
		String language = request.getParameter("language");
		String genderstr = request.getParameter("genderOfArtist");

		gender gen = gender.valueOf(genderstr);
		Artist artist = new Artist();
		artist.setUsername(name);
		artist.setEmail(email);
		artist.setPassword(password);
		artist.setYearsOfExperience(Integer.parseInt(experience));
		artist.setLocation(city);
		artist.setPhonenNumber(number);
		artist.setLanguagesSpoken(language);
		artist.setGenderOfArtist(gen);
		artist.setImageurl(link);
		try {
			boolean added = artistService.addArtist(artist);

			request.setAttribute("success", "Registered successfully");

			
		} catch (ArtistDetailsExceptions | DAOException | SQLException e) {
			request.setAttribute("errorMessage", e.getMessage());

		}
		request.getRequestDispatcher("Register.jsp").forward(request, response);

	}

}
