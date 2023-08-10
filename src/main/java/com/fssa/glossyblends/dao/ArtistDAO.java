package com.fssa.glossyblends.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.fssa.glossyblends.model.Artist;
import com.fssa.glossyblends.model.Post;
import com.fssa.glossyblends.util.ConnectionUtil;

 public class ArtistDAO {

	
	public static int getArtistByName(String artistName) {
		int id = 0;
		try (Connection connection = ConnectionUtil.getConnection()) {
			try (PreparedStatement stmt = connection
					.prepareStatement("SELECT artist_id FROM artists WHERE username = ?")) {
				stmt.setString(1, artistName);

				try (ResultSet rs = stmt.executeQuery()) {
					while (rs.next()) {
						id = rs.getInt("artist_id");
					}
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return id;
	}

	// adding the artist artist object
	public static boolean addArtist(Artist artist)   {

		try (Connection connection = ConnectionUtil.getConnection()) {
			try (PreparedStatement stmt = connection.prepareStatement(
					"INSERT INTO artists (username, password, email, phone_number, years_of_experience, is_available, location, languages_spoken, genderOfArtist, averageRating) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)")) {

				stmt.setString(1, artist.getUsername());
				stmt.setString(2, artist.getPassword());
				stmt.setString(3, artist.getEmail());
				stmt.setString(4, artist.getPhonenNumber());
				stmt.setInt(5, artist.getYearsOfExperience());
				stmt.setBoolean(6, artist.isAvailable());
				stmt.setString(7, artist.getLocation());
				stmt.setString(8, artist.getLanguagesSpoken());
				stmt.setString(9, artist.getGenderOfArtist().name());
				stmt.setDouble(10, artist.getAverageRating());

				int rows;
				try {
					rows = stmt.executeUpdate();

					System.out.println(rows);
				} catch (SQLException e) {
					e.printStackTrace();
					System.out.println(e.getMessage());
					return false;
				}

				return rows > 0;
			}
		}

		catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	// delete artist object
	public static boolean deleteArtist(Artist artist) {
		try (Connection connection = ConnectionUtil.getConnection()) {
			try (PreparedStatement stmt = connection.prepareStatement("DELETE FROM artists WHERE artist_id = ?")) {
				stmt.setInt(1, artist.getArtistId());

				int rowsAffected;
				try {
					rowsAffected = stmt.executeUpdate();
				} catch (SQLException e) {
					e.printStackTrace();
					return false;
				}

				
				return rowsAffected > 0;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	public static boolean updateArtist(Artist artist) {
		try (Connection connection = ConnectionUtil.getConnection()) {
			try (PreparedStatement stmt = connection.prepareStatement(
					"UPDATE artists SET username = ?, password = ?, email = ?, phone_number = ?, years_of_experience = ?, is_available = ?, location = ?, languages_spoken = ?, genderOfArtist = ?, averageRating = ? WHERE artist_id = ?")) {
				stmt.setString(1, artist.getUsername());
				stmt.setString(2, artist.getPassword());
				stmt.setString(3, artist.getEmail());
				stmt.setString(4, artist.getPhonenNumber());
				stmt.setInt(5, artist.getYearsOfExperience());
				stmt.setBoolean(6, artist.isAvailable());
				stmt.setString(7, artist.getLocation());
				stmt.setString(8, artist.getLanguagesSpoken());
				stmt.setString(9, artist.getGenderOfArtist().name());
				stmt.setDouble(10, artist.getAverageRating());

				stmt.setInt(11, artist.getArtistId());

				int rows;
				try {
					rows = stmt.executeUpdate();
				} catch (SQLException e) {
					e.printStackTrace();
					return false;
				}
				return rows > 0;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	/// geting artist object by using the Artist Id
	public static Artist getArtistById(String artistId) {
		Artist artist = null;
		try (Connection connection = ConnectionUtil.getConnection()) {
			try (PreparedStatement stmt = connection.prepareStatement("SELECT * FROM artists WHERE artist_id = ?")) {
				stmt.setString(1, artistId);

				try (ResultSet rs = stmt.executeQuery()) {
					if (rs.next()) {
						artist = new Artist();
						artist.setUsername(rs.getString("username"));
						artist.setPassword(rs.getString("password"));
						artist.setEmail(rs.getString("email"));
						artist.setPhonenNumber(rs.getString("phone_number"));
						artist.setYearsOfExperience(rs.getInt("years_of_experience"));
						artist.setAvailable(rs.getBoolean("is_available"));
						artist.setLocation(rs.getString("location"));
						artist.setLanguagesSpoken(rs.getString("languages_spoken"));
						artist.setGenderOfArtist(Artist.gender.valueOf(rs.getString("genderOfArtist")));
						artist.setAverageRating(rs.getDouble("averageRating"));
						artist.setArtistId(rs.getInt("artist_id"));
					}
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return artist;
	}

	public static List<String> getAllEmails() {
		List<String> emailList = new ArrayList<>();
		try (Connection connection = ConnectionUtil.getConnection()) {
			try (PreparedStatement stmt = connection.prepareStatement("SELECT email FROM artists");
					ResultSet resultSet = stmt.executeQuery()) {

				while (resultSet.next()) {
					String email = resultSet.getString("email");
					emailList.add(email);
				}
				System.out.println("sdfghjk");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return emailList;
	}

	
	public static List<Post> getPostsByArtistId(int artistId) throws SQLException {
		List<Post> posts = new ArrayList<>();
		try (Connection connection = ConnectionUtil.getConnection()) {
			try {
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
			} catch (SQLException e) {
				e.printStackTrace();
			}

			return posts;
		}
	}
}
