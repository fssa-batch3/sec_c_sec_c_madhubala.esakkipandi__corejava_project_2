package com.fssa.glossyblends.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.fssa.glossyblends.model.Artist.Post;

public class PostDAO {
	private Connection connection;

	public PostDAO(Connection connection) {
		this.connection = connection;
	}

	// adding post
	public boolean addPost(Post post) {
		try {
			int artistId = post.getArtistId(); // Get the artist_id from the post
			PreparedStatement stmt = connection.prepareStatement(
					"INSERT INTO artist_posts (artist_id, post_id, title, description, post_url) VALUES (?, ?, ?, ?, ?)");
			stmt.setInt(1, artistId); // Set the artist_id as an integer
			stmt.setInt(2, post.getPostId());
			stmt.setString(3, post.getTitle());
			stmt.setString(4, post.getDescription());
			stmt.setString(5, post.getPostUrl());

			int rows = stmt.executeUpdate();
			stmt.close();

			return rows > 0;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	// get the post by artist if

	public List<Post> getPostsByArtistId(int list) {
	    List<Post> postsList = new ArrayList<Post>();

	    try {
	        PreparedStatement stmt = connection.prepareStatement("SELECT * FROM artist_posts WHERE artist_id = ?");
	        stmt.setInt(1, list);

	        ResultSet rs = stmt.executeQuery();

	        while (rs.next()) {
	            Post post = new Post();
	            post.setPostId(rs.getInt("post_id"));
	            post.setArtistId(rs.getInt("artist_id"));
	            post.setTitle(rs.getString("title"));
	            post.setDescription(rs.getString("description"));
	            post.setPostUrl(rs.getString("post_url"));

	            postsList.add(post);
	        }

	        
	        rs.close();
	        stmt.close();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    return postsList;
	}

	/// deleting the post

	// Corrected deletePost method in PostDAO
	public boolean deletePost(int postId) {
	    try {
	        PreparedStatement stmt = connection.prepareStatement("DELETE FROM artist_posts WHERE post_id = ?");
	        stmt.setInt(1, postId);

	        int rows = stmt.executeUpdate();
	        stmt.close();

	        return rows > 0;
	    } catch (SQLException e) {
	        e.printStackTrace();
	        return false;
	    }
	}

	

}
