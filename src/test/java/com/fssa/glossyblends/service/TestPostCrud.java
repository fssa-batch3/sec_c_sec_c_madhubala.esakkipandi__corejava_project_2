package com.fssa.glossyblends.service;

import static org.junit.jupiter.api.Assertions.fail;

import java.sql.SQLException;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.fssa.glossyblends.artistservicelayer.PostServiceLayer;
import com.fssa.glossyblends.customexception.DatabaseConnectionException;
import com.fssa.glossyblends.customexception.PostValueInvalidException;
import com.fssa.glossyblends.model.Post;

/**
 * Unit tests for CRUD (Create, Read, Update, Delete) operations on posts.
 */
class TestPostCrud {

    /**
     * Test adding a new post.
     * @throws DatabaseConnectionException 
     *
     */
    @Test
    void AddPostTestCase() throws PostValueInvalidException, SQLException, DatabaseConnectionException {

    	
        try {

            PostServiceLayer serviceLayer = new PostServiceLayer();
            Post post = new Post();
            post.setArtistId(9);
            post.setDescription("The second work");
            post.setPostUrl("https://example.com/image.jpg");
            post.setTitle("The Wedding makeup");

            boolean added = serviceLayer.addPost(post);
            Assertions.assertTrue(added);
        } catch (PostValueInvalidException e) {

            fail(e.getMessage());

        }

    }

    /**
     * Test deleting a post by ID.
     * @throws DatabaseConnectionException 
     *
     */
    @Test
    void testDeletePostByID() throws SQLException, DatabaseConnectionException {
        PostServiceLayer serviceLayer = new PostServiceLayer();
        
        int postIdToDelete = 76;
        int artistId = 9;

        boolean deleted = serviceLayer.deletePost(postIdToDelete, artistId);

        Assertions.assertTrue(deleted);
    }

    /**
     * Test getting posts by artist ID.
     * @throws DatabaseConnectionException 
     *
     */
    @Test
    void GetPostsByArtistIdTest() throws SQLException, DatabaseConnectionException {
        PostServiceLayer serviceLayer = new PostServiceLayer();
        int artistId = 10;

        List<Post> posts = serviceLayer.getPostsByArtistId(artistId);

        Assertions.assertEquals(1, posts.size());
    }
    
}
