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

import com.fssa.glossyblends.customexception.BookingException;
import com.fssa.glossyblends.customexception.DAOException;
import com.fssa.glossyblends.model.Booking;
import com.fssa.glossyblends.model.User;
import com.fssa.glossyblends.service.BookingService;
import com.fssa.glossyblends.service.UserService;

/**
 * Servlet implementation class getConfirmedBooking
 */
@WebServlet("/getConfirmedBooking")
public class getConfirmedBooking extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public getConfirmedBooking() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		


		 HttpSession session=request.getSession();
		 
			String email = (String) session.getAttribute("email");
			boolean loggedIn=(boolean) session.getAttribute("loggedInSuccess");
			int id=-1;
			if(email!=null && loggedIn) {
				
				UserService userservice= new UserService();
				try {
					User user=userservice.getUserByEmail(email);
					id=userservice.getIdByUserEmail(email);
					
				} catch (DAOException | SQLException e) {
					e.printStackTrace();
				}
				
				BookingService book=new BookingService();
				try {
					List<Booking> listBooking=book.getConfirmedAppoinmentsById(id);
					request.setAttribute("listOfConfirmed",listBooking);
					request.getServletContext().getRequestDispatcher("/AcceptedRecord.jsp").forward(request, response);				
				} catch (BookingException e) {
					e.printStackTrace();
				}
				
				
			}
	}
	

}
