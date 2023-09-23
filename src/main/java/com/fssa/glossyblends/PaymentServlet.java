package com.fssa.glossyblends;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fssa.glossyblends.customexception.DAOException;
import com.fssa.glossyblends.model.SelectedService;
import com.fssa.glossyblends.model.Service;
import com.fssa.glossyblends.service.BookingService;
import com.fssa.glossyblends.service.ServiceProviding;

/**
 * Servlet implementation class PaymentServlet
 */
@WebServlet("/PaymentServlet")
public class PaymentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int bookingId = Integer.parseInt(request.getParameter("booking_Id"));
		int userId = Integer.parseInt(request.getParameter("user_Id"));
		int artistId = Integer.parseInt(request.getParameter("artist_Id"));

		System.out.println(bookingId);
		System.out.println(userId);
		System.out.println(artistId);

		BookingService booking = new BookingService();

		try {

			List<SelectedService> selectedServices = booking.getSelectedService(bookingId, artistId, userId);
			List<Service> listOfservice = new ArrayList<>();
			int serviceId = 0;
			if (selectedServices.isEmpty()) {
				System.out.println("No selected services found for booking ID: " + bookingId);
			} else {
				System.out.println("Selected Services for Booking ID: " + bookingId);
				for (SelectedService service : selectedServices) {
					System.out.println("Selected Service ID: " + service.getSelectedServiceId());
					System.out.println("Booking ID: " + service.getBookingId());
					System.out.println("User ID: " + service.getUserId());
					System.out.println("Artist ID: " + service.getArtistId());
					System.out.println("Service ID: " + service.getServiceId());
					serviceId = service.getServiceId();

					ServiceProviding ser = new ServiceProviding();
					Service serv = ser.getServiceById(serviceId, artistId);

					listOfservice.add(serv);

				}

			}

			request.setAttribute("ServiceSelected", listOfservice);
			request.setAttribute("artistId", artistId);
			request.setAttribute("bookingId", bookingId);
			request.setAttribute("userId", userId);
			request.getRequestDispatcher("Payment.jsp").forward(request, response);

		} catch (SQLException | DAOException e) {
			e.printStackTrace();
		}

	}
}
