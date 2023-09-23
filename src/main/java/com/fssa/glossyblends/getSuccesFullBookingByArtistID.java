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
import com.fssa.glossyblends.model.Booking;
import com.fssa.glossyblends.service.ArtistService;
import com.fssa.glossyblends.service.BookingService;

/**
 * Servlet implementation class getSuccesFullBookingByArtistID
 */
@WebServlet("/getSuccesFullBookingByArtistID")
public class getSuccesFullBookingByArtistID extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public getSuccesFullBookingByArtistID() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();

		String email = (String) session.getAttribute("email");
		boolean loggedIn = (boolean) session.getAttribute("loggedIn");
		int id = -1;
		Artist artist = null;
		if (email != null && loggedIn) {

			ArtistService artistservice = new ArtistService();
			try {

				id = artistservice.getArtistIdByEmail(email);
				System.out.println(id);

				artist = artistservice.getArtistById(id);

			} catch (DAOException | SQLException e) {
				e.printStackTrace();
			}

			BookingService book = new BookingService();
			try {
				List<Booking> listBooking = book.getSuccessfullAppointmentsByArtistID(id);

				for (Booking books : listBooking) {
					System.out.println(books.getLocation());
				}

				request.setAttribute("artist", artist);

				request.setAttribute("listOfSuccessFullBooking", listBooking);
				request.getServletContext().getRequestDispatcher("/ArtistProfile/ArtistAppoinments.jsp")
						.forward(request, response);
			} catch (BookingException e) {
				e.printStackTrace();
			}

		}

	}
	
	
	

}
