package com.fssa.glossyblends.artistservicelayer;

import com.fssa.glossyblends.customexception.PostValueInvalidException;
import com.fssa.glossyblends.dao.PostDAO;
import com.fssa.glossyblends.model.Post;
import com.fssa.glossyblends.validator.PostValidations;

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
