package com.fssa.glossyblends.service;

import static org.junit.jupiter.api.Assertions.fail;

import java.sql.SQLException;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.fssa.glossyblends.customexception.DAOException;
import com.fssa.glossyblends.customexception.PostValueInvalidException;
import com.fssa.glossyblends.model.Post;
import com.fssa.glossyblends.service.PostService;

/**
 * Unit tests for CRUD (Create, Read, Update, Delete) operations on posts.
 */
class TestPostService {
    /**
     * Test adding a new post.
     * @throws DAOException if there's an issue with the DAO operations.
     * @throws PostValueInvalidException if the post values are invalid.
     * @throws SQLException if there's an issue with SQL operations.
     */
	@Test
	void AddPostTestCase() throws SQLException, DAOException,PostValueInvalidException {
	    try {
	        PostService serviceLayer = new PostService();

	        String artistEmail = "varsha@gmail.com";

	        Post post = new Post();
	        post.setDescription("My second work");
	        post.setPostUrl("https://iili.io/HyJ7F8g.jpg");
	        post.setTitle("The Wedding makeup");
	        boolean added = serviceLayer.addPost(artistEmail, post);
	        Assertions.assertTrue(added);

	        
	    } catch (PostValueInvalidException | DAOException e) {
	      e.printStackTrace();
	    }
	}
	


	
	
	
    /**
     * Test deleting a post by ID.
     * @throws DAOException if there's an issue with the DAO operations.
     * @throws PostValueInvalidException if the post values are invalid.
     * @throws SQLException if there's an issue with SQL operations.
     */
    @Test
    void testDeletePostByID() throws SQLException, DAOException,PostValueInvalidException {
        PostService serviceLayer = new PostService();
        
        int postIdToDelete = 9;
        int artistId = 6;

        boolean deleted = serviceLayer.deletePost(postIdToDelete, artistId);

        Assertions.assertTrue(deleted);
    }
    /**
     * Test getting posts by artist ID.
     * @throws DAOException if there's an issue with the DAO operations.
     * @throws PostValueInvalidException if the post values are invalid.
     * @throws SQLException if there's an issue with SQL operations.
     */
    @Test
    void GetPostsByArtistIdTest() throws SQLException, DAOException,PostValueInvalidException {
        PostService serviceLayer = new PostService();
        String artistId = "prathiuhsa@gmail.com";
        List<Post> posts = serviceLayer.getPostsByArtistEmail(artistId);

        Assertions.assertEquals(7, posts.size());
    }
    
    
}
