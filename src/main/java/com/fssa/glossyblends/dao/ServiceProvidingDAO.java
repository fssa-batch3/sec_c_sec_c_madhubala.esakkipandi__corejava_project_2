package com.fssa.glossyblends.dao;

import com.fssa.glossyblends.customexception.DAOException;
import com.fssa.glossyblends.model.Artist;
import com.fssa.glossyblends.model.ServiceCategory;
import com.fssa.glossyblends.model.Services;
import com.fssa.glossyblends.util.ConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Data Access Object (DAO) for managing service data in the database.
 */

public class ServiceProvidingDAO {

    private ServiceProvidingDAO() {
        // Private constructor to prevent instantiation
    }

    // Add a new service
    public static boolean addService(String email,Services service) throws SQLException, DAOException {
        try (Connection connection = ConnectionUtil.getConnection()) {
            
            String insertQuery = "INSERT INTO artist_services (artist_id, category, name, cost, sample_image) VALUES (?, ?, ?, ?, ?)";

            try (PreparedStatement stmt = connection.prepareStatement(insertQuery)) {
            	
            	
            	int artistId = PostDAO.getIdByArtistEmail(email);
            	
                stmt.setInt(1, artistId);
                stmt.setString(2, service.getCategory().name());
                stmt.setString(3, service.getName());
                stmt.setDouble(4, service.getCost());
                stmt.setString(5, service.getSampleImage());

                
                int rows = stmt.executeUpdate();

                return rows > 0; // Return true if rows were affected (insert successful)
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        }
    }

    
    // Get services by artist ID
    public static List<Services> getServicesByArtistId(int artistId) throws SQLException, DAOException {
        List<Services> servicesList = new ArrayList<>();

        String selectQuery = "SELECT * FROM artist_services WHERE artist_id = ?";

        try (Connection connection = ConnectionUtil.getConnection()) {
            try (PreparedStatement stmt = connection.prepareStatement(selectQuery)) {
                stmt.setInt(1, artistId);

                try (ResultSet rs = stmt.executeQuery()) {
                    while (rs.next()) {
                        Services service = new Services();
                        service.setArtistId(rs.getInt("artist_id"));
                        service.setCategory(ServiceCategory.valueOf(rs.getString("category")));
                        service.setName(rs.getString("name"));
                        service.setCost(rs.getDouble("cost"));
                        service.setSampleImage(rs.getString("sample_image"));

                        servicesList.add(service);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return servicesList;
    }

    // Update an existing service
    public static boolean updateService(Services service) throws SQLException, DAOException {
        int artistId = service.getArtistId();
        int serviceId = service.getId();
        String updateQuery = "UPDATE artist_services SET category = ?, name = ?, cost = ?, sample_image = ? WHERE artist_id = ? AND id = ?";

        try (Connection connection = ConnectionUtil.getConnection()) {
            try (PreparedStatement stmt = connection.prepareStatement(updateQuery)) {
                stmt.setString(1, service.getCategory().name());
                stmt.setString(2, service.getName());
                stmt.setDouble(3, service.getCost());
                stmt.setString(4, service.getSampleImage());
                stmt.setInt(5, artistId);
                stmt.setInt(6, serviceId);

                int rows = stmt.executeUpdate();

                return rows > 0; // Return true if rows were affected (update successful)
            }
        } catch (SQLException e) {
            return false;
        }
    }

    // Delete a service by artist ID and service ID
    public static boolean deleteService(int artistId, int serviceId) throws SQLException, DAOException {
        String deleteQuery = "DELETE FROM artist_services WHERE artist_id = ? AND id = ?";

        try (Connection connection = ConnectionUtil.getConnection()) {
            try (PreparedStatement stmt = connection.prepareStatement(deleteQuery)) {
                stmt.setInt(1, artistId);
                stmt.setInt(2, serviceId);

                int rows = stmt.executeUpdate();

                return rows > 0; // Return true if rows were affected (delete successful)
            }
        } catch (SQLException e) {
            return false;
        }
    }

    // Get a service by ID and artist ID
    public static Services getServiceById(int id, int artistId) throws SQLException, DAOException {
        Services service = null;
        String selectQuery = "SELECT * FROM artist_services WHERE id = ? AND artist_id = ?";

        try (Connection connection = ConnectionUtil.getConnection()) {
            try (PreparedStatement stmt = connection.prepareStatement(selectQuery)) {
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
e.printStackTrace();
            }
        }

        return service;
    }
}
