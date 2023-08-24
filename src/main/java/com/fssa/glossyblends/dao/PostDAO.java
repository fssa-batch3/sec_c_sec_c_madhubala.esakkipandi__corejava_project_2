package com.fssa.glossyblends.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.fssa.glossyblends.dao.*;
import com.fssa.glossyblends.customexception.DAOException;
import com.fssa.glossyblends.model.Post;
import com.fssa.glossyblends.util.ConnectionUtil;

/**
 * Data Access Object (DAO) for managing post data in the database.
 */

public class PostDAO {

	
	private PostDAO() {

	}

	public static boolean addPost(String email , Post post) throws DAOException, SQLException {
		try (Connection connection = ConnectionUtil.getConnection()) {
			String sql = "INSERT INTO artist_posts (artist_id, title, description, post_url) VALUES (?, ?, ?, ?)";
			try (PreparedStatement stmt = connection.prepareStatement(sql)) {
				
                int artistId=getIdByArtistEmail(email);
				stmt.setInt(1, artistId);
				stmt.setString(2, post.getTitle());
				stmt.setString(3, post.getDescription());
				stmt.setString(4, post.getPostUrl());
				int rows = stmt.executeUpdate();
				return rows > 0; // Return true if the post was successfully added

			}
		} catch (SQLException e) {
			throw new DAOException("Error adding post to the database.");
		}
	}
	

	// Get posts by artist ID
	public static List<Post> getPostsByArtistEmail(String email) throws DAOException {
	    List<Post> postsList = new ArrayList<>();
	    try (Connection connection = ConnectionUtil.getConnection()) {
	        int artistId = getIdByArtistEmail(email); 
	        
	        if (artistId != -1) { 
	            String sql = "SELECT * FROM artist_posts WHERE artist_id = ?";
	            try (PreparedStatement stmt = connection.prepareStatement(sql)) {
	                stmt.setInt(1, artistId);
	                try (ResultSet rs = stmt.executeQuery()) {
	                    while (rs.next()) {
	                        Post post = new Post();
	                        post.setPostId(rs.getInt("id"));
	                        post.setArtistId(artistId);
	                        post.setTitle(rs.getString("title"));
	                        post.setDescription(rs.getString("description"));
	                        post.setPostUrl(rs.getString("post_url"));
	                        postsList.add(post);
	                    }
	                }
	            }
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
            throw new DAOException("Error getting atist by  artist email");

	    }

	    return postsList; // Return a list of posts by the artist with the specified email
	}


	// Delete a post by post ID and artist ID
	public static boolean deletePost(int postId, int artistId) throws DAOException {
		try (Connection connection = ConnectionUtil.getConnection()) {
			try (PreparedStatement stmt = connection
					.prepareStatement("DELETE FROM artist_posts WHERE id = ? AND artist_id = ?")) {

				stmt.setInt(1, postId);
				stmt.setInt(2, artistId);
				int rows = stmt.executeUpdate();

				return rows > 0; // Return true if the post was successfully deleted
			}

		} catch (SQLException e) {
			e.printStackTrace();
            throw new DAOException("Error getting atist by  artist email");
		}
	}

	
	public static int getIdByArtistEmail(String email) throws DAOException {
	    try (Connection connection = ConnectionUtil.getConnection()) {
	        String sql = "SELECT artist_id FROM artists WHERE email = ?";
	        try (PreparedStatement smt = connection.prepareStatement(sql)) {
	            smt.setString(1, email);
	            try (ResultSet resultSet = smt.executeQuery()) {
	                if (resultSet.next()) {
	                    return resultSet.getInt("artist_id");
	                }
	            }
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
            throw new DAOException("Error getting atist by  artist email");


	    }
	    return -1;
	}


}
