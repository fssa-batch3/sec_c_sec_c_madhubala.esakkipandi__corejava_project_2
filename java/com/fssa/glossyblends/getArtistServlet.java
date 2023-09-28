package com.fssa.glossyblends;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fssa.glossyblends.customexception.BookingException;
import com.fssa.glossyblends.customexception.DAOException;
import com.fssa.glossyblends.model.Artist;
import com.fssa.glossyblends.service.ArtistService;
import com.fssa.glossyblends.service.BookingService;

/**
 * Servlet implementation class getArtistServlet
 */
@WebServlet("/getArtistServlet")
public class getArtistServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public getArtistServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		String email = (String) session.getAttribute("email");

		String date = request.getParameter("date");
		String place = request.getParameter("city");

		BookingService service = new BookingService();

		if (email == null) {
			response.sendRedirect("Login.jsp");
		} else {

			try {
				List<Artist> artists = service.getavailableartist(date, place);

				request.setAttribute("artists", artists);
				request.setAttribute("email", email);

				request.setAttribute("date", date);
				request.setAttribute("place", place);

			} catch ( BookingException e) {

				e.printStackTrace();
			}

			// Construct the URL with parameters
			String forwardURL = "/listArtist.jsp?date=" + date + "&city=" + place;

			// Forward the request to the URL with parameters
			request.getRequestDispatcher(forwardURL).forward(request, response);
		}
	}

}
