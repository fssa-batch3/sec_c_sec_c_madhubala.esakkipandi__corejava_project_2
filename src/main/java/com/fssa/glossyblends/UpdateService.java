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
import com.fssa.glossyblends.customexception.ServiceValueInvalidException;
import com.fssa.glossyblends.model.Service;
import com.fssa.glossyblends.service.ArtistService;
import com.fssa.glossyblends.service.ServiceProviding;

/**
 * Servlet implementation class UpdateService
 */
@WebServlet("/UpdateService")
public class UpdateService extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		String email = (String) session.getAttribute("email");

		double cost = Double.parseDouble(request.getParameter("cost"));
		String link = request.getParameter("image");

		int serviceid = Integer.parseInt(request.getParameter("serviceId"));
		ServiceProviding service = new ServiceProviding();

		ArtistService artist = new ArtistService();
		int id = 0;
		try {
			id = artist.getArtistIdByEmail(email);
		} catch (DAOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		Service ser;
		try {
			ser = service.getServiceById(serviceid, id);
			ser.setCost(cost);
			ser.setSampleImage(link);
			ser.setArtistId(id);
			ser.setId(serviceid);

			boolean update = service.updateService(ser);

		} catch (DAOException | ServiceValueInvalidException e) {
			e.printStackTrace();

		}
		response.sendRedirect("./ListService");

	}

}
