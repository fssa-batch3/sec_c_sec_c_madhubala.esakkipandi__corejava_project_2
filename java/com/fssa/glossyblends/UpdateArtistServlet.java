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
import com.fssa.glossyblends.model.Artist;
import com.fssa.glossyblends.model.Artist.gender;
import com.fssa.glossyblends.service.ArtistService;

@WebServlet("/UpdateArtistServlet")
public class UpdateArtistServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		String emails = (String) session.getAttribute("email");

		int id = 0;
		ArtistService artistservice = new ArtistService();
		try {

			id = artistservice.getArtistIdByEmail(emails);
		} catch (DAOException | SQLException e) {
			e.printStackTrace();
		}
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		String experience = request.getParameter("expernice-artist");
		long number = Long.parseLong(request.getParameter("number"));
		String link = request.getParameter("link_url");
		String city = request.getParameter("locality");
		String language = request.getParameter("language");
		String genderstr = request.getParameter("genderOfArtist");

		gender gen = gender.valueOf(genderstr);
		Artist artist = new Artist();
		artist.setUsername(name);
		artist.setPassword(password);
		artist.setYearsOfExperience(Integer.parseInt(experience));
		artist.setEmail(emails);
		artist.setLocation(city);
		artist.setPhonenNumber(number);
		artist.setLanguagesSpoken(language);
		artist.setGenderOfArtist(gen);
		artist.setImageurl(link);
		artist.setArtistId(id);

		System.out.println(artist.getUsername());
		try {

			artistservice.updateArtist(artist);
			System.out.println(artist.getUsername());
			
			
			request.setAttribute("success", "successfully updated");

		} catch (ArtistDetailsExceptions | DAOException | SQLException e) {
			e.printStackTrace();
			request.setAttribute("error", e.getMessage());

			System.out.println(e.getMessage());
		}
		response.getWriter().print("<script>window.location = window.location.href;</script>");

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ArtistService artistService = new ArtistService();

		HttpSession session = request.getSession();
		String email = (String) session.getAttribute("email");

		int id = 0;
		try {
			id = artistService.getArtistIdByEmail(email);
		} catch (DAOException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Artist artist = null;
		try {
			artist = artistService.getArtistById(id);
		} catch (SQLException | DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		session.setAttribute("loggedInArtist", artist);

		// Forward the artist object to the update form JSP
		request.setAttribute("artist", artist);
		request.getServletContext().getRequestDispatcher("/ArtistProfile/PersonalDetailsArtist.jsp").forward(request, response);
	}

}
