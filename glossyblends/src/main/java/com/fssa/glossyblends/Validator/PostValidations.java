package com.fssa.glossyblends.Validator;
import java.util.List;
import java.util.regex.Pattern;

import com.fssa.glossyblends.model.Artist.Artist;
import com.fssa.glossyblends.model.Artist.ErrorMessages;
import com.fssa.glossyblends.model.Artist.Post;
import com.fssa.glossyblends.model.Artist.Services;

public class PostValidations {

    private static final String TITLE_REGEX = "^[a-zA-Z0-9\\s]{1,100}$";
    private static final String DESCRIPTION_REGEX = "^[a-zA-Z0-9\\s]{1,500}$";
    private static final String IMAGE_URL_REGEX = "^(https?://).*$";

    public static boolean validatePost(Post post) throws IllegalArgumentException {
        try {
            validateTitle(post.getTitle());
            validateDescription(post.getDescription());
            validateImageUrl(post.getPostUrl());

            return true;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public static boolean validateTitle(String title) throws IllegalArgumentException {
        if (title == null || title.trim().isEmpty()) {
            throw new IllegalArgumentException(ErrorMessages.INVALID_POST_TITLE_NULL);
        }

        if (!Pattern.matches(TITLE_REGEX, title)) {
            throw new IllegalArgumentException(ErrorMessages.INVALID_POST_TITLE_NULL);
        }

        return true;
    }

 

    public static boolean validateDescription(String description) throws IllegalArgumentException {
        if (description == null || description.trim().isEmpty()) {
            throw new IllegalArgumentException(ErrorMessages.INVALID_POST_DESCRIPTION_NULL);
        }

        
        if (!Pattern.matches(DESCRIPTION_REGEX, description)) {
            throw new IllegalArgumentException(ErrorMessages.DESCRIPTION_LENGTH_FORMAT);
        }
        

        return true;
    }

    public static boolean validateImageUrl(String imageUrl) throws IllegalArgumentException {
        if (imageUrl == null || imageUrl.trim().isEmpty()) {
            throw new IllegalArgumentException(ErrorMessages.INVALID_IMAGE_URL);
        }

        if (!Pattern.matches(IMAGE_URL_REGEX, imageUrl)) {
            throw new IllegalArgumentException(ErrorMessages.INVALID_SERVICE_IMAGE_URL_FORMAT_PATTERN);
        }

        return true;
    }
}
