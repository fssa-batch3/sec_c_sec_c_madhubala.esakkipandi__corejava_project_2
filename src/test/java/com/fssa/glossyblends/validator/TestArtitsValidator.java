package com.fssa.glossyblends.validator;

import static org.junit.jupiter.api.Assertions.assertEquals;

import static org.junit.jupiter.api.Assertions.fail;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.fssa.glossyblends.customexception.PostValueInvalidException;
import com.fssa.glossyblends.customexception.ScheduleValueInvalidException;
import com.fssa.glossyblends.customexception.ServiceValueInvalidException;
import com.fssa.glossyblends.model.Artist;
import com.fssa.glossyblends.model.Artist.gender;

import com.fssa.glossyblends.errormessages.ErrorMessages;
import com.fssa.glossyblends.errormessages.ScheduleErrorMessages;
import com.fssa.glossyblends.errormessages.ServiceErrorMessges;
import com.fssa.glossyblends.errormessages.PostErrorMessages;




import com.fssa.glossyblends.model.Post;
import com.fssa.glossyblends.model.ServiceCategory;
import com.fssa.glossyblends.model.Services;
import com.fssa.glossyblends.model.Schedule;

/**
 * Test class for validating Artist objects using JUnit tests.
 */

class TestArtitsValidator {

//validTestcase for username
	@Test
	void testValidationOfUserNameValid() {
		// Create an Artist object
		Artist artist = new Artist();

		// Set a valid username
		String name = "Madhubala";
		artist.setUsername(name);

		// Validate the username using ArtitsValidator class and assert the result
		Assertions.assertTrue(ArtitsValidator.validateUsername(artist.getUsername()));
	}

	@Test
	void testValidationEmailValid() {
		// Create an Artist object
		Artist ar = new Artist();

		// Set a valid email address
		ar.setEmail("Madhu@gamil.com");

		// Validate the email using ArtitsValidator class and assert the result
		Assertions.assertTrue(ArtitsValidator.validateEmail(ar.getEmail()));
	}

	@Test
	void testValidationNullEmailValid() {
		// Create an Artist object
		Artist ar = new Artist();

		// Set the email to null
		ar.setEmail(null);

		try {
			// Attempt to validate the email (should throw an exception)
			Assertions.assertTrue(ArtitsValidator.validateEmail(ar.getEmail()));
			// If no exception is thrown, fail the test with an error message
			Assertions.fail("It should throw an exception");
		} catch (IllegalArgumentException ex) {
			// Assert that the correct error message is returned in the exception
			Assertions.assertEquals(ErrorMessages.INVALID_EMAIL_NULL, ex.getMessage());
		}
	}

	@Test
	void testValidationEmailInValid() {
		// Create an Artist object
		Artist ar = new Artist();

		// Set an invalid email address format
		ar.setEmail("Madhugamil.com");

		try {
			// Attempt to validate the email (should throw an exception)
			Assertions.assertTrue(ArtitsValidator.validateEmail(ar.getEmail()));
			// If no exception is thrown, fail the test with an error message
			Assertions.fail("It should throw an exception");
		} catch (IllegalArgumentException ex) {
			// Assert that the correct error message is returned in the exception
			Assertions.assertEquals(ErrorMessages.INVALID_EMAIL_FORMAT, ex.getMessage());
		}
	}

	@Test
	void testValidateArtist_ValidArtist_ReturnsTrue()
			throws IllegalArgumentException, PostValueInvalidException, ServiceValueInvalidException {
		// Create an Artist object
		Artist artist = new Artist();
		// Set valid properties for the artist
		artist.setUsername("TestArtist");
		artist.setPassword("TestPassword123");
		artist.setEmail("test@example.com");
		artist.setPhonenNumber("1234567890");
		artist.setYearsOfExperience(5);
		artist.setAvailable(true);
		artist.setLanguagesSpoken("English");
		artist.setLocation("chennai");
		artist.setGenderOfArtist(gender.FEMALE);

		// Validate the artist using ArtitsValidator class and assert the result
		boolean result = ArtitsValidator.validateArtist(artist);
		Assertions.assertTrue(result);
	}

	@Test
	void testValidateArtistWithNull()
			throws IllegalArgumentException, ServiceValueInvalidException, PostValueInvalidException {
		try {
			Artist artist = null;
			ArtitsValidator.validateArtist(artist);
			Assertions.fail("Expected IllegalArgumentException was not thrown");
		} catch (IllegalArgumentException ex) {
			// Assert that the correct error message is returned in the exception
			Assertions.assertEquals("Artist object is null", ex.getMessage());
		}
	}

	@Test
	void testValidateArtist_InvalidUsername_ThrowsIllegalArgumentException()
			throws PostValueInvalidException, ServiceValueInvalidException {
		try {
			Artist artist = new Artist();
			artist.setUsername(null); // Invalid username

			// Attempt to validate the invalid username (should throw an exception)
			ArtitsValidator.validateUsername(artist.getUsername());
			Assertions.fail("IllegalArgumentException should be thrown for invalid username.");
		} catch (IllegalArgumentException e) {
			// Assert that the correct error message is returned in the exception
			Assertions.assertEquals(ErrorMessages.INVALID_USERNAME_NULL, e.getMessage());

		}
	}

	@Test
	void validUsername() throws IllegalArgumentException {
		Artist artist = new Artist();
		artist.setUsername("Madhubala"); // Valid username

		// Validate the valid username using ArtitsValidator class and assert the result
		boolean val = ArtitsValidator.validateUsername(artist.getUsername());

		Assertions.assertTrue(val);
	}

	@Test
	void testValidateArtist_InvalidPassword_ThrowsIllegalArgumentException()
			throws PostValueInvalidException, ServiceValueInvalidException {
		try {
			Artist artist = new Artist();

			artist.setPassword(null); // Invalid password

			// Attempt to validate the invalid password (should throw an exception)
			ArtitsValidator.validatePassword(artist.getPassword());
			Assertions.fail("IllegalArgumentException should be thrown for invalid password.");
		} catch (IllegalArgumentException e) {
			// Assert that the correct error message is returned in the exception
			Assertions.assertEquals(ErrorMessages.PASSWORD_NULL, e.getMessage());
		}
	}

	@Test
	void testValidationOfUserNameInValid() {
		try {
			Artist artist = new Artist();

			artist.setUsername(".23456789"); // Invalid username

			// Attempt to validate the invalid username (should throw an exception)
			ArtitsValidator.validateUsername(artist.getUsername());
			Assertions.fail("The testcase failed for name validations");

		} catch (IllegalArgumentException ex) {
			// Assert that the correct error message is returned in the exception
			Assertions.assertEquals(ServiceErrorMessges.INVALID_SERVICE_NAME_PATTERN, ex.getMessage());
		}
	}

	@Test
	// Valid testcases for years of experience
	void testValidateYearsOfExperienceValid() {
		Artist artist = new Artist();

		int yearsOfExperience = 5;

		artist.setYearsOfExperience(yearsOfExperience);

		// Validate the valid years of experience using ArtitsValidator class and assert
		// the result
		Assertions.assertTrue(ArtitsValidator.validateYearsOfExperience(artist.getYearsOfExperience()));
	}

	// Invalid yearsOfExperience (less than or equal to 0) should throw an
	// IllegalArgumentException
	@Test
	void testValidateYearsOfExperienceInvalid() {
		int yearsOfExperience = -2;

		Artist artist = new Artist();

		artist.setYearsOfExperience(yearsOfExperience);

		try {
			// Attempt to validate the invalid years of experience (should throw an
			// exception)
			ArtitsValidator.validateYearsOfExperience(artist.getYearsOfExperience());
			Assertions.fail("Expected exception was not thrown.");

		} catch (IllegalArgumentException e) {
			// Assert that the correct error message is returned in the exception
			Assertions.assertEquals(ErrorMessages.INVALID_YEARS_OF_EXPERIENCE_NEGATIVE, e.getMessage());
		}
	}

	// Test case for valid phone number
	@Test
	void testValidatePhoneNumberValid() {
		// Create an Artist object with a valid phone number
		Artist artist = new Artist();
		artist.setPhonenNumber("12345678");

		// Validate the phone number, expect a valid result
		Assertions.assertTrue(ArtitsValidator.validatePhoneNumber(artist.getPhonenNumber()));
	}

	// Test case for invalid phone number format
	@Test
	void testValidatePhoneNumberInValid() {
		try {
			// Create an Artist object with an invalid phone number
			Artist artist = new Artist();
			artist.setPhonenNumber("Madh123342");

			// Validate the invalid phone number, expect an exception to be thrown
			ArtitsValidator.validatePhoneNumber(artist.getPhonenNumber());

			// If no exception is thrown, the test fails
			Assertions.fail("Expected exception was not thrown.");
		} catch (IllegalArgumentException e) {
			// Check if the correct error message is provided
			Assertions.assertEquals(ErrorMessages.INVALID_PHONE_NUMBER_FORMAT, e.getMessage());
		}
	}

	// Test case for null mobile number
	@Test
	void testValidatePhoneNumberNull() {
		// Create an Artist object with a null phone number
		Artist artist = new Artist();
		artist.setPhonenNumber(null);

		try {
			// Validate the null phone number, expect an exception to be thrown
			ArtitsValidator.validatePhoneNumber(artist.getPhonenNumber());

			// If no exception is thrown, the test fails
			Assertions.fail("Expected exception was not thrown.");
		} catch (IllegalArgumentException e) {
			// Check if the correct error message is provided
			Assertions.assertEquals(ErrorMessages.INVALID_PHONE_NUMBER_NULL, e.getMessage());
		}
	}

	// Test case for empty mobile number
	@Test
	void testValidatePhoneNumberEmpty() {
		// Create an Artist object with an empty phone number
		Artist artist = new Artist();
		artist.setPhonenNumber(" ");

		try {
			// Validate the empty phone number, expect an exception to be thrown
			ArtitsValidator.validatePhoneNumber(artist.getPhonenNumber());

			// If no exception is thrown, the test fails
			Assertions.fail("Expected exception was not thrown.");
		} catch (IllegalArgumentException e) {
			// Check if the correct error message is provided
			Assertions.assertEquals(ErrorMessages.INVALID_PHONE_NUMBER_NULL, e.getMessage());
		}
	}

	// Test case for validating a valid post
	@Test
	void testValidatePost_ValidPost_ReturnsTrue() throws PostValueInvalidException {
		// Create a valid Post object
		Post validPost = new Post(1, 1, "Valid Title", "Valid Description", "https://example.com/image.jpg");

		// Set additional properties for the post
		validPost.setPostId(2);
		validPost.setArtistId(2);

		// Validate the post, expect a valid result
		Assertions.assertTrue(PostValidations.validatePost(validPost));
	}

	// Test case for validating null post title
	@Test
	void testValidateTitle_NullTitle_ThrowsIllegalArgumentException() throws PostValueInvalidException {
		try {
			// Create a Post object with a null title
			Post invalidPost = new Post();
			invalidPost.setTitle(null);

			// Validate the null title, expect an exception to be thrown
			PostValidations.validateTitle(invalidPost.getTitle());

			// If no exception is thrown, the test fails
			Assertions.fail("Expected IllegalArgumentException was not thrown.");
		} catch (PostValueInvalidException e) {
			// Check if the correct error message is provided
			Assertions.assertEquals(PostErrorMessages.INVALID_POST_TITLE_NULL, e.getMessage());
		}
	}

	// Test case for validating invalid post title format
	@Test
	void testValidateTitle_InvalidTitleFormat_ThrowsIllegalArgumentException() throws PostValueInvalidException {
		try {
			// Create a Post object with an invalid title format
			Post invalidPost = new Post();
			invalidPost.setTitle("Invalid%Title");

			// Validate the invalid title, expect an exception to be thrown
			PostValidations.validateTitle(invalidPost.getTitle());

			// If no exception is thrown, the test fails
			Assertions.fail("Expected IllegalArgumentException was not thrown.");
		} catch (PostValueInvalidException e) {
			// Check if the correct error message is provided
			Assertions.assertEquals(PostErrorMessages.INVALID_POST_TITLE_NULL, e.getMessage());
		}
	}

	// Test case for validating null post description
	@Test
	void testValidateDescription_NullDescription_ThrowsIllegalArgumentException() throws PostValueInvalidException {
		try {
			// Create a Post object with a null description
			Post invalidPost = new Post();
			invalidPost.setDescription(null);

			// Validate the null description, expect an exception to be thrown
			PostValidations.validateDescription(invalidPost.getDescription());

			// If no exception is thrown, the test fails
			Assertions.fail("Expected IllegalArgumentException was not thrown.");
		} catch (PostValueInvalidException e) {
			// Check if the correct error message is provided
			Assertions.assertEquals(PostErrorMessages.INVALID_POST_DESCRIPTION_NULL, e.getMessage());
		}
	}

	// Test case for validating non-null post description
	@Test
	void testValidateDescription_ThrowsIllegalArgumentException() throws PostValueInvalidException {
		// Create a Post object with a valid description
		Post invalidPost = new Post();
		invalidPost.setDescription("Valid Description");

		// Validate the valid description, expect a valid result
		Assertions.assertTrue(PostValidations.validateDescription(invalidPost.getDescription()));
	}

	// Test case for validating non-null post title
	@Test
	void testValidTitle_ThrowsIllegalArgumentException() throws PostValueInvalidException {
		// Create a Post object with a valid title
		Post invalidPost = new Post();
		invalidPost.setTitle("Valid Title");

		// Validate the valid title, expect a valid result
		Assertions.assertTrue(PostValidations.validateTitle(invalidPost.getTitle()));
	}

	// Test case for validating invalid post description length
	@Test
	void testInValidateDescription_ThrowsIllegalArgumentException() throws PostValueInvalidException {
		try {
			// Create a Post object with an invalid description length
			Post invalidPost = new Post();
			invalidPost.setDescription(".....");

			// Validate the invalid description length, expect an exception to be thrown
			PostValidations.validateDescription(invalidPost.getDescription());

			// If no exception is thrown, the test fails
			Assertions.fail("Expected IllegalArgumentException was not thrown.");
		} catch (PostValueInvalidException e) {
			// Check if the correct error message is provided
			Assertions.assertEquals(PostErrorMessages.DESCRIPTION_LENGTH_FORMAT, e.getMessage());
		}
	}

	// Test case for validating a valid post
	@Test
	void testValidatePost_ValidPostt_ReturnsTrue() throws PostValueInvalidException {
		// Create a valid Post object
		Post validPost = new Post(1, 1, "Valid Title", "Valid Description", "https://example.com/image.jpg");

		// Validate the post, expect a valid result
		boolean result = PostValidations.validatePost(validPost);
		Assertions.assertTrue(result);
	}

	// Test case for validating null image URL
	@Test
	void testValidateImageUrl_NullImageUrl() throws PostValueInvalidException {
		try {
			// Create a Post object with a null image URL
			Post invalidPost = new Post();
			invalidPost.setPostUrl(null);

			// Validate the null image URL, expect an exception to be thrown
			PostValidations.validateImageUrl(invalidPost.getPostUrl());

			// If no exception is thrown, the test fails
			Assertions.fail("Expected IllegalArgumentException was not thrown.");
		} catch (PostValueInvalidException e) {
			// Check if the correct error message is provided
			Assertions.assertEquals(PostErrorMessages.INVALID_IMAGE_URL_NULL, e.getMessage());
		}
	}

	// Test case for validating invalid image URL format
	@Test
	void testValidateImageUrl_InvalidImageUrlFormat() throws PostValueInvalidException {
		try {
			// Create a Post object with an invalid image URL format
			Post invalidPost = new Post();
			invalidPost.setPostUrl("invalid-url");

			// Validate the invalid image URL format, expect an exception to be thrown
			PostValidations.validateImageUrl(invalidPost.getPostUrl());

			// If no exception is thrown, the test fails
			Assertions.fail("Expected IllegalArgumentException was not thrown.");
		} catch (PostValueInvalidException e) {
			// Check if the correct error message is provided
			Assertions.assertEquals(PostErrorMessages.INVALID_IMAGE_URL_FORMAT, e.getMessage());
		}
	}

	// Test case for validating a valid input for Service
	@Test
	void testValidateSerivecValid() throws IllegalArgumentException, ServiceValueInvalidException {
		// Create a list of valid services
		List<Services> serviceList = new ArrayList<>();
		Services service1 = new Services(0, ServiceCategory.HAIR_STYLE, "Haircut", 50,
				"https://example.com/haircut.jpg");
		serviceList.add(service1);

		// Validate the list of services, expect a valid result
		Assertions.assertTrue(ArtitsValidator.validateService(serviceList));
	}

	// Test case for validating a valid password
	@Test
	void testValidationOfPasswordValid() {
		// Create an Artist object with a valid password
		Artist artist = new Artist();
		artist.setPassword("StrongPass123");

		// Validate the password, expect a valid result
		Assertions.assertTrue(ArtitsValidator.validatePassword(artist.getPassword()));
	}

	// Test case for validating null password
	@Test
	void testValidationOfPasswordNullValid() {
		// Create an Artist object with a null password
		Artist artist = new Artist();
		artist.setPassword(null);

		try {
			// Validate the null password, expect an exception to be thrown
			ArtitsValidator.validatePassword(artist.getPassword());

			// If no exception is thrown, the test fails
			Assertions.fail("The testcase failed for Password validations");
		} catch (IllegalArgumentException ex) {
			// Check if the correct error message is provided
			Assertions.assertEquals(ErrorMessages.PASSWORD_NULL, ex.getMessage());
		}
	}

	// Test case for validating invalid password
	@Test
	void testValidationOfPasswordInValid() {
		// Create an Artist object with an invalid password
		Artist artist = new Artist();
		artist.setPassword("madhu");

		try {
			// Validate the invalid password, expect an exception to be thrown
			ArtitsValidator.validatePassword(artist.getPassword());

			// If no exception is thrown, the test fails
			Assertions.fail("The testcase failed for Password validations");
		} catch (IllegalArgumentException ex) {
			// Check if the correct error message is provided
			Assertions.assertEquals(ErrorMessages.INVALID_PASSWORD_PATTERN, ex.getMessage());
		}
	}

	// Test case for validating a valid location
	@Test
	void testValidationOfLocationValid() {
		// Create an Artist object with a valid location
		Artist artist = new Artist();
		artist.setLocation("chennai");

		// Validate the location, expect a valid result
		Assertions.assertTrue(ArtitsValidator.validateLocation(artist.getLocation()));
	}

//InvalidTestcase for validate Location

	// Test case for validating null location
	@Test
	void testValidationOfLoctionNull() {
		Artist artist = new Artist();
		artist.setLocation(null);

		try {
			// Validate the null location, expect an exception to be thrown
			ArtitsValidator.validateLocation(artist.getLocation());
		} catch (IllegalArgumentException ex) {
			// Check if the correct error message is provided
			Assertions.assertEquals(ErrorMessages.INVALID_LOCATION_NULL, ex.getMessage());
		}
	}

	// Test case for validating invalid location
	@Test
	void testValidationOfLoctionInValid() {
		try {
			// Create an Artist object with an invalid location
			Artist artist = new Artist();
			artist.setLocation("Madhurai");

			// Validate the invalid location, expect an exception to be thrown
			ArtitsValidator.validateLocation(artist.getLocation());

			// If no exception is thrown, the test fails
			Assertions.fail("The testcase failed for Location validations");
		} catch (IllegalArgumentException ex) {
			// Check if the correct error message is provided
			Assertions.assertEquals(ErrorMessages.INVALID_LOCATION, ex.getMessage());
		}
	}

	// Test case for validating null languages spoken
	@Test
	void testValidationOfLanguagesSpoken() {
		Artist artist = new Artist();
		artist.setLanguagesSpoken(null);

		try {
			// Validate the null languages spoken, expect an exception to be thrown
			ArtitsValidator.validateLanguagesSpoken(artist.getLanguagesSpoken());

			// If no exception is thrown, the test fails
			Assertions.fail("Expected error message was not encountered. Test case failed");
		} catch (IllegalArgumentException ex) {
			// Check if the correct error message is provided
			Assertions.assertEquals(ErrorMessages.INVALID_LANGUAGE, ex.getMessage());
		}
	}

	// Test case for validating valid languages spoken
	@Test
	void ValidationOflanguageValid() {
		String language = "Tamil";
		// Create an Artist object with a valid language
		Artist artist = new Artist();
		artist.setLanguagesSpoken(language);

		// Validate the language, expect a valid result
		Assertions.assertTrue(ArtitsValidator.validateLanguagesSpoken(artist.getLanguagesSpoken()));
	}

	// Test case for validating valid social media links
	@Test
	void testValidSocialMediaLinks() {
		Artist artist = new Artist();
		// Create a list of valid social media links
		List<String> validLinks = Arrays.asList("https://www.example.com", "http://www.example.com",
				"https://twitter.com/user123", "http://facebook.com/page456");
		artist.setSocialMediaLinks(validLinks);

		// Validate the social media links, expect a valid result
		Assertions.assertTrue((ArtitsValidator.validateSocialMediaLinks(artist.getSocialMediaLinks())));
	}

	// Test case for validating an empty list of social media links
	@Test
	void testEmptyList() {
		List<String> emptyList = new ArrayList<String>();
		try {
			// Validate an empty list of social media links, expect an exception to be
			// thrown
			ArtitsValidator.validateSocialMediaLinks(emptyList);
			Assertions.fail("Expected IllegalArgumentException was not thrown.");
		} catch (IllegalArgumentException e) {
			// Check if the correct error message is provided
			Assertions.assertEquals("Social media links cannot be empty or null.", e.getMessage());
		}
	}

	// Test case for validating a null list of social media links
	@Test
	void testNullList() {
		try {
			Artist artist = new Artist();
			artist.setSocialMediaLinks(null);
			// Validate a null list of social media links, expect an exception to be thrown
			ArtitsValidator.validateSocialMediaLinks(artist.getSocialMediaLinks());
			Assertions.fail("Expected IllegalArgumentException was not thrown.");
		} catch (IllegalArgumentException e) {
			// Check if the correct error message is provided
			Assertions.assertEquals("Social media links cannot be empty or null.", e.getMessage());
		}
	}

	// Test case for validating invalid social media links
	@Test
	void testInvalidLink() {
		List<String> invalidLinks = Arrays.asList("www.example.com", "ftp://example.com", "https:/twitter.com/user123",
				"http://facebook .com/page456");

		try {
			// Validate invalid social media links, expect an exception to be thrown
			ArtitsValidator.validateSocialMediaLinks(invalidLinks);
		} catch (IllegalArgumentException e) {
			// Check if the correct error message is provided
			Assertions.assertEquals("Invalid social media link: www.example.com", e.getMessage());
		}
	}

	// Test case for validating valid schedules
	@Test
	void testValidateSchedule() {
		List<Schedule> scheduleList = new ArrayList<>();

		// Create valid schedules
		Schedule schedule1 = new Schedule(1, "Event", LocalDate.now(), LocalDateTime.now());

		scheduleList.add(schedule1);

		boolean result = false;
		try {
			// Validate the list of schedules, expect a valid result
			result = ArtitsValidator.validateschedule(scheduleList);
		} catch (Exception e) {
			// If an exception is thrown, the test fails
			Assertions.fail("Exception thrown: " + e.getMessage());
		}

		// Check if the result is true
		Assertions.assertTrue(result);
	}

	// Test case for validating a schedule with null event name
	@Test
	void testValidateScheduleNullEventName() throws ScheduleValueInvalidException {
		try {
			Schedule invalidSchedule = new Schedule();
			
			invalidSchedule.setEventName(null);
			
			// Validate the schedule with null event name, expect an exception to be thrown
			ScheduleValidations.validateName(invalidSchedule.getEventName());

			Assertions.fail("Expected IllegalArgumentException was not thrown.");
		} catch (ScheduleValueInvalidException e) {
			e.printStackTrace();
			// Check if the correct error message is provided
			Assertions.assertEquals(ScheduleErrorMessages.INVALID_EVENT_NAME_NULL, e.getMessage());
		}
	}

	// Test case for validating a schedule with a past date
	@Test
	void testValidateSchedulePastDate() throws ScheduleValueInvalidException {
		try {
			Schedule invalidSchedule = new Schedule( );
			invalidSchedule.setDate(LocalDate.of(2021, 1, 1));
			invalidSchedule.setArtistId(3);

			// Validate the schedule with a past date, expect an exception to be thrown
			ScheduleValidations.validateDate(invalidSchedule.getDate());

			Assertions.fail("Expected IllegalArgumentException was not thrown.");
		} catch (ScheduleValueInvalidException e) {
			// Check if the correct error message is provided
			Assertions.assertEquals(ScheduleErrorMessages.INVALID_DATE_EVENT_PASSED, e.getMessage());
		}
	}

	// Test case for validating a schedule with null time of event
	@Test
	void testValidateScheduleNullTimeOfEvent() throws ScheduleValueInvalidException {
		try {
			Schedule invalidSchedule = new Schedule();
			invalidSchedule.setTimeOfEvent(null);
			invalidSchedule.setArtistId(3);

			// Validate the schedule with null time of event, expect an exception to be
			// thrown
			ScheduleValidations.validateTimeOfEvent(invalidSchedule.getTimeOfEvent());

			Assertions.fail("Expected IllegalArgumentException was not thrown.");
		} catch (ScheduleValueInvalidException e) {
			Assertions.assertEquals(ScheduleErrorMessages.INVALID_TIME_OF_EVENT_NULL, e.getMessage());
		}
	}

	// Test case for validating a schedule with null date
	@Test
	void testValidateScheduleNullDate() throws ScheduleValueInvalidException {
		try {
			Schedule invalidSchedule = new Schedule();
			invalidSchedule.setDate(null);
			invalidSchedule.setArtistId(3);

			// Validate the schedule with null date, expect an exception to be thrown
			ScheduleValidations.validateDate(invalidSchedule.getDate());

			Assertions.fail("Expected IllegalArgumentException was not thrown.");
		} catch (ScheduleValueInvalidException e) {
			// Check if the correct error message is provided
			Assertions.assertEquals(ScheduleErrorMessages.INVALID_DATE_NULL, e.getMessage());
		}
		
	}

	// Test case for validating a valid gender
	@Test
	void testValidateGender_Valid() {
		try {
			// Create an artist instance with a valid gender
			Artist artist = new Artist();
			artist.setGenderOfArtist(gender.FEMALE);

			// Validate the gender, expect no exception to be thrown
			ArtitsValidator.validateGender(artist.getGenderOfArtist());
		} catch (IllegalArgumentException ex) {
			// If an exception is unexpectedly thrown, the test fails
			Assertions.fail("Unexpected IllegalArgumentException thrown: " + ex.getMessage());
		}
	}

	@Test
	void testValidateGender_NullGender() {
		try {
			// Create an artist instance without setting the gender
			Artist artist = new Artist();

			// Validate the gender, expect an exception to be thrown
			ArtitsValidator.validateGender(artist.getGenderOfArtist());

			// If the exception is not thrown, the test fails
			Assertions.fail("Expected IllegalArgumentException was not thrown");
		} catch (IllegalArgumentException ex) {
			// Check if the correct error message is provided
			Assertions.assertEquals("Gender of artist is required", ex.getMessage());
		}
	}

	@Test
	void testValidateArtist_NullArtist_ThrowsIllegalArgumentException()
			throws PostValueInvalidException, ServiceValueInvalidException {
		try {
			// Validate a null artist object, expect an exception to be thrown
			ArtitsValidator.validateArtist(null);

			// If the exception is not thrown, the test fails
			fail("Expected IllegalArgumentException was not thrown.");
		} catch (IllegalArgumentException e) {
			// Check if the correct error message is provided
			assertEquals("Artist object is null", e.getMessage());
		}
	}

	@Test
	void testValidateGender_NullGender_ThrowsIllegalArgumentException() {
	    Artist artist = new Artist();
	    artist.setGenderOfArtist(null);
	    
	    try {
	        ArtitsValidator.validateGender(artist.getGenderOfArtist());
	        fail("Expected IllegalArgumentException was not thrown.");
	    } catch (IllegalArgumentException e) {
	        assertEquals("Gender of artist is required", e.getMessage());
	    }
	}

	@Test
	void testValidateService_ValidServices_ReturnsTrue() throws ServiceValueInvalidException {
		// Create a list of valid services
		List<Services> services = new ArrayList<>();
		Services validService = new Services(1, ServiceCategory.MEHANDI, "Service", 122,
				"https://example.com/new_artwork.jpg");
		services.add(validService);

		// Validate the list of services, expect a valid result
		boolean result = ArtitsValidator.validateService(services);

		// Assert that the result is true
		Assertions.assertTrue(result);
	}

	@Test
	void testValidateService_EmptyServiceList_ReturnsTrue() throws ServiceValueInvalidException {
		// Create an empty list of services
		List<Services> emptyServices = new ArrayList<>();

		// Validate the empty list of services, expect a valid result
		boolean result = ArtitsValidator.validateService(emptyServices);

		// Assert that the result is true
		Assertions.assertTrue(result);
	}

	// Test cases for validateSocialMediaLinks
	@Test
	void testValidateSocialMediaLinks_ValidLinks_ReturnsTrue() {
		// Create a list of valid social media links
		List<String> validLinks = Arrays.asList("https://www.example.com", "http://www.example.com");

		// Validate the list of social media links, expect a valid result
		boolean result = ArtitsValidator.validateSocialMediaLinks(validLinks);

		// Assert that the result is true
		Assertions.assertTrue(result);
	}

	// Test cases for validateLocation
	@Test
	void testValidateLocation_ValidLocation_ReturnsTrue() {
		// Set a valid location
		String validLocation = "chennai";

		// Validate the location, expect a valid result
		boolean result = ArtitsValidator.validateLocation(validLocation);

		// Assert that the result is true
		Assertions.assertTrue(result);
	}

	@Test
	void testValidateLocation_InvalidLocation_ThrowsIllegalArgumentException() {
		// Set an invalid location
		String invalidLocation = "Madhurai";

		try {
			// Validate the invalid location, expect an exception to be thrown
			ArtitsValidator.validateLocation(invalidLocation);

			// If the exception is not thrown, the test fails
			Assertions.fail("Expected IllegalArgumentException was not thrown.");
		} catch (IllegalArgumentException e) {
			// Check if the correct error message is provided
			Assertions.assertEquals(ErrorMessages.INVALID_LOCATION, e.getMessage());
		}
	}

}
