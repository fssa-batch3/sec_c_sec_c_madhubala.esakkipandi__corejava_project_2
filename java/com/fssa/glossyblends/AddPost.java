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
import com.fssa.glossyblends.model.Post;
import com.fssa.glossyblends.service.ArtistService;
import com.fssa.glossyblends.service.PostService;

/**
 * Servlet implementation class AddPost
 */
@WebServlet("/AddPost")
public class AddPost extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddPost() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PostService post = new PostService();
		HttpSession session = request.getSession();
		String email = (String) session.getAttribute("email");
		int id = -1;
		

		String title = request.getParameter("title");
		String description = request.getParameter("description");
		String url = request.getParameter("url");
		System.out.println(title);
		System.out.println(description);
		System.out.println(email);

		Post postnew = new Post();
		postnew.setDescription(description);
		postnew.setTitle(title);

		postnew.setPostUrl(url);

		try {
			boolean added = post.addPost(email, postnew);

			request.setAttribute("successMsg", "Susccesfully added");
		} catch (PostValueInvalidException | DAOException | SQLException e) {
			e.printStackTrace();

			request.setAttribute("errorMsg", e.getMessage());

			System.out.println(e.getMessage());
		}

		request.setAttribute("path", "Artistupload.jsp");

		request.getRequestDispatcher("Artistupload.jsp").forward(request, response);
		
	}

}
