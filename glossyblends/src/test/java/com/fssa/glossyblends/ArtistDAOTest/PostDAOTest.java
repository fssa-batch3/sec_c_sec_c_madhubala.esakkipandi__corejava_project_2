package com.fssa.glossyblends.ArtistDAOTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.fail;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.fssa.glossyblends.DAO.PostDAO;
import com.fssa.glossyblends.model.Artist.Post;

public class PostDAOTest {

    private static final String DB_URL = "jdbc:mysql://localhost:3306/Glossy_Blends_Artist";
    private static final String DB_USERNAME = "root";
    private static final String DB_PASSWORD = "123456";

    private Connection connection;
    private PostDAO postDAO;
    @Before
    public void setUpDatabaseAndPostDAO() {
        try {
            connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
            postDAO = new PostDAO(connection);
        } catch (SQLException e) {
            e.printStackTrace();
            fail("Failed to set up the test: " + e.getMessage());
        }
    }

    @After
    public void closeDatabaseConnection() {
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            fail("Failed to tear down the test: " + e.getMessage());
        }
    }

    @Test
    public void testGetPostsByArtistId() throws SQLException {
        int artistId = 2;

        List<Post> posts = postDAO.getPostsByArtistId(artistId);

        if (posts.isEmpty()) {
            System.out.println("No posts found for artist with ID: " + artistId);
        } else {
            for (Post post : posts) {
                System.out.println("Post ID: " + post.getPostId() + ", Artist ID: " + post.getArtistId());
            }
        }

        assertTrue(!posts.isEmpty());

        for (Post post : posts) {
            assertEquals(artistId, post.getArtistId());
        }
    }

    
    
    @Test
    public void testAddPost1() throws SQLException {
        // Create a new Post object with the required fields
        Post newPost = new Post();
        newPost.setPostId(2);
        newPost.setArtistId(2); // Set the correct artist ID here (in this case, it is 2)
        newPost.setTitle("New Artwork");
        newPost.setDescription("This is my latest artwork.");
        newPost.setPostUrl("https://example.com/new_artwork.jpg");

        boolean isPostAdded = postDAO.addPost(newPost);
        assertTrue(isPostAdded);
    }
    
    @Test
    public void testAddPost() throws SQLException {
        // Create a new Post object with the required fields
        Post newPost = new Post();
        newPost.setPostId(1);
        newPost.setArtistId(1);
        newPost.setTitle("New Artwork");
        newPost.setDescription("This is my latest artwork.");
        newPost.setPostUrl("https://example.com/new_artwork.jpg");

        boolean isPostAdded = postDAO.addPost(newPost);
        assertTrue(isPostAdded);
    }

    @Test
    public void testDeletePost(Post post) throws SQLException {
        int postIdToDelete =10 ;

        post.setPostId(postIdToDelete);
        
        
        boolean isPostDeleted = postDAO.deletePost(post.getPostId());
        assertTrue(isPostDeleted);
    }

    @Test
    public void testGetPostsByInvalidArtistId() throws SQLException {
        int invalidArtistId = -1; // Assuming -1 is an invalid artistId

        List<Post> posts = postDAO.getPostsByArtistId(invalidArtistId);
        assertTrue(posts.isEmpty()); // Since the artistId is invalid, the list should be empty
    }

 

    @Test
    public void testDeleteInvalidPost() throws SQLException {
        String invalidPostId = "invalid123"; // Assuming "invalid123" is not a valid postId in the database

        boolean isPostDeleted = postDAO.deletePost(invalidPostId);
        assertFalse(isPostDeleted); // Deleting an invalid post should return false
    }

    @Test
    public void testConnectionStatus() throws SQLException {
        // Ensure the setUp and tearDown methods are working correctly and the connection is established and closed properly
        assertTrue(connection.isValid(5));
    }
}
