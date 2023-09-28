package com.fssa.glossyblends;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fssa.glossyblends.customexception.DAOException;
import com.fssa.glossyblends.model.Artist;
import com.fssa.glossyblends.service.ArtistService;

/**
 * Servlet implementation class GetArtistByNameServlet
 */
@WebServlet("/GetArtistByNameServlet")
public class GetArtistByNameServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public GetArtistByNameServlet() {
		super();

	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String search = request.getParameter("name");
		ArtistService artistservice = new ArtistService();

		try {
			List<Artist> artist = artistservice.getArtistByName(search);
			request.setAttribute("artists", artist);

		} catch (DAOException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		request.getRequestDispatcher("/listArtist.jsp").forward(request, response);

	}

}
