package com.fssa.glossyblends;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject; // Import the JSONObject class

import com.fssa.glossyblends.customexception.BookingException;
import com.fssa.glossyblends.customexception.DAOException;
import com.fssa.glossyblends.model.Booking;
import com.fssa.glossyblends.model.Booking.BookingStatus;
import com.fssa.glossyblends.model.Booking.PaymentStatus;
import com.fssa.glossyblends.model.SelectedService;
import com.fssa.glossyblends.service.BookingService;

@WebServlet("/BookingServlet")
public class BookingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			// Retrieve the JSON data from the request parameter
			BufferedReader reader = new BufferedReader(new InputStreamReader(request.getInputStream()));
			StringBuilder jsonBuilder = new StringBuilder();
			String line;
			while ((line = reader.readLine()) != null) {
				jsonBuilder.append(line);
			}
			String combinedDataString = jsonBuilder.toString();

			// Parse the combined JSON data

			// Extract the form data and service objects
			// Assuming you have the JSON data as a String named combinedData
			JSONObject combinedData = new JSONObject(combinedDataString);
			// Extract the form data
			JSONObject formObject = combinedData.getJSONObject("form");
			long pincode = Long.parseLong(formObject.getString("pincode"));
			String address = formObject.getString("address");
			int doorNumber = Integer.parseInt(formObject.getString("doorNumber"));
			long mobileNumber = Long.parseLong(formObject.getString("mobileNumber"));
			String name_Of_booker = formObject.getString("name");
			String timeString = formObject.getString("time");

			// Define the time format
			DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_TIME;

			// Parse the time string into a LocalTime object
			LocalTime time = LocalTime.parse(timeString, formatter);

			String category_evetn = formObject.getString("category");
			String Date_event = formObject.getString("dateParam");
			String location = formObject.getString("placeParam");

			// Extract individual values from the serviceObject
			int cost = 0;

			int service_id = 0;
			String name = null;
			String sampleImage = null;
			int artistId = 0;
			int id = 0;
			String category = null;
			PaymentStatus paymentStatus = PaymentStatus.PENDING;
			BookingStatus bookingStatus1 = BookingStatus.PENDING;
			int ttoalcost = 0;

			System.out.println(Date_event);

			// Extract the serviceObjects JSON array
			JSONArray serviceObjectsArray = combinedData.getJSONArray("serviceObjects");
			System.out.println(serviceObjectsArray);
			// Iterate through the serviceObjects array
			DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

			LocalDate date1 = null;

			List<SelectedService> sel = new ArrayList<>();

			for (int i = 0; i < serviceObjectsArray.length(); i++) {
				JSONObject serviceObject = serviceObjectsArray.getJSONObject(i);

				cost = serviceObject.getInt("cost");
				ttoalcost += cost;
				service_id = serviceObject.getInt("service_id");
				name = serviceObject.getString("name");
				sampleImage = serviceObject.getString("sampleImage");
				artistId = serviceObject.getInt("artistId");
				id = serviceObject.getInt("id");
				category = serviceObject.getString("category");

				date1 = LocalDate.parse(Date_event, dateFormatter);

				SelectedService serviceselected = new SelectedService();
				System.out.println(i);
				serviceselected.setArtistId(artistId);
				serviceselected.setServiceId(service_id);
				serviceselected.setUserId(id);

				sel.add(serviceselected);

			}

			for (SelectedService sell : sel) {
				System.out.println(sell.getServiceId());
			}

			Booking booking = new Booking();

			booking.setArtistId(artistId);
			booking.setLocation(address);
			booking.setSelectedEvent(category_evetn);
			booking.setAddress(address);
			booking.setTotalAmount(ttoalcost);
			booking.setUserId(id);
			booking.setPaymentStatus(paymentStatus);
			booking.setBookingStatus(bookingStatus1);
			booking.setServiceId(service_id);
			booking.setSelectedServices(sel);
			booking.setDate(date1);
			booking.setLocation(location);
			booking.setTimeOfEvent(time);
			booking.setMobileNumber(mobileNumber);
			booking.setDoornumber(doorNumber);
			booking.setPincode(pincode);
			BookingService bookservice = new BookingService();
			boolean add = bookservice.addBooking(booking);
			
			
			
			if (add) {
				System.out.println("aaded");

				response.setContentType("application/json");
				response.setCharacterEncoding("UTF-8");
				JSONObject jsonResponse = new JSONObject();
				jsonResponse.put("message", "Data received and processed successfully");
				response.getWriter().write(jsonResponse.toString());
			}
		} catch (BookingException | SQLException | DAOException e) {

			e.printStackTrace();
			String errorMessage = e.getMessage();
			response.getWriter().write(errorMessage);
			response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);

		}

	}
}
