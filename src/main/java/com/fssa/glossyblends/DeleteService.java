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
 * Servlet implementation class DeleteService
 */
@WebServlet("/DeleteService")
public class DeleteService extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DeleteService() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		String email = (String) session.getAttribute("email");

		int serviceid = Integer.parseInt(request.getParameter("serviceId"));

		System.out.println(serviceid);

		ServiceProviding service = new ServiceProviding();

		ArtistService artist = new ArtistService();
		int id = 0;

		try {
			id = artist.getArtistIdByEmail(email);
		} catch (DAOException | SQLException e) {
			e.printStackTrace();
		}
		Service ser;
		try {
			service.deleteServiceById(id, serviceid);

			request.setAttribute("successMsgg", "Service  deleted the service");
			System.out.println("success");
		} catch (SQLException  e) {
			System.out.println(e.getMessage());
			
			
			
			
			e.printStackTrace();
			request.setAttribute("errorMsgg", e.getMessage());
		}
		request.setAttribute("paths", "./ListService");
		request.getRequestDispatcher("./ListService").forward(request, response);

	}

}
