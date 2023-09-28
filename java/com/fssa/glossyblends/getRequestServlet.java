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
import com.fssa.glossyblends.model.Booking;
import com.fssa.glossyblends.model.SelectedService;
import com.fssa.glossyblends.service.ArtistService;
import com.fssa.glossyblends.service.BookingService;

/**
 * Servlet implementation class getRequestServlet
 */
@WebServlet("/getRequestServlet")
public class getRequestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public getRequestServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		BookingService bookservice = new BookingService();

		HttpSession session = request.getSession();

		String email = (String) session.getAttribute("email");
		boolean loggedIn = (boolean) session.getAttribute("loggedIn");
		int id = -1;
		ArtistService artistservice = new ArtistService();

		if (email != null && loggedIn) {

			try {

				id = artistservice.getArtistIdByEmail(email);

			} catch (DAOException | SQLException e) {
				e.printStackTrace();
			}

			BookingService book = new BookingService();
			try {
				List<Booking> listBooking = book.getrequestByArtistemail(id);


				request.setAttribute("listOfPending", listBooking);
				request.getServletContext().getRequestDispatcher("/ArtistProfile/Notifications.jsp").forward(request,
						response);
			} catch (BookingException e) {
				e.printStackTrace();
			}

		}
		
		
		
		
	}

}
