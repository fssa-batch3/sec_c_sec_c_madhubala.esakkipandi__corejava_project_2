package com.fssa.glossyblends.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.fssa.glossyblends.model.Post;
import com.fssa.glossyblends.util.ConnectionUtil;

public class PostDAO {
   
    // adding post
    public  static boolean addPost(Post post) {
    	
    	
    	try(Connection connection=ConnectionUtil.getConnection()){
        try (PreparedStatement stmt = connection.prepareStatement(
                "INSERT INTO artist_posts (artist_id, title, description, post_url) VALUES (?, ?, ?, ?)")) {
            int artistId = post.getArtistId();

            stmt.setInt(1, artistId); 
//            stmt.setInt(2, post.getPostId());
            stmt.setString(2, post.getTitle());
            stmt.setString(3, post.getDescription());
            stmt.setString(4, post.getPostUrl());

            int rows = stmt.executeUpdate();
            return rows > 0;
        } 
    }catch (SQLException e) {
        e.printStackTrace();
        return false;

    }

    }

    // get the post by artist if
    public static List<Post> getPostsByArtistId(int artistId)   {
        List<Post> postsList = new ArrayList<>();
    	try(Connection connection=ConnectionUtil.getConnection()){

        try (PreparedStatement stmt = connection.prepareStatement("SELECT * FROM artist_posts WHERE artist_id = ?")) {
            stmt.setInt(1, artistId);

            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    Post post = new Post();
                    post.setPostId(rs.getInt("id"));
                    post.setArtistId(rs.getInt("artist_id"));
                    post.setTitle(rs.getString("title"));
                    post.setDescription(rs.getString("description"));
                    post.setPostUrl(rs.getString("post_url"));

                    postsList.add(post);
                }
            }
        }
        } catch (SQLException e) {
            e.printStackTrace();
        }
	
     	
   	   return postsList;
   
    }
    public  static boolean deletePost(int postId, int artistId) {
    	try(Connection connection=ConnectionUtil.getConnection()){
            try (PreparedStatement stmt = connection.prepareStatement("DELETE FROM artist_posts WHERE id = ? AND artist_id = ?")) {
                stmt.setInt(1, postId);
                stmt.setInt(2, artistId);
                int rows = stmt.executeUpdate();
                System.out.println(rows);
                System.out.println("kjhgfd");
                return rows > 0;
               
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
            return false;
        }
    }
}
