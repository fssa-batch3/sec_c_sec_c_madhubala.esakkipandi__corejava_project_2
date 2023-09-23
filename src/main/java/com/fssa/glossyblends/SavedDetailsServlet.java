//package com.fssa.glossyblends;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.List;
//
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import com.fssa.glossyblends.model.Service;
//import com.fssa.glossyblends.model.ServiceCategory;
//import com.google.gson.Gson;
//import com.google.gson.JsonArray;
//import com.google.gson.JsonElement;
//import com.google.gson.JsonObject;
//
//@WebServlet("/SavedDetailsServlet")
//public class SavedDetailsServlet extends HttpServlet {
//	private static final long serialVersionUID = 1L;
//
//	protected void doPost(HttpServletRequest request, HttpServletResponse response)
//			throws ServletException, IOException {
//		BufferedReader reader = request.getReader();
//		StringBuilder requestData = new StringBuilder();
//		String line;
//		while ((line = reader.readLine()) != null) {
//			requestData.append(line);
//		}
//
//		JsonObject jsonObject = new Gson().fromJson(requestData.toString(), JsonObject.class);
//		JsonArray serviceArray = jsonObject.getAsJsonArray("services");
//
//		List<Service> serviceList = new ArrayList<>();
//
//		for (JsonElement serviceElement : serviceArray) {
//			Service service = new Gson().fromJson(serviceElement, Service.class);
//			serviceList.add(service);
//		}
//
//		List<Service> services = new ArrayList<>();
//
//		if (!serviceList.isEmpty()) {
//			for (Service service : serviceList) {
//
//				double cost = service.getCost();
//				ServiceCategory servicecat = service.getCategory();
//
//				String name = service.getName();
//				String image = service.getSampleImage();
//				int userId = service.getId();
//				int artistId = service.getArtistId();
//
//				System.out.println(cost);
//				System.out.println(name);
//
//				System.out.println(servicecat);
//
//				System.out.println(image);
//
//				System.out.println(userId);
//
//				System.out.println(artistId);
//				Service ser = new Service();
//				ser.setCategory(servicecat);
//				ser.setArtistId(artistId);
//				ser.setCost(cost);
//				ser.setId(userId);
//				ser.setName(name);
//				ser.setSampleImage(image);
//
//				services.add(ser);
//
//			}
//
//
//			
//			request.setAttribute("serviceList", services);
//			request.getRequestDispatcher("Booking.jsp").forward(request, response);
//		}
//	}
//
//}
