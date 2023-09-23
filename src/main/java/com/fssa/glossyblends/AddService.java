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
import com.fssa.glossyblends.model.ServiceCategory;
import com.fssa.glossyblends.service.ArtistService;
import com.fssa.glossyblends.service.ServiceProviding;

/**
 * Servlet implementation class ListServlet
 */
@WebServlet("/AddService")
public class AddService extends HttpServlet {
	private static final long serialVersionUID = 1L;
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		ServiceProviding services = new ServiceProviding();
		HttpSession session = request.getSession();
		String email = (String) session.getAttribute("email");

		String category = request.getParameter("category");
		double cost = Double.parseDouble(request.getParameter("cost"));
		String name = request.getParameter("nameOfCategory");
		String image = request.getParameter("url");

		ServiceCategory serviceCategory = ServiceCategory.valueOf(category);

		try {
			Service service = new Service();
			ArtistService artist = new ArtistService();
			int artistId = artist.getArtistIdByEmail(email);
			service.setCategory(serviceCategory);
			service.setCost(cost);
			service.setName(name);
			service.setSampleImage(image);
			service.setArtistId(artistId);
			 services.addService(email, service);
			 request.setAttribute("successAdd", "Successfully added the service");
			
			 

		} catch (ServiceValueInvalidException | DAOException | SQLException e) {
			 e.getMessage();
			 request.setAttribute("errorAdd", e.getMessage());
			e.printStackTrace();
		}

		response.sendRedirect("./ListService");

	}

	
}
