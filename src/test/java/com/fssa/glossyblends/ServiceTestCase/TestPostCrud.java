package com.fssa.glossyblends.ServiceTestCase;

import static org.junit.jupiter.api.Assertions.fail;

import java.sql.Connection;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.fssa.glossyblends.ArtistServiceLayer.PostServiceLayer;
import com.fssa.glossyblends.CustomException.PostValueInvalidException;
import com.fssa.glossyblends.DAO.PostDAO;
import com.fssa.glossyblends.model.Artist.Post;
import com.fssa.glossyblends.util.ConnectionUtil;

public class TestPostCrud {

	@Test
	public void AddPostTestCase() throws PostValueInvalidException {

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

		} catch (PostValueInvalidException e) {

			fail(e.getMessage());

		}

	}

	@Test
	public void testDeletePostByID() {
	    Connection connection = ConnectionUtil.getConnection();

	    PostDAO postDao = new PostDAO(connection);
	    PostServiceLayer serviceLayer = new PostServiceLayer(postDao);
	    
	    int postIdToDelete = 15;
	    int artistId=7;

	    boolean deleted = serviceLayer.deletePost(postIdToDelete, artistId);

	    Assertions.assertTrue( deleted);

	}

	

	@Test
	public void GetPostsByArtistIdTest() {
		Connection connection = ConnectionUtil.getConnection();
		PostDAO postDao = new PostDAO(connection);
		PostServiceLayer serviceLayer = new PostServiceLayer(postDao);
		int artistId = 10;

		List<Post> posts = serviceLayer.getPostsByArtistId(artistId);

		Assertions.assertEquals(1, posts.size());

	}

}
