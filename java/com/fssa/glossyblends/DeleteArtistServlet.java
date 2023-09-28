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
import com.fssa.glossyblends.model.Artist;
import com.fssa.glossyblends.service.ArtistService;

/**
 * Servlet implementation class DeleteArtistServlet
 */
@WebServlet("/DeleteArtistServlet")
public class DeleteArtistServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
	      String emails = (String) session.getAttribute("email");

	      int id = 0;
	      Artist artist=null;
	 
	        ArtistService artistservice=new ArtistService();
	        try {
				id=artistservice.getArtistIdByEmail(emails);
				artist=artistservice.getArtistById(id);
			} catch (DAOException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        try {
				artistservice.deleteArtist(artist);
			} catch (DAOException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        
	    response.sendRedirect("index.jsp")  ;  
	     
	}

	

}
