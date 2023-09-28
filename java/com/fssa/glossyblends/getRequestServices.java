package com.fssa.glossyblends;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fssa.glossyblends.customexception.BookingException;
import com.fssa.glossyblends.customexception.DAOException;
import com.fssa.glossyblends.model.SelectedService;
import com.fssa.glossyblends.model.Service;
import com.fssa.glossyblends.service.BookingService;
import com.fssa.glossyblends.service.ServiceProviding;

/**
 * Servlet implementation class getRequestServices
 */
@WebServlet("/getRequestServices")
public class getRequestServices extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public getRequestServices() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String id = request.getParameter("BookingId");
		int bookingid = Integer.parseInt(id);

		String id2 = request.getParameter("ArtistId");
		int artistId = Integer.parseInt(id2);

		String id3 = request.getParameter("UserId");
		int userId = Integer.parseInt(id3);

		System.out.println("bookingid : " + bookingid);
		System.out.print(artistId + "atrtistid");
		BookingService booking = new BookingService();
		int serviceId = 0;
		try {
			List<Service> serviceAdd = new ArrayList<>();
			List<SelectedService> service = booking.getSelectedServicesByBookingAndArtist(bookingid, artistId);

			for (SelectedService ser : service) {

				serviceId = ser.getServiceId();

				ServiceProviding s = new ServiceProviding();
				Service addedservice = s.getServiceById(serviceId, artistId);
				System.out.println(addedservice.getCost()+"kjhgfdsfghj");

				serviceAdd.add(addedservice);

			}

			for (Service sss : serviceAdd) {

				System.out.println(sss.getSampleImage());
				System.out.println(sss.getCost());
				System.out.println(sss.getArtistId());
				System.out.println(sss.getId());

			}
			request.setAttribute("listOfService", serviceAdd);
			request.getRequestDispatcher("showingservice.jsp").forward(request, response);

		} catch (DAOException | BookingException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}

	}

}
