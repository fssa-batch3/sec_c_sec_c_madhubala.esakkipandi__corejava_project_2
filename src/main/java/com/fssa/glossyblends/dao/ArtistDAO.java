package com.fssa.glossyblends.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.fssa.glossyblends.customexception.DAOException;
import com.fssa.glossyblends.model.Artist;
import com.fssa.glossyblends.model.Post;
import com.fssa.glossyblends.model.Service;
import com.fssa.glossyblends.model.ServiceCategory;
import com.fssa.glossyblends.util.ConnectionUtil;

/**
 * Data Access Object (DAO) for managing Artist data in the database.
 */

public class ArtistDAO {

	private ArtistDAO() {

	}

	/**
	 * Retrieves the artist ID associated with the provided artist name.
	 *
	 * @param artistName The name of the artist.
	 * @return The artist ID associated with the provided artist name.
	 * @throws DAOException If an exception specific to the data access layer
	 *                      occurs.
	 * @throws SQLException If a database access error occurs.
	 */

	/// filtering or search purpose getartistby thrier name
	public static final String ERROR_GETTING_ID = "Error getting artist ID by artist email";

	public static int getArtistIdByName(String artistName) throws DAOException, SQLException {
		int id = 0;

		try (Connection connection = ConnectionUtil.getConnection()) {
			try (PreparedStatement stmt = connection
					.prepareStatement("SELECT artist_id FROM artists WHERE username = ?")) {
				stmt.setString(1, artistName);

				try (ResultSet rs = stmt.executeQuery()) {
					if (rs.next()) {
						id = rs.getInt("artist_id");
					}
				}

			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DAOException(ERROR_GETTING_ID);
		}
		return id;
	}

	public static List<Artist> getArtistByNames(String artistName) throws DAOException, SQLException {
		List<Artist> list = new ArrayList<>();

		Artist artist = null;

		try (Connection connection = ConnectionUtil.getConnection()) {
			try (PreparedStatement stmt = connection.prepareStatement("SELECT * FROM artists WHERE username = ?")) {
				stmt.setString(1, artistName);

				try (ResultSet rs = stmt.executeQuery()) {
					if (rs.next()) {
						artist = new Artist();
						artist.setUsername(rs.getString("username"));
						artist.setPassword(rs.getString("password"));
						artist.setEmail(rs.getString("email"));
						artist.setPhonenNumber(rs.getLong("phone_number"));
						artist.setYearsOfExperience(rs.getInt("years_of_experience"));
						artist.setAvailable(rs.getBoolean("is_available"));
						artist.setLocation(rs.getString("location"));
						artist.setLanguagesSpoken(rs.getString("languages_spoken"));
						artist.setGenderOfArtist(Artist.gender.valueOf(rs.getString("genderOfArtist")));
						artist.setArtistId(rs.getInt("artist_id"));
						artist.setImageurl(rs.getString("url"));
						list.add(artist);
					}
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DAOException("Error while getting artist by name");
		}
		return list;
	}

	// Add an artist object to the database
	/**
	 * Adds a new artist to the database.
	 *
	 * @param artist The artist object to be added.
	 * @return True if the artist was added successfully, false otherwise.
	 * @throws DAOException If an exception specific to the data access layer
	 *                      occurs.
	 * @throws SQLException If a database access error occurs.
	 */
	public static boolean addArtist(Artist artist) throws DAOException, SQLException {
		try (Connection connection = ConnectionUtil.getConnection()) {
			try (PreparedStatement stmt = connection.prepareStatement(
					"INSERT INTO artists (username, password, email, phone_number, years_of_experience, is_available, location, languages_spoken, genderOfArtist, url) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)")) {

				stmt.setString(1, artist.getUsername());
				stmt.setString(2, artist.getPassword());
				stmt.setString(3, artist.getEmail());
				stmt.setLong(4, artist.getPhonenNumber());
				stmt.setInt(5, artist.getYearsOfExperience());
				stmt.setBoolean(6, artist.isAvailable());
				stmt.setString(7, artist.getLocation());
				stmt.setString(8, artist.getLanguagesSpoken());
				stmt.setString(9, artist.getGenderOfArtist().name());
				stmt.setString(10, artist.getImageurl());

				int rows = stmt.executeUpdate();
				return rows > 0;
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			throw new DAOException("Error while adding artist");
		}
	}

	/**
	 * Deletes an artist object from the database.
	 *
	 * @param artist The artist object to be deleted.
	 * @return True if the artist was deleted successfully, false otherwise.
	 * @throws DAOException If an exception specific to the data access layer
	 *                      occurs.
	 * @throws SQLException If a database access error occurs.
	 */
	public static boolean deleteArtist(Artist artist) throws DAOException, SQLException {
		try (Connection connection = ConnectionUtil.getConnection()) {
			try (PreparedStatement stmt = connection.prepareStatement("DELETE FROM artists WHERE artist_id = ?")) {
				stmt.setInt(1, artist.getArtistId());
				int rowsAffected = stmt.executeUpdate();
				return rowsAffected > 0;
			}
		} catch (DAOException e) {
			e.printStackTrace();
			throw new DAOException(e.getMessage());
		}
	}

	/**
	 * Updates an artist object in the database.
	 *
	 * @param artist The artist object with updated information.
	 * @return True if the artist was updated successfully, false otherwise.
	 * @throws DAOException If an exception specific to the data access layer
	 *                      occurs.
	 * @throws SQLException If a database access error occurs.
	 */
	public static boolean updateArtist(Artist artist) throws DAOException, SQLException {
		try (Connection connection = ConnectionUtil.getConnection()) {
			try (PreparedStatement stmt = connection.prepareStatement(
					"UPDATE artists SET username = ?, password = ?, email = ?, phone_number = ?, years_of_experience = ?, is_available = ?, location = ?, languages_spoken = ?, genderOfArtist = ?,url=? WHERE artist_id = ?")) {
				stmt.setString(1, artist.getUsername());
				stmt.setString(2, artist.getPassword());
				stmt.setString(3, artist.getEmail());
				stmt.setLong(4, artist.getPhonenNumber());
				stmt.setInt(5, artist.getYearsOfExperience());
				stmt.setBoolean(6, artist.isAvailable());
				stmt.setString(7, artist.getLocation());
				stmt.setString(8, artist.getLanguagesSpoken());
				stmt.setString(9, artist.getGenderOfArtist().name());
				stmt.setString(10, artist.getImageurl());

				stmt.setInt(11, artist.getArtistId());

				int rowsAffected = stmt.executeUpdate();
				return rowsAffected > 0; // Return true if artist updated successfully
			}
		} catch (DAOException e) {
			e.printStackTrace();
			throw new DAOException(e.getMessage());
		}
	}

	/**
	 * Gets an artist object by artist ID.
	 *
	 * @param artistId The ID of the artist to retrieve.
	 * @return The artist object corresponding to the given ID, or null if no artist
	 *         found.
	 * @throws DAOException If an exception specific to the data access layer
	 *                      occurs.
	 * @throws SQLException If a database access error occurs.
	 */
	public static Artist getArtistById(int artistId) throws DAOException, SQLException {
		Artist artist = null;
		try (Connection connection = ConnectionUtil.getConnection()) {
			try (PreparedStatement stmt = connection.prepareStatement("SELECT * FROM artists WHERE artist_id = ?")) {
				stmt.setInt(1, artistId);

				try (ResultSet rs = stmt.executeQuery()) {
					if (rs.next()) {
						artist = new Artist();
						artist.setUsername(rs.getString("username"));
						artist.setPassword(rs.getString("password"));
						artist.setEmail(rs.getString("email"));
						artist.setPhonenNumber(rs.getLong("phone_number"));
						artist.setYearsOfExperience(rs.getInt("years_of_experience"));
						artist.setAvailable(rs.getBoolean("is_available"));
						artist.setLocation(rs.getString("location"));
						artist.setLanguagesSpoken(rs.getString("languages_spoken"));
						artist.setGenderOfArtist(Artist.gender.valueOf(rs.getString("genderOfArtist")));
						artist.setArtistId(rs.getInt("artist_id"));
						artist.setImageurl(rs.getString("url"));
					}
				}

			}
		} catch (DAOException e) {
			e.printStackTrace();
		}
		return artist;
	}

	/**
	 * Retrieves a list of all email addresses in the database.
	 *
	 * @return A list of email addresses from the database.
	 * @throws DAOException If an exception specific to the data access layer
	 *                      occurs.
	 * @throws SQLException If a database access error occurs.
	 */
	public static List<String> getAllEmails() throws DAOException, SQLException {
		List<String> emailList = new ArrayList<>();
		try (Connection connection = ConnectionUtil.getConnection()) {
			try (PreparedStatement stmt = connection.prepareStatement("SELECT email FROM artists");
					ResultSet resultSet = stmt.executeQuery()) {

				while (resultSet.next()) {
					String email = resultSet.getString("email");
					emailList.add(email);
				}
			}
		} catch (DAOException e) {
			e.printStackTrace();
			throw new DAOException(e.getMessage() + "ErrorMesages");
		}
		return emailList;
	}

	/**
	 * Retrieves a list of posts by artist ID.
	 *
	 * @param artistId The ID of the artist whose posts are to be retrieved.
	 * @return A list of posts created by the artist.
	 * @throws DAOException If an exception specific to the data access layer
	 *                      occurs.
	 * @throws SQLException If a database access error occurs.
	 */
	public static List<Post> getPostsByArtistId(int artistId) throws SQLException, DAOException {
		List<Post> posts = new ArrayList<>();
		try (Connection connection = ConnectionUtil.getConnection()) {
			String query = "SELECT p.id, p.title, p.description, p.post_url, a.username "
					+ "FROM artist_posts p INNER JOIN artists a ON p.artist_id = a.artist_id "
					+ "WHERE a.artist_id = ?";

			try (PreparedStatement stmt = connection.prepareStatement(query)) {
				stmt.setInt(1, artistId);

				try (ResultSet rs = stmt.executeQuery()) {
					while (rs.next()) {
						Post post = new Post();
						post.setTitle(rs.getString("title"));
						post.setDescription(rs.getString("description"));
						post.setPostUrl(rs.getString("post_url"));

						posts.add(post);
					}
				}
			}

			return posts;
		} catch (SQLException e) {
			throw new DAOException("Error getting posts by artist ID");
		}
	}

	/**
	 * Retrieves a list of services by artist ID.
	 *
	 * @param artistId The ID of the artist whose services are to be retrieved.
	 * @return A list of services provided by the artist.
	 * @throws DAOException If an exception specific to the data access layer
	 *                      occurs.
	 * @throws SQLException If a database access error occurs.
	 */
	public static List<Service> getServicesByArtistId(int artistId) throws SQLException, DAOException {
		List<Service> services = new ArrayList<>();
		try (Connection connection = ConnectionUtil.getConnection()) {
			String query = "SELECT s.category, s.name, s.cost, s.sample_image, a.username "
					+ "FROM artist_services s INNER JOIN artists a ON s.artist_id = a.artist_id "
					+ "WHERE a.artist_id = ?";

			try (PreparedStatement stmt = connection.prepareStatement(query)) {
				stmt.setInt(1, artistId);

				try (ResultSet rs = stmt.executeQuery()) {
					while (rs.next()) {
						Service service = new Service();
						service.setCategory(ServiceCategory.valueOf(rs.getString("category")));
						service.setName(rs.getString("name"));
						service.setCost(rs.getDouble("cost"));
						service.setSampleImage(rs.getString("sample_image"));
						services.add(service);
					}
				}
			}

			return services;
		} catch (SQLException e) {
			throw new DAOException("Error getting services by artist ID");
		}
	}

	/**
	 * Retrieves a list of all artists from the database.
	 *
	 * @return A list of all artists stored in the database.
	 * @throws DAOException If an exception specific to the data access layer
	 *                      occurs.
	 * @throws SQLException If a database access error occurs.
	 */
	public static List<Artist> getAllArtists() throws SQLException, DAOException {
		List<Artist> artists = new ArrayList<>();
		try (Connection connection = ConnectionUtil.getConnection()) {
			String query = "SELECT * FROM artists";

			try (PreparedStatement stmt = connection.prepareStatement(query)) {

				try (ResultSet rs = stmt.executeQuery()) {
					while (rs.next()) {
						Artist artist = new Artist();
						artist.setUsername(rs.getString("username"));
						artist.setPassword(rs.getString("password"));
						artist.setEmail(rs.getString("email"));
						artist.setPhonenNumber(rs.getLong("phone_number"));
						artist.setYearsOfExperience(rs.getInt("years_of_experience"));
						artist.setAvailable(rs.getBoolean("is_available"));
						artist.setLocation(rs.getString("location"));
						artist.setLanguagesSpoken(rs.getString("languages_spoken"));
						artist.setGenderOfArtist(Artist.gender.valueOf(rs.getString("genderOfArtist")));
						artist.setArtistId(rs.getInt("artist_id"));
						artist.setImageurl(rs.getString("url"));
						artists.add(artist);
					}
				}
			}

			return artists;
		} catch (SQLException e) {
			throw new DAOException("Error getting all artists");
		}
	}

	public static int getArtistIdByEmail(String email) throws DAOException, SQLException {
		int artistId = -1;
		try (Connection connection = ConnectionUtil.getConnection()) {
			try (PreparedStatement stmt = connection
					.prepareStatement("SELECT artist_id FROM artists WHERE email = ?")) {
				stmt.setString(1, email);

				try (ResultSet rs = stmt.executeQuery()) {
					if (rs.next()) {
						artistId = rs.getInt("artist_id");
					}
				}
			}
		} catch (DAOException e) {
			e.printStackTrace();
		}

		return artistId;
		
	}

}
