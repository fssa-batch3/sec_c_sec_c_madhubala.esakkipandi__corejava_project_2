package com.fssa.glossyblends.validator;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

import com.fssa.glossyblends.errormessages.ErrorMessages;

/**
 * Validation utility class for image URL validation.
 */
public class ImageUrlValidations {

	// Private constructor to prevent instantiation
	private ImageUrlValidations() {
	}

	/**
	 * Validates the format of an image URL.
	 *
	 */
	public static boolean validateImageUrl(String imageUrl) throws IllegalArgumentException {
		if (imageUrl == null) {
			throw new IllegalArgumentException(ErrorMessages.INVALID_IMAGE_URL);
		}

		// Regular expression pattern to match valid image URLs
		String imagePattern = "\\b(?:https?|ftp)://\\S+\\.(?:jpg|jpeg|png|gif|bmp)\\b";
		Pattern pattern = Pattern.compile(imagePattern);
		Matcher urlMatcher = pattern.matcher(imageUrl);
		boolean isValid = urlMatcher.matches();

		if (!isValid) {
			throw new IllegalArgumentException(ErrorMessages.INVALID_SERVICE_IMAGE_URL_FORMAT_PATTERN);
		}

		return true;
	}
}
