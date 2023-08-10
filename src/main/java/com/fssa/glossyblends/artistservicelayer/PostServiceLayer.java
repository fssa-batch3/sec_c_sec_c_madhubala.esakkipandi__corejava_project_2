package com.fssa.glossyblends.artistservicelayer;

import com.fssa.glossyblends.customexception.PostValueInvalidException;
import com.fssa.glossyblends.dao.PostDAO;
import com.fssa.glossyblends.model.Post;
import com.fssa.glossyblends.validator.PostValidations;

import java.util.List;

public class PostServiceLayer {
	

	public boolean addPost(Post post) throws PostValueInvalidException {
		if (PostValidations.validatePost(post)) {
			return PostDAO.addPost(post);
		}
		return false;
	}

	public List<Post> getPostsByArtistId(int list) {
		return PostDAO.getPostsByArtistId(list);
	}

	public boolean deletePost(int post, int artistId) {

		return PostDAO.deletePost(post, artistId);

	}

}
