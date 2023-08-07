package com.fssa.glossyblends.DAO;

import com.fssa.glossyblends.CustomException.ServiceValueInvalidException;
import com.fssa.glossyblends.model.Artist.ServiceCategory;
import com.fssa.glossyblends.model.Artist.Services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ServiceProvidingDAO {

	private Connection connection;

	public ServiceProvidingDAO(Connection connection) {
		this.connection = connection;
	}

	/// Adding service

	public boolean addService(Services service)throws ServiceValueInvalidException {
		try {
			int artistId = service.getArtistId();
			PreparedStatement stmt = connection.prepareStatement(
					"INSERT INTO artist_services (artist_id, category, name, cost, sample_image) VALUES (?, ?, ?, ?, ?)");
			stmt.setInt(1, artistId);
			stmt.setString(2, service.getCategory().name());
			stmt.setString(3, service.getName());
			stmt.setDouble(4, service.getCost());
			stmt.setString(5, service.getSampleImage());

			int rows = stmt.executeUpdate();
			stmt.close();

			return rows > 0;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	// Geting service list by using the artist id

	public List<Services> getServicesByArtistId(int artistId)throws ServiceValueInvalidException {
		List<Services> servicesList = new ArrayList<Services>();

		try {
			PreparedStatement stmt = connection.prepareStatement("SELECT * FROM artist_services WHERE artist_id = ?");
			stmt.setInt(1, artistId);

			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				Services service = new Services();
				service.setArtistId(rs.getInt("artist_id"));
				service.setCategory(ServiceCategory.valueOf(rs.getString("category")));
				service.setName(rs.getString("name"));
				service.setCost(rs.getDouble("cost"));
				service.setSampleImage(rs.getString("sample_image"));

				servicesList.add(service);
			}

	
			
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return servicesList;
	}

	// updating service by using the artist id

	public boolean updateService(Services service) throws ServiceValueInvalidException {
	    try {
	        int artistId = service.getArtistId();
	        int serviceId = service.getId();
	        PreparedStatement stmt = connection.prepareStatement(
	            "UPDATE artist_services SET category = ?, name = ?, cost = ?, sample_image = ? WHERE artist_id = ? AND id = ?");
	        stmt.setString(1, service.getCategory().name());
	        stmt.setString(2, service.getName());
	        stmt.setDouble(3, service.getCost());
	        stmt.setString(4, service.getSampleImage());
	        stmt.setInt(5, artistId);
	        stmt.setInt(6, serviceId);

	        int rows = stmt.executeUpdate();
	        stmt.close();

	        return rows > 0;
	    } catch (SQLException e) {
	        e.printStackTrace();
	        return false;
	    }
	}



	/// deletig the arist service
	public boolean deleteService(int artistId, int serviceId) {
		try {
			PreparedStatement stmt = connection
					.prepareStatement("DELETE FROM artist_services WHERE artist_id = ? AND id = ?");
			stmt.setInt(1, artistId);
			stmt.setInt(2, serviceId);

			int rows = stmt.executeUpdate();
			stmt.close();

			return rows > 0;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	public Services getServiceById(int id, int artistId) {
	    Services service = null;
	    String query = "SELECT * FROM artist_services WHERE id = ? AND artist_id = ?";
	    
	    try (
	        PreparedStatement stmt = connection.prepareStatement(query);
	    ) {
	        stmt.setInt(1, id);
	        stmt.setInt(2, artistId);

	        try (ResultSet rs = stmt.executeQuery()) {
	            if (rs.next()) {
	                service = new Services();
	                service.setArtistId(rs.getInt("artist_id"));
	                service.setCategory(ServiceCategory.valueOf(rs.getString("category")));
	                service.setName(rs.getString("name"));
	                service.setCost(rs.getDouble("cost"));
	                service.setSampleImage(rs.getString("sample_image"));
	            }
	        }
	    } catch (SQLException e) {
	        // Consider logging the error instead of printing the stack trace
	        e.printStackTrace();
	    }

	    return service;
	}




}
