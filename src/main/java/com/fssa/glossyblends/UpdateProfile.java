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
import com.fssa.glossyblends.model.User;
import com.fssa.glossyblends.service.UserService;

/**
 * Servlet implementation class UpdateProfile
 */
@WebServlet("/UpdateProfile")
public class UpdateProfile extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public UpdateProfile() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		UserService userService = new UserService();
		try {
			HttpSession session = request.getSession(true);
			String emailOfUser = (String) session.getAttribute("email");
			User user = userService.getUserByEmail(emailOfUser);

			if (user != null) {
				request.setAttribute("user", user);
				request.getRequestDispatcher("PersonalDEtails.jsp").forward(request, response);
			} else {
				System.out.println("user not found");
			}
		} catch (DAOException | SQLException e) {
			System.out.println(e.getMessage());

			e.printStackTrace();
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    UserService userService = new UserService();
	    
	    HttpSession session = request.getSession(true);
	    String emailOfUser = (String) session.getAttribute("email");
	    
	    
	    try {
	        User userToUpdate = userService.getUserByEmail(emailOfUser);
	        int id=userService.getIdByUserEmail(emailOfUser);
	        
	        
	        // Update user details based on the form inputs (you should retrieve these inputs from the request)
	        userToUpdate.setAddress(request.getParameter("address"));
	        userToUpdate.setDoorNumber(request.getParameter("doorNumber"));
	        userToUpdate.setEmail(emailOfUser); // Assuming email cannot be changed
	        userToUpdate.setMobileNumber(request.getParameter("number"));
	        userToUpdate.setName(request.getParameter("name"));
	     
	        userToUpdate.setPincode(request.getParameter("pincode"));
	        userToUpdate.setId(id);
	        userToUpdate.setDoorNumber(request.getParameter("doornumber"));
	      boolean updated=  userService.UpdateUser(userToUpdate);
	        
	      session.setAttribute("user", userToUpdate);
	      
	     System.out.print("hooo");
	        
	        request.getRequestDispatcher("PersonalDEtails.jsp").forward(request, response);
	    } catch (DAOException | SQLException e) {
		     System.out.print("homfhjkjhsoo");

	        e.printStackTrace();
	    }
	}

}
