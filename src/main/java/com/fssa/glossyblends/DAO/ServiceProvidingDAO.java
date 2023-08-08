package com.fssa.glossyblends.DAO;

import com.fssa.glossyblends.CustomException.ServiceValueInvalidException;
import com.fssa.glossyblends.model.ServiceCategory;
import com.fssa.glossyblends.model.Services;

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

    public boolean addService(Services service) throws ServiceValueInvalidException {
        try {
            int artistId = service.getArtistId();
            String insertQuery = "INSERT INTO artist_services (artist_id, category, name, cost, sample_image) VALUES (?, ?, ?, ?, ?)";

            try (PreparedStatement stmt = connection.prepareStatement(insertQuery)) {
                stmt.setInt(1, artistId);
                stmt.setString(2, service.getCategory().name());
                stmt.setString(3, service.getName());
                stmt.setDouble(4, service.getCost());
                stmt.setString(5, service.getSampleImage());

                int rows = stmt.executeUpdate();
                return rows > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<Services> getServicesByArtistId(int artistId) throws ServiceValueInvalidException {
        List<Services> servicesList = new ArrayList<>();

        try {
            String selectQuery = "SELECT * FROM artist_services WHERE artist_id = ?";

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

    public boolean updateService(Services service) throws ServiceValueInvalidException {
        try {
            int artistId = service.getArtistId();
            int serviceId = service.getId();
            String updateQuery = "UPDATE artist_services SET category = ?, name = ?, cost = ?, sample_image = ? WHERE artist_id = ? AND id = ?";

            try (PreparedStatement stmt = connection.prepareStatement(updateQuery)) {
                stmt.setString(1, service.getCategory().name());
                stmt.setString(2, service.getName());
                stmt.setDouble(3, service.getCost());
                stmt.setString(4, service.getSampleImage());
                stmt.setInt(5, artistId);
                stmt.setInt(6, serviceId);

                int rows = stmt.executeUpdate();
                return rows > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean deleteService(int artistId, int serviceId) {
        try {
            String deleteQuery = "DELETE FROM artist_services WHERE artist_id = ? AND id = ?";

            try (PreparedStatement stmt = connection.prepareStatement(deleteQuery)) {
                stmt.setInt(1, artistId);
                stmt.setInt(2, serviceId);

                int rows = stmt.executeUpdate();
                return rows > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public Services getServiceById(int id, int artistId) {
        Services service = null;
        String selectQuery = "SELECT * FROM artist_services WHERE id = ? AND artist_id = ?";
        
        try (
            PreparedStatement stmt = connection.prepareStatement(selectQuery);
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
            e.printStackTrace();
        }

        return service;
    }
}
