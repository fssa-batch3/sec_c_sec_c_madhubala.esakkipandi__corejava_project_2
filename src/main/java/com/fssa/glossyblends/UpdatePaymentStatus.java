package com.fssa.glossyblends;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fssa.glossyblends.customexception.BookingException;
import com.fssa.glossyblends.customexception.DAOException;
import com.fssa.glossyblends.model.Booking.BookingStatus;
import com.fssa.glossyblends.model.Booking.PaymentStatus;
import com.fssa.glossyblends.service.BookingService;

/**
 * Servlet implementation class UpdatePaymentStatus
 */
@WebServlet("/UpdatePaymentStatus")
public class UpdatePaymentStatus extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String data = request.getParameter("bookingId"); 
		int id = Integer.parseInt(data);
		System.out.print("dksfjsdk" + id);
		PaymentStatus statusNew = PaymentStatus.PAID;

		BookingService bookingService = new BookingService();

		try {
			boolean success = bookingService.updatePaymentStatus(id, statusNew);

			if (success) {
				response.getWriter().write("Payment status updated successfully.");
			} else {
				response.getWriter().write("Failed to update payment status.");
			}
		} catch (SQLException | DAOException e) {
			e.printStackTrace();
			// Handle database-related exceptions here
			response.getWriter().write("Failed to update payment status due to a database error.");
		} catch (BookingException e) {
			e.printStackTrace();
			// Handle booking-related exceptions here
			response.getWriter().write("Failed to update payment status due to a booking error.");
		}
	}
}
