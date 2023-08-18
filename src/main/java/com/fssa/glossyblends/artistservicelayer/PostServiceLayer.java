package com.fssa.glossyblends.artistservicelayer;

import com.fssa.glossyblends.customexception.DatabaseConnectionException;
import com.fssa.glossyblends.customexception.PostValueInvalidException;
import com.fssa.glossyblends.dao.PostDAO;
import com.fssa.glossyblends.model.Post;
import com.fssa.glossyblends.validator.PostValidations;

import java.util.List;

public class PostServiceLayer {

    // Add a new post
    public boolean addPost(Post post) throws PostValueInvalidException, DatabaseConnectionException {
        if (PostValidations.validatePost(post)) { // Validate the post using PostValidations
            return PostDAO.addPost(post); // Add the post to the database
        }
        return false; // Post is not valid, not added
    }

    // Get all posts by artist ID
    public List<Post> getPostsByArtistId(int artistId) throws DatabaseConnectionException {
        return PostDAO.getPostsByArtistId(artistId); // Retrieve posts from the database by artist ID
    }

    // Delete a post by post ID and artist ID
    public boolean deletePost(int postId, int artistId) throws DatabaseConnectionException {
        return PostDAO.deletePost(postId, artistId); // Delete the post from the database
    }
}
