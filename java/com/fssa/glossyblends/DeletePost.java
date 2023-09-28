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
import com.fssa.glossyblends.customexception.PostValueInvalidException;
import com.fssa.glossyblends.service.ArtistService;
import com.fssa.glossyblends.service.PostService;
import com.fssa.glossyblends.service.ServiceProviding;

/**
 * Servlet implementation class DeletePost
 */
@WebServlet("/DeletePost")
public class DeletePost extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DeletePost() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		String email = (String) session.getAttribute("email");
		System.out.println(email + "email");

		int postId = Integer.parseInt(request.getParameter("postId"));
		System.out.println(postId + "postid");
		System.out.println(postId);

		ServiceProviding service = new ServiceProviding();

		ArtistService artist = new ArtistService();
		int id = 0;

		try {
			id = artist.getArtistIdByEmail(email);
			System.out.println(id + "idaertsir");

		} catch (DAOException | SQLException e) {
			e.printStackTrace();
		}
		PostService post = new PostService();
		try {
			post.deletePost(postId, id);

			request.setAttribute("success", "Post successfully deleted");
		
		} catch (DAOException e) {
			e.printStackTrace();

			System.out.print(e.getMessage());
			request.setAttribute("error", e.getMessage());

		}
		request.setAttribute("paths", "/glossyblends-webapp/getArtistWorks");

		request.getRequestDispatcher("/getArtistWorks").forward(request, response);

	}

}
