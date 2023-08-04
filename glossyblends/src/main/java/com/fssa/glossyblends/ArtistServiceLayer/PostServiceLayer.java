package com.fssa.glossyblends.ArtistServiceLayer;

import com.fssa.glossyblends.DAO.PostDAO;
import com.fssa.glossyblends.model.Artist.Post;
import com.fssa.glossyblends.Validator.PostValidations;

import java.sql.Connection;
import java.util.List;

public class PostServiceLayer {
    private PostDAO postDAO;

    public PostServiceLayer(Connection connection) {
        postDAO = new PostDAO(connection);
    }

    public boolean addPost(Post post) {
        // Validate the post before adding
        if (PostValidations.validatePost(post)) {
            return postDAO.addPost(post);
        }
        return false;
    }

    public List<Post> getPostsByArtistId(int artistId) {
        return postDAO.getPostsByArtistId(artistId);
    }

    public boolean deletePost(Post post) {
    	
    	
        return postDAO.deletePost(post);
    }
    
    
  
    	
    
}
