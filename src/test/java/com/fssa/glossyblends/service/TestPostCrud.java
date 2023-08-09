package com.fssa.glossyblends.service;

import static org.junit.jupiter.api.Assertions.fail;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.fssa.glossyblends.artistservicelayer.PostServiceLayer;
import com.fssa.glossyblends.customexception.PostValueInvalidException;
import com.fssa.glossyblends.dao.PostDAO;
import com.fssa.glossyblends.model.Post;
import com.fssa.glossyblends.util.ConnectionUtil;

 class TestPostCrud {

	@Test
	 void AddPostTestCase() throws PostValueInvalidException, SQLException {

		try {
			Connection connection = ConnectionUtil.getConnection();

			PostDAO postDao = new PostDAO(connection);
			PostServiceLayer serviceLayer = new PostServiceLayer(postDao);
			Post post = new Post();
			post.setArtistId(9);
			post.setDescription("The second work");
			post.setPostUrl("https://example.com/image.jpg");
			post.setTitle("The Weeding makeup");

			boolean added = serviceLayer.addPost(post);
			Assertions.assertTrue(added);
			   connection.close();
		} catch (PostValueInvalidException e) {

			fail(e.getMessage());

		}

	}

	@Test
	 void testDeletePostByID() throws SQLException {
	    Connection connection = ConnectionUtil.getConnection();

	    PostDAO postDao = new PostDAO(connection);
	    PostServiceLayer serviceLayer = new PostServiceLayer(postDao);
	    
	    int postIdToDelete = 41;
	    int artistId=9;

	    boolean deleted = serviceLayer.deletePost(postIdToDelete, artistId);

	    Assertions.assertTrue( deleted);
	    connection.close();
	}

	

	@Test
	 void GetPostsByArtistIdTest() throws SQLException {
		Connection connection = ConnectionUtil.getConnection();
		PostDAO postDao = new PostDAO(connection);
		PostServiceLayer serviceLayer = new PostServiceLayer(postDao);
		int artistId = 10;

		List<Post> posts = serviceLayer.getPostsByArtistId(artistId);

		Assertions.assertEquals(1, posts.size());
		   connection.close();
	}

}
