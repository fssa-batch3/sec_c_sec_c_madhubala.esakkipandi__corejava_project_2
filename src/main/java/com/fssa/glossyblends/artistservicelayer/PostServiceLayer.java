package com.fssa.glossyblends.artistservicelayer;

import com.fssa.glossyblends.customexception.DAOException;
import com.fssa.glossyblends.customexception.PostValueInvalidException;
import com.fssa.glossyblends.dao.PostDAO;
import com.fssa.glossyblends.model.Post;
import com.fssa.glossyblends.validator.PostValidations;

import java.sql.SQLException;
import java.util.List;

public class PostServiceLayer {

    // Add a new post
	 public boolean addPost(String email, Post post) throws PostValueInvalidException, DAOException, SQLException {
	        if (PostValidations.validatePost(post)) {
	        	// Validate the post using PostValidations
	            return PostDAO.addPost(email, post); // Add the post to the database
	        }
	        return false; // Post is not valid, not added
	    }

	 
	 

	 public List<Post> getPostsByArtistEmail(String  email) throws DAOException {
	        return PostDAO.getPostsByArtistEmail(email); // Retrieve posts from the database by artist ID
	    }
    // Delete a post by post ID and artist ID
    public boolean deletePost(int postId, int artistId) throws DAOException {
        return PostDAO.deletePost(postId, artistId); // Delete the post from the database
    }
    
    
    public int  getIdByArtistEmail(String email) throws DAOException {
    	
        return PostDAO.getIdByArtistEmail(email); // Retrieve posts from the database by artist ID
    }
    
    

   
}
