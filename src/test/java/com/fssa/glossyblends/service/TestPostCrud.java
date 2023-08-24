package com.fssa.glossyblends.service;

import static org.junit.jupiter.api.Assertions.fail;

import java.sql.SQLException;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.fssa.glossyblends.artistservicelayer.PostServiceLayer;
import com.fssa.glossyblends.customexception.DAOException;
import com.fssa.glossyblends.customexception.PostValueInvalidException;
import com.fssa.glossyblends.model.Post;

/**
 * Unit tests for CRUD (Create, Read, Update, Delete) operations on posts.
 */
class TestPostCrud {

    /**
     * Test adding a new post.
     * @throws DAOexception 
     *
     */
	@Test
	void AddPostTestCase() throws PostValueInvalidException, SQLException, DAOException {
	    try {
	        PostServiceLayer serviceLayer = new PostServiceLayer();

	        String artistEmail = "esakipandi@gmail.com";

	        // Create a post
	        Post post = new Post();
	        post.setDescription("The second work");
	        post.setPostUrl("https://example.com/image.jpg");
	        post.setTitle("The Wedding makeup");

	        boolean added = serviceLayer.addPost(artistEmail, post);
	        Assertions.assertTrue(added);
	    } catch (PostValueInvalidException e) {
	        fail(e.getMessage());
	    }
	}

	
	
	 
    /**
     * Test deleting a post by ID.
     * @throws DAOexception 
     *
     */
    @Test
    void testDeletePostByID() throws SQLException, DAOException,PostValueInvalidException {
        PostServiceLayer serviceLayer = new PostServiceLayer();
        
        int postIdToDelete = 73;
        int artistId = 9;

        boolean deleted = serviceLayer.deletePost(postIdToDelete, artistId);

        Assertions.assertTrue(deleted);
    }

    /**
     * Test getting posts by artist ID.
     * @throws DAOexception 
     *
     */
//    @Test
//    void GetPostsByArtistIdTest() throws SQLException, DAOException,PostValueInvalidException {
//        PostServiceLayer serviceLayer = new PostServiceLayer();
//        String artistId = "esakipandi@gmail.com";
//
//        List<Post> posts = serviceLayer.getPostsByArtistEmail(artistId);
//
//        Assertions.assertEquals(4, posts.size());
//    }
    
}
