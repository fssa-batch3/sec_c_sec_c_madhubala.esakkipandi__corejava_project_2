package com.fssa.glossyblends.dao;

import com.fssa.glossyblends.customexception.DAOException;
import com.fssa.glossyblends.model.ServiceCategory;
import com.fssa.glossyblends.model.Service;
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

	/**
	 * Adds a new service to the database for the specified artist's email.
	 *
	 * @param email   The email of the artist for whom the service is being added.
	 * @param service The service to be added.
	 * @return True if the service was successfully added, otherwise false.
	 * @throws SQLException If a database access error occurs.
	 * @throws DAOException If an exception specific to the data access layer
	 *                      occurs.
	 */
	public static boolean addService(String email, Service service) throws SQLException, DAOException {
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
	

	/**
	 * Retrieves a list of services offered by an artist with the specified artist
	 * ID.
	 *
	 * @param artistId The ID of the artist whose services are being retrieved.
	 * @return A list of services offered by the artist.
	 * @throws SQLException If a database access error occurs.
	 * @throws DAOException If an exception specific to the data access layer
	 *                      occurs.
	 */
	public static List<Service> getServicesByArtistId(int artistId) throws SQLException, DAOException {
		List<Service> servicesList = new ArrayList<>();

		String selectQuery = "SELECT * FROM artist_services WHERE artist_id = ?";

		try (Connection connection = ConnectionUtil.getConnection()) {
			try (PreparedStatement stmt = connection.prepareStatement(selectQuery)) {
				stmt.setInt(1, artistId);

				try (ResultSet rs = stmt.executeQuery()) {
					while (rs.next()) {
						Service service = new Service();
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

	/**
	 * Updates an existing service in the database.
	 *
	 * @param service The service object containing the updated information.
	 * @return True if the update was successful, false otherwise.
	 * @throws SQLException If a database access error occurs.
	 * @throws DAOException If an exception specific to the data access layer
	 *                      occurs.
	 */
	public static boolean updateService(Service service) throws SQLException, DAOException {
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

	/**
	 * Deletes a service from the database based on the artist ID and service ID.
	 *
	 * @param artistId  The ID of the artist associated with the service.
	 * @param serviceId The ID of the service to be deleted.
	 * @return True if the deletion was successful, false otherwise.
	 * @throws SQLException If a database access error occurs.
	 * @throws DAOException If an exception specific to the data access layer
	 *                      occurs.
	 */
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

	/**
	 * Retrieves a service from the database based on the provided service ID and
	 * artist ID.
	 *
	 * @param id       The ID of the service to be retrieved.
	 * @param artistId The ID of the artist associated with the service.
	 * @return The retrieved service object if found, or an empty service object if
	 *         not found.
	 * @throws SQLException If a database access error occurs.
	 * @throws DAOException If an exception specific to the data access layer
	 *                      occurs.
	 */
	
	
	
	public static Service getServiceById(int id, int artistId) throws SQLException, DAOException {
		Service service = new Service();
		String selectQuery = "SELECT * FROM artist_services WHERE id = ? AND artist_id = ?";

		try (Connection connection = ConnectionUtil.getConnection()) {
			try (PreparedStatement stmt = connection.prepareStatement(selectQuery)) {
				stmt.setInt(1, id);
				stmt.setInt(2, artistId);

				try (ResultSet rs = stmt.executeQuery()) {
					if (rs.next()) {
						service.setArtistId(rs.getInt("artist_id"));
						service.setCategory(ServiceCategory.valueOf(rs.getString("category")));
						service.setName(rs.getString("name"));
						service.setCost(rs.getDouble("cost"));
						service.setSampleImage(rs.getString("sample_image"));
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

		return service;
	}

}
