package com.fssa.glossyblends.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.fssa.glossyblends.CustomException.PostValueInvalidException;
import com.fssa.glossyblends.CustomException.ServiceValueInvalidException;
import com.fssa.glossyblends.Validator.ArtitsValidator;
import com.fssa.glossyblends.model.Artist.Artist;
import com.fssa.glossyblends.model.Artist.Post;

public class ArtistDAO {
	private static Connection connection;

	public ArtistDAO(Connection connection) {
		this.connection = connection;
	}

	
	/// gettig the artist object using the artist name
	public static int getArtistByName(String artistName) {
		try {
			PreparedStatement stmt = connection.prepareStatement("SELECT artist_id FROM artists WHERE username = ?");
			stmt.setString(1, artistName);

			ResultSet rs = stmt.executeQuery();
			int id = 0;
			while (rs.next()) {
				id = rs.getInt("artist_id");
			}
			return id;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	// adding the artist artist object
	public boolean addArtist(Artist artist) throws PostValueInvalidException, ServiceValueInvalidException {
		try {
			ArtitsValidator.validateArtist(artist);
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
			throw new IllegalArgumentException("Invalid artist passed to DAO Layer", e);
		}

		try {
			PreparedStatement stmt = connection.prepareStatement(
					 "INSERT INTO artists (username, password, email, phone_number, years_of_experience, is_available, location, languages_spoken, genderOfArtist, averageRating) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");

			stmt.setString(1, artist.getUsername());
			stmt.setString(2, artist.getPassword());
			stmt.setString(3, artist.getEmail());
			stmt.setString(4, artist.getPhone_number());
			stmt.setInt(5, artist.getYearsOfExperience());
			stmt.setBoolean(6, artist.isAvailable());
			stmt.setString(7, artist.getLocation());
			stmt.setString(8, artist.getLanguagesSpoken());
			stmt.setString(9, artist.getGenderOfArtist().name());
			stmt.setDouble(10, artist.getAverageRating());

			int rows = stmt.executeUpdate();
			stmt.close();
			System.out.println(rows);
			return rows > 0;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	// delete artist object

	public boolean deleteArtist(Artist artist) {
	    try {
	        PreparedStatement stmt = connection.prepareStatement("DELETE FROM artists WHERE artist_id = ?");
	        stmt.setInt(1, artist.getArtistId());

	        int rowsAffected = stmt.executeUpdate();
	        stmt.close();

	        return rowsAffected > 0;
	    } catch (SQLException e) {
	        e.printStackTrace();
	        return false;
	    }
	}


	public boolean updateArtist(Artist artist) {
		try {
			PreparedStatement stmt = connection.prepareStatement(
					"UPDATE artists SET username = ?, password = ?, email = ?, phone_number = ?, years_of_experience = ?, is_available = ?, location = ?, languages_spoken = ?, genderOfArtist = ?, averageRating = ? WHERE artist_id = ?");
			stmt.setString(1, artist.getUsername());
			stmt.setString(2, artist.getPassword());
			stmt.setString(3, artist.getEmail());
			stmt.setString(4, artist.getPhone_number());
			stmt.setInt(5, artist.getYearsOfExperience());
			stmt.setBoolean(6, artist.isAvailable());
			stmt.setString(7, artist.getLocation());
			stmt.setString(8, artist.getLanguagesSpoken());
			stmt.setString(9, artist.getGenderOfArtist().name());
			stmt.setDouble(10, artist.getAverageRating());

			stmt.setInt(11, artist.getArtistId());
			
			int rows = stmt.executeUpdate();
			stmt.close();
			return rows > 0; 
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	/// geting artist object by using the Artist Id
	public Artist getArtistById(String artistId) {
		Artist artist = null;
		try {
			PreparedStatement stmt = connection.prepareStatement("SELECT * FROM artists WHERE artist_id = ?");
			stmt.setString(1, artistId);

			ResultSet rs = stmt.executeQuery();

			if (rs.next()) {
				artist = new Artist();
				artist.setUsername(rs.getString("username"));
				artist.setPassword(rs.getString("password"));
				artist.setEmail(rs.getString("email"));
				artist.setPhone_number(rs.getString("phone_number"));
				artist.setYearsOfExperience(rs.getInt("years_of_experience"));
				artist.setAvailable(rs.getBoolean("is_available"));
				artist.setLocation(rs.getString("location"));
				artist.setLanguagesSpoken(rs.getString("languages_spoken"));
				artist.setGenderOfArtist(Artist.gender.valueOf(rs.getString("genderOfArtist")));
				artist.setAverageRating(rs.getDouble("averageRating"));
				artist.setArtistId(rs.getInt("artist_id"));
			}

			rs.close();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return artist;
	}

	

	public List<String> getAllEmails() {
		List<String> emailList = new ArrayList<String>();

		
		try {
			String query = "SELECT email FROM artists";
			PreparedStatement stmt = connection.prepareStatement(query);
			ResultSet resultSet = stmt.executeQuery();

			while (resultSet.next()) {
				String email = resultSet.getString("email");
				emailList.add(email);
			}

			
			
			resultSet.close();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return emailList;
	}
	
	
	
	

    public List<Post> getPostsByArtistId(int artistId) {
        List<Post> posts = new ArrayList<>();

        try {

        	String query = "SELECT p.post_id, p.title, p.description, p.post_url, a.username "
                    + "FROM artist_posts p INNER JOIN artists a ON p.artist_id = a.artist_id "
                    + "WHERE a.artist_id = ?";
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setInt(1, artistId);

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Post post = new Post();
                post.setTitle(rs.getString("title"));
                
                post.setDescription(rs.getString("description"));
                post.setPostUrl(rs.getString("post_url"));

                // Add other properties as needed

//                String artistName = rs.getString("username");
//                post.setArtistName(artistName); // Assuming you have a setter method for the artistName in the Post class

                posts.add(post);
                
            }

            rs.close();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return posts;
    }


}