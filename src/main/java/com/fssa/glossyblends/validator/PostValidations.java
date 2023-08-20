package com.fssa.glossyblends.validator;

import java.util.regex.Pattern;

import com.fssa.glossyblends.customexception.PostValueInvalidException;
//import com.fssa.glossyblends.model.Artist;
import com.fssa.glossyblends.errormessages.ErrorMessages;
import com.fssa.glossyblends.errormessages.PostErrorMessages;
import com.fssa.glossyblends.model.Post;

public class PostValidations {

	private PostValidations() {

	}

	private static final String TITLE_REGEX = "^[a-zA-Z0-9\\s]{1,100}$";
	private static final String DESCRIPTION_REGEX = "^[a-zA-Z0-9\\s]{1,500}$";
	private static final String IMAGE_URL_REGEX = "^(https?://).*$";

	public static boolean validatePost(Post post) throws PostValueInvalidException {
		try {
			validateTitle(post.getTitle());
			validateDescription(post.getDescription());
			validateImageUrl(post.getPostUrl());

			return true;
		} catch (PostValueInvalidException e) {
			return false;
		}
	}

	public static boolean validateTitle(String title) throws PostValueInvalidException {
		if (title == null || title.trim().isEmpty()) {
			throw new PostValueInvalidException(PostErrorMessages.INVALID_POST_TITLE_NULL);
		}

		if (!Pattern.matches(TITLE_REGEX, title)) {
			throw new PostValueInvalidException(PostErrorMessages.INVALID_POST_TITLE_NULL);
		}

		return true;
	}

	public static boolean validateDescription(String description) throws PostValueInvalidException {
		if (description == null || description.trim().isEmpty()) {
			throw new PostValueInvalidException(PostErrorMessages.INVALID_POST_DESCRIPTION_NULL);
		}

		if (!Pattern.matches(DESCRIPTION_REGEX, description)) {
			throw new PostValueInvalidException(PostErrorMessages.DESCRIPTION_LENGTH_FORMAT);
		}

		return true;
	}

	public static boolean validateImageUrl(String imageUrl) throws PostValueInvalidException {
		if (imageUrl == null || imageUrl.trim().isEmpty()) {
			throw new PostValueInvalidException(PostErrorMessages.INVALID_IMAGE_URL_NULL);
		}

		if (!Pattern.matches(IMAGE_URL_REGEX, imageUrl)) {
			throw new PostValueInvalidException(PostErrorMessages.INVALID_IMAGE_URL_FORMAT);
		}

		return true;
	}
}
