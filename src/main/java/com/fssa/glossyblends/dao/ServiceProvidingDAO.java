package com.fssa.glossyblends.dao;

import com.fssa.glossyblends.model.ServiceCategory;
import com.fssa.glossyblends.model.Services;
import com.fssa.glossyblends.util.ConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ServiceProvidingDAO {
private ServiceProvidingDAO() {
	
}
  

public static boolean addService(Services service) throws SQLException {
    try (Connection connection = ConnectionUtil.getConnection()) {
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
        throw e;
    }
}
    	

    public static List<Services> getServicesByArtistId(int artistId)throws SQLException  {
        List<Services> servicesList = new ArrayList<>();

     
            String selectQuery = "SELECT * FROM artist_services WHERE artist_id = ?";
        	try(Connection connection=ConnectionUtil.getConnection()){

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
        }

        return servicesList;
    }

    public static boolean updateService(Services service)throws SQLException   {
       
            int artistId = service.getArtistId();
            int serviceId = service.getId();
            String updateQuery = "UPDATE artist_services SET category = ?, name = ?, cost = ?, sample_image = ? WHERE artist_id = ? AND id = ?";
        	try(Connection connection=ConnectionUtil.getConnection()){

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
            
            return false;
        }
    }

    public static boolean deleteService(int artistId, int serviceId)throws SQLException  {
        
            String deleteQuery = "DELETE FROM artist_services WHERE artist_id = ? AND id = ?";
        	try(Connection connection=ConnectionUtil.getConnection()){

            try (PreparedStatement stmt = connection.prepareStatement(deleteQuery)) {
                stmt.setInt(1, artistId);
                stmt.setInt(2, serviceId);

                int rows = stmt.executeUpdate();
                return rows > 0;
            }
        } catch (SQLException e) {
            return false;
        }
    }
    

    public static Services getServiceById(int id, int artistId) throws SQLException {
        Services service = null;
        String selectQuery = "SELECT * FROM artist_services WHERE id = ? AND artist_id = ?";
    	try(Connection connection=ConnectionUtil.getConnection()){

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
        }

       
    }
    	 return service;
    }
   
}
