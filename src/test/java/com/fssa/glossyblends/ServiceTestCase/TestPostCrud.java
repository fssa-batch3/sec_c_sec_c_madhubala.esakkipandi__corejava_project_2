package com.fssa.glossyblends.ServiceTestCase;

import static org.junit.Assert.fail;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.sql.Connection;
import java.util.List;



import com.fssa.glossyblends.DAO.PostDAO;
import com.fssa.glossyblends.ArtistServiceLayer.PostServiceLayer;
import com.fssa.glossyblends.CustomException.PostValueInvalidException;
import com.fssa.glossyblends.model.Artist.Post;

import Connection.ConnectionUtil;

public class TestPostCrud {

	@Test
	public void AddPostTestCase() throws PostValueInvalidException {

		try {
			Connection connection = ConnectionUtil.getConnection();

			PostDAO postDao = new PostDAO(connection);
			PostServiceLayer serviceLayer = new PostServiceLayer(postDao);
			Post post = new Post();
			post.setArtistId(1);
			post.setDescription("The first work");
			post.setPostId(30);
			post.setPostUrl("https://example.com/image.jpg");
			post.setTitle("The Weeding makeup");

			boolean added = serviceLayer.addPost(post);
			Assertions.assertTrue(added);

		} catch (PostValueInvalidException e) {

			fail(e.getMessage());

		}

	}

	@Test

	public void DeletePostByIDTest() {

		Connection connection = ConnectionUtil.getConnection();

		PostDAO postDao = new PostDAO(connection);
		PostServiceLayer serviceLayer = new PostServiceLayer(postDao);
		int artistId = 1;

		List<Post> listOfPost = postDao.getPostsByArtistId(artistId);

		int postId = 55;

		boolean deleted = serviceLayer.deletePost(postId);

		Assertions.assertTrue(deleted);

	}

	@Test
	public void GetPostsByArtistIdTest() {
		Connection connection = ConnectionUtil.getConnection();
		PostDAO postDao = new PostDAO(connection);
		PostServiceLayer serviceLayer = new PostServiceLayer(postDao);
		int artistId = 2;

		List<Post> posts = serviceLayer.getPostsByArtistId(artistId);

		Assertions.assertEquals(6, posts.size());

	}

}
