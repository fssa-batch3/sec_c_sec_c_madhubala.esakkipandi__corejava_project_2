package com.fssa.glossyblends.dao;

import com.fssa.glossyblends.customexception.DatabaseConnectionException;
import com.fssa.glossyblends.model.Artist;
import com.fssa.glossyblends.model.Post;
import com.fssa.glossyblends.util.ConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
/**
 * Data Access Object (DAO) for managing Artist data in the database.
 */

public class ArtistDAO {

	
	private ArtistDAO() {
		
	}
    // Get artist ID by artist name
    public static int getArtistByName(String artistName) throws DatabaseConnectionException {
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
        } catch (SQLException e) {//catch the exception if any unexcepted sitution occur while connecting the database
            e.printStackTrace();
        }
        return id;
    }

    // Add an artist object to the database
    public static boolean addArtist(Artist artist) throws DatabaseConnectionException {

        try (Connection connection = ConnectionUtil.getConnection()) {
            try (PreparedStatement stmt = connection.prepareStatement(
                    "INSERT INTO artists (username, password, email, phone_number, years_of_experience, is_available, location, languages_spoken, genderOfArtist) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)")) {

                stmt.setString(1, artist.getUsername());
                stmt.setString(2, artist.getPassword());
                stmt.setString(3, artist.getEmail());
                stmt.setString(4, artist.getPhonenNumber());
                stmt.setInt(5, artist.getYearsOfExperience());
                stmt.setBoolean(6, artist.isAvailable());
                stmt.setString(7, artist.getLocation());
                stmt.setString(8, artist.getLanguagesSpoken());
                stmt.setString(9, artist.getGenderOfArtist().name());

                int rows;
                rows = stmt.executeUpdate();

                return rows > 0; // Return true if artist added successfully
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false; // Return false if artist addition fails
        }
    }

    // Delete an artist object from the database
    public static boolean deleteArtist(Artist artist) throws DatabaseConnectionException {
        try (Connection connection = ConnectionUtil.getConnection()) {
            try (PreparedStatement stmt = connection.prepareStatement("DELETE FROM artists WHERE artist_id = ?")) {
                stmt.setInt(1, artist.getArtistId());

                int rowsAffected;
                
                    rowsAffected = stmt.executeUpdate();
              

                return rowsAffected > 0; // Return true if artist deleted successfully
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false; // Return false if artist deletion fails
        }
    }

    // Update an artist object in the database
    public static boolean updateArtist(Artist artist) throws DatabaseConnectionException {
        try (Connection connection = ConnectionUtil.getConnection()) {
            try (PreparedStatement stmt = connection.prepareStatement(
                    "UPDATE artists SET username = ?, password = ?, email = ?, phone_number = ?, years_of_experience = ?, is_available = ?, location = ?, languages_spoken = ?, genderOfArtist = ? WHERE artist_id = ?")) {
                stmt.setString(1, artist.getUsername());
                stmt.setString(2, artist.getPassword());
                stmt.setString(3, artist.getEmail());
                stmt.setString(4, artist.getPhonenNumber());
                stmt.setInt(5, artist.getYearsOfExperience());
                stmt.setBoolean(6, artist.isAvailable());
                stmt.setString(7, artist.getLocation());
                stmt.setString(8, artist.getLanguagesSpoken());
                stmt.setString(9, artist.getGenderOfArtist().name());

                stmt.setInt(10, artist.getArtistId());

                int rows;
                rows = stmt.executeUpdate();

                return rows > 0; // Return true if artist updated successfully
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false; // Return false if artist update fails
        }
    }

    // Get an artist object by artist ID
    public static Artist getArtistById(String artistId) throws DatabaseConnectionException {
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
                        artist.setArtistId(rs.getInt("artist_id"));
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return artist;
    }

    // Get a list of all email addresses in the database
    public static List<String> getAllEmails() throws DatabaseConnectionException {
        List<String> emailList = new ArrayList<>();
        try (Connection connection = ConnectionUtil.getConnection()) {
            try (PreparedStatement stmt = connection.prepareStatement("SELECT email FROM artists");
                 ResultSet resultSet = stmt.executeQuery()) {

                while (resultSet.next()) {
                    String email = resultSet.getString("email");
                    emailList.add(email);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return emailList;
    }

    // Get a list of posts by artist ID
    public static List<Post> getPostsByArtistId(int artistId) throws SQLException, DatabaseConnectionException {
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
