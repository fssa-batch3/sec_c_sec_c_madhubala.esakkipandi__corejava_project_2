package com.fssa.glossyblends;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fssa.glossyblends.customexception.BookingException;
import com.fssa.glossyblends.model.Booking;
import com.fssa.glossyblends.model.Booking.BookingStatus;
import com.fssa.glossyblends.service.BookingService;

@WebServlet("/StatusUpdate")
public class StatusUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public StatusUpdate() {
		super();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String bookingId = request.getParameter("bookingId");
		int id = Integer.parseInt(bookingId);
		String status = request.getParameter("status");

		// Assuming you have a method to convert the status string to BookingStatus enum
		BookingStatus statusNew = BookingStatus.valueOf(status.toUpperCase());

		System.out.println(id);
		System.out.println(status);

		BookingService bookingService = new BookingService();

		try {
			// You need to pass the bookingId and statusNew as arguments to your
			// statusUpdate method.
			boolean success = bookingService.statusUpdate(id, statusNew);

			if (success) {
				System.out.println("Updated");
			} else {
				System.out.println("Not updated");
			}

		} catch (BookingException e) {
			e.printStackTrace();
		}
	}

}
