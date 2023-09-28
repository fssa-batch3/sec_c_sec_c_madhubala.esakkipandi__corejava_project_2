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
import com.fssa.glossyblends.model.Post;
import com.fssa.glossyblends.service.ArtistService;

/**
 * Servlet implementation class getArtistWorks
 */
@WebServlet("/getArtistWorks")
public class getArtistWorks extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		ArtistService service = new ArtistService();
		HttpSession session = request.getSession();

		String email = (String) session.getAttribute("email");
		boolean loggedIn = (boolean) session.getAttribute("loggedIn");
		String success = (String) request.getAttribute("success");
		System.out.println(success + "mumsg");
		String error = (String) request.getAttribute("error");
		String path = (String) request.getAttribute("paths");

		int id = -1;
		ArtistService artistservice = new ArtistService();

		if (email != null && loggedIn) {

			try {

				id = artistservice.getArtistIdByEmail(email);

			} catch (DAOException | SQLException e) {
				e.printStackTrace();
			}

			try {
				List<Post> post = service.getPostByArtistId(id);
				request.setAttribute("works", post);
				request.setAttribute("success", success);
				request.setAttribute("error", error);
				request.setAttribute("paths", path);
				request.getServletContext().getRequestDispatcher("/ArtistProfile/UploadedWorks.jsp").forward(request,
						response);

			} catch (SQLException | DAOException e) {
				e.printStackTrace();
			}

		}
	}
}
