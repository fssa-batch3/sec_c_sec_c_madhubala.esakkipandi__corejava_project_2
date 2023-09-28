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
import com.fssa.glossyblends.model.Artist;
import com.fssa.glossyblends.model.Post;
import com.fssa.glossyblends.model.Service;
import com.fssa.glossyblends.model.User;
import com.fssa.glossyblends.service.ArtistService;
import com.fssa.glossyblends.service.UserService;

@WebServlet("/getServletOutput")
public class getServletOutput extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private ArtistService artistService = new ArtistService();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			int artistId = Integer.parseInt(request.getParameter("id"));

			HttpSession session = request.getSession(false);
			String email = null;
			if (session != null && session.getAttribute("loggedInSuccess") != null
					&& (Boolean) session.getAttribute("loggedInSuccess")) {
				email = (String) session.getAttribute("email");
			}
			System.out.println(email);
			
			String date=request.getParameter("date");
			String place=request.getParameter("place");
			System.out.println(place);
			
			request.setAttribute("date", date);
			request.setAttribute("place", place);
			
			UserService userser = new UserService();
			int id = userser.getIdByUserEmail(email);
			System.out.println(id);
			Artist artist = artistService.getArtistById(artistId);

			request.setAttribute("artist", artist);
			List<Post> artistPosts = artistService.getPostByArtistId(artistId);

			request.setAttribute("artistPosts", artistPosts);

			// Get artist services
			List<Service> artistServices = artistService.getServicesByArtistId(artistId);
			request.setAttribute("artistServices", artistServices);
			request.setAttribute("id", id);

		} catch (DAOException | SQLException e) {
			e.printStackTrace();
		}

		request.getServletContext().getRequestDispatcher("/showartist.jsp").forward(request, response);
	}

}
