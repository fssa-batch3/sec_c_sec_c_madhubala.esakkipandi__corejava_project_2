package com.fssa.glossyblends.ArtistServiceLayer;

import com.fssa.glossyblends.CustomException.PostValueInvalidException;
import com.fssa.glossyblends.DAO.ArtistDAO;
import com.fssa.glossyblends.DAO.PostDAO;
import com.fssa.glossyblends.Validator.PostValidations;
import com.fssa.glossyblends.model.Post;

import java.sql.Connection;
import java.util.List;

public class PostServiceLayer {
	private PostDAO postDAO;

	public PostServiceLayer(PostDAO postDAO) {
		this.postDAO = postDAO;
	}

	public boolean addPost(Post post) throws PostValueInvalidException {
		if (PostValidations.validatePost(post)) {
			return postDAO.addPost(post);
		}
		return false;
	}

	public List<Post> getPostsByArtistId(int list) {
		return postDAO.getPostsByArtistId(list);
	}

	public boolean deletePost(int post, int artistId) {

		return postDAO.deletePost(post, artistId);

	}

}
