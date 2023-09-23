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

import com.fssa.glossyblends.customexception.DAOException;
import com.fssa.glossyblends.model.Service;
import com.fssa.glossyblends.service.ArtistService;

/**
 * Servlet implementation class AddService
 */
@WebServlet("/ListService")
public class ListService extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String errormsgaddservice = (String) request.getAttribute("errorAdd");
		String succesaddservice = (String) request.getAttribute("successAdd");

		String sucmsessges = (String) request.getAttribute("successMsgg");
		String ereormeages = (String) request.getAttribute("errorMsgg");
		String path = (String) request.getAttribute("paths");

		
	

		try {

			ArtistService artist = new ArtistService();
			HttpSession session = request.getSession();
			String email = (String) session.getAttribute("email");
			int artistId = artist.getArtistIdByEmail(email);

			List<Service> serviceOfartist = artist.getServicesByArtistId(artistId);

			for (Service ser : serviceOfartist) {

				System.out.print(ser.getCost());
			}
			
			request.setAttribute("successMessages", succesaddservice);

			request.setAttribute("services", serviceOfartist);

		} catch (DAOException | SQLException e) {
			e.printStackTrace();
		}

		request.setAttribute("suc", sucmsessges);
		request.setAttribute("er", ereormeages);
		request.setAttribute("paths", path);

		
		
		request.setAttribute("errorMessages", errormsgaddservice);
		
		System.out.println(succesaddservice);
		System.out.println(errormsgaddservice);

	
		
		request.getServletContext().getRequestDispatcher("/ArtistPackage.jsp").forward(request, response);
	}

}
