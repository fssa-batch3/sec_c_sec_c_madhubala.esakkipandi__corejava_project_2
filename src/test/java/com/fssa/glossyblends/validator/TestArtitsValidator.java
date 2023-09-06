package com.fssa.glossyblends.validator;

import static org.junit.jupiter.api.Assertions.assertEquals;

import static org.junit.jupiter.api.Assertions.fail;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.fssa.glossyblends.customexception.ArtistDetailsExceptions;
import com.fssa.glossyblends.customexception.PostValueInvalidException;
import com.fssa.glossyblends.customexception.ScheduleValueInvalidException;
import com.fssa.glossyblends.customexception.ServiceValueInvalidException;
import com.fssa.glossyblends.model.Artist;
import com.fssa.glossyblends.model.Artist.gender;
import com.fssa.glossyblends.model.*;
import com.fssa.glossyblends.errormessages.ArtistErrors;
import com.fssa.glossyblends.errormessages.ScheduleErrors;
import com.fssa.glossyblends.errormessages.ServiceErrors;
import com.fssa.glossyblends.errormessages.PostErrors;

import com.fssa.glossyblends.model.Post;
import com.fssa.glossyblends.model.ServiceCategory;
import com.fssa.glossyblends.model.Schedule;

/**
 * Test class for validating Artist objects using JUnit tests.
 */

class TestArtitsValidator {

//validTestcase for username
	@Test
	void testValidationOfUserNameValid() throws ArtistDetailsExceptions {
		// Create an Artist object
		Artist artist = new Artist();

		// Set a valid username
		String name = "Madhubala";
		artist.setUsername(name);

		// Validate the username using ArtitsValidator class and assert the result
		Assertions.assertTrue(ArtitsValidator.validateUsername(artist.getUsername()));
	}

	@Test
	void testValidationEmailValid() throws ArtistDetailsExceptions {
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
		} catch (ArtistDetailsExceptions ex) {
			// Assert that the correct error message is returned in the exception
			Assertions.assertEquals(ArtistErrors.INVALID_EMAIL_NULL, ex.getMessage());
		}
	}

	@Test
	void testValidationEmailInValid() throws ArtistDetailsExceptions {
		// Create an Artist object
		Artist ar = new Artist();

		// Set an invalid email address format
		ar.setEmail("Madhugamil.com");

		try {
			// Attempt to validate the email (should throw an exception)
			ArtitsValidator.validateEmail(ar.getEmail());
			// If no exception is thrown, fail the test with an error message
			Assertions.fail("It should throw an exception");
		} catch (ArtistDetailsExceptions ex) {
			// Assert that the correct error message is returned in the exception
			Assertions.assertEquals(ArtistErrors.INVALID_EMAIL_FORMAT, ex.getMessage());
		}
	}

	@Test
	void testValidateArtist_ValidArtist_ReturnsTrue() throws ArtistDetailsExceptions {
		// Create an Artist object
		Artist artist = new Artist();
		// Set valid properties for the artist
		artist.setUsername("TestArtist");
		artist.setPassword("TestPassword123");
		artist.setEmail("test@example.com");
		artist.setPhonenNumber(1234567880);
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
	void testValidateArtistWithNull() throws ArtistDetailsExceptions {
		try {
			Artist artist = null;
			ArtitsValidator.validateArtist(artist);
			Assertions.fail("Expected IllegalArgumentException was not thrown");
		} catch (ArtistDetailsExceptions ex) {
			// Assert that the correct error message is returned in the exception
			Assertions.assertEquals("Artist object is null", ex.getMessage());
		}
	}

	@Test
	void testValidateArtist_InvalidUsername_ThrowsIllegalArgumentException() throws ArtistDetailsExceptions {
		try {
			Artist artist = new Artist();
			artist.setUsername(null); // Invalid username

			// Attempt to validate the invalid username (should throw an exception)
			ArtitsValidator.validateUsername(artist.getUsername());
			Assertions.fail("IllegalArgumentException should be thrown for invalid username.");
		} catch (ArtistDetailsExceptions e) {
			// Assert that the correct error message is returned in the exception
			Assertions.assertEquals(ArtistErrors.INVALID_USERNAME_NULL, e.getMessage());

		}
	}

	@Test
	void validUsername() throws ArtistDetailsExceptions {
		Artist artist = new Artist();
		artist.setUsername("Madhubala"); // Valid username

		// Validate the valid username using ArtitsValidator class and assert the result
		boolean val = ArtitsValidator.validateUsername(artist.getUsername());

		Assertions.assertTrue(val);
	}

	@Test
	void testValidateArtist_InvalidPassword_ThrowsIllegalArgumentException() {
		try {
			Artist artist = new Artist();

			artist.setPassword(null); // Invalid password

			// Attempt to validate the invalid password (should throw an exception)
			ArtitsValidator.validatePassword(artist.getPassword());
			Assertions.fail("IllegalArgumentException should be thrown for invalid password.");
		} catch (ArtistDetailsExceptions e) {
			// Assert that the correct error message is returned in the exception
			Assertions.assertEquals(ArtistErrors.PASSWORD_NULL, e.getMessage());
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

		} catch (ArtistDetailsExceptions ex) {
			// Assert that the correct error message is returned in the exception
			Assertions.assertEquals(ServiceErrors.INVALID_SERVICE_NAME_PATTERN, ex.getMessage());
		}
	}

	@Test
	// Valid testcases for years of experience
	void testValidateYearsOfExperienceValid() throws ArtistDetailsExceptions {
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

		} catch (ArtistDetailsExceptions e) {
			// Assert that the correct error message is returned in the exception
			Assertions.assertEquals(ArtistErrors.INVALID_YEARS_OF_EXPERIENCE_NEGATIVE, e.getMessage());
		}
	}

	// Test case for valid phone number
	@Test
	void testValidatePhoneNumberValid() throws ArtistDetailsExceptions {
		// Create an Artist object with a valid phone number
		Artist artist = new Artist();
		long num = 936672105;
		artist.setPhonenNumber(num);
		// Validate the phone number, expect a valid result
		Assertions.assertTrue(ArtitsValidator.validatePhoneNumber(artist.getPhonenNumber()));
	}

	// Test case for invalid phone number format
	@Test
	void testValidatePhoneNumberInValid() throws ArtistDetailsExceptions {
		try {
			// Create an Artist object with an invalid phone number
			Artist artist = new Artist();
			artist.setPhonenNumber(1);

			// Validate the invalid phone number, expect an exception to be thrown
			ArtitsValidator.validatePhoneNumber(artist.getPhonenNumber());

			// If no exception is thrown, the test fails
			Assertions.fail("Expected exception was not thrown.");
		} catch (ArtistDetailsExceptions e) {
			// Check if the correct error message is provided
			Assertions.assertEquals(ArtistErrors.INVALID_PHONE_NUMBER_FORMAT, e.getMessage());
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
			Assertions.assertEquals(PostErrors.INVALID_POST_TITLE_NULL, e.getMessage());
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
			Assertions.assertEquals(PostErrors.INVALID_POST_TITLE_NULL, e.getMessage());
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
			Assertions.assertEquals(PostErrors.INVALID_POST_DESCRIPTION_NULL, e.getMessage());
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
			Assertions.assertEquals(PostErrors.DESCRIPTION_LENGTH_FORMAT, e.getMessage());
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
			Assertions.assertEquals(PostErrors.INVALID_IMAGE_URL_NULL, e.getMessage());
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
			Assertions.assertEquals(PostErrors.INVALID_IMAGE_URL_FORMAT, e.getMessage());
		}
	}

	// Test case for validating a valid input for Service
	@Test
	void testValidateSerivecValid() throws IllegalArgumentException, ServiceValueInvalidException {
		// Create a list of valid services
		List<Service> serviceList = new ArrayList<>();
		Service service1 = new Service(0, ServiceCategory.HAIR_STYLE, "Haircut", 50, "https://example.com/haircut.jpg");
		serviceList.add(service1);

		// Validate the list of services, expect a valid result
		Assertions.assertTrue(ArtitsValidator.validateService(serviceList));
	}

	// Test case for validating a valid password
	@Test
	void testValidationOfPasswordValid() throws ArtistDetailsExceptions {
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
		} catch (ArtistDetailsExceptions ex) {
			// Check if the correct error message is provided
			Assertions.assertEquals(ArtistErrors.PASSWORD_NULL, ex.getMessage());
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
		} catch (ArtistDetailsExceptions ex) {
			// Check if the correct error message is provided
			Assertions.assertEquals(ArtistErrors.INVALID_PASSWORD_PATTERN, ex.getMessage());
		}
	}

	// Test case for validating a valid location
	@Test
	void testValidationOfLocationValid() throws ArtistDetailsExceptions {
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
		} catch (ArtistDetailsExceptions ex) {
			// Check if the correct error message is provided
			Assertions.assertEquals(ArtistErrors.INVALID_LOCATION_NULL, ex.getMessage());
		}
	}

	// Test case for validating invalid location
	@Test
	void testValidationOfLoctionInValid() {
		Artist artist = new Artist();
		artist.setLocation("Madhurai");
		try {
			// Create an Artist object with an invalid location

			// Validate the invalid location, expect an exception to be thrown
			ArtitsValidator.validateLocation(artist.getLocation());

			// If no exception is thrown, the test fails
			Assertions.fail("The testcase failed for Location validations");
		} catch (ArtistDetailsExceptions ex) {
			// Check if the correct error message is provided
			Assertions.assertEquals(ArtistErrors.INVALID_LOCATION, ex.getMessage());
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
		} catch (ArtistDetailsExceptions ex) {
			// Check if the correct error message is provided
			Assertions.assertEquals(ArtistErrors.INVALID_LANGUAGE, ex.getMessage());
		}
	}

	// Test case for validating valid languages spoken
	@Test
	void ValidationOflanguageValid() throws ArtistDetailsExceptions {
		String language = "Tamil";
		// Create an Artist object with a valid language
		Artist artist = new Artist();
		artist.setLanguagesSpoken(language);

		// Validate the language, expect a valid result
		Assertions.assertTrue(ArtitsValidator.validateLanguagesSpoken(artist.getLanguagesSpoken()));
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
	void testValidateScheduleNullEventName() throws ScheduleValueInvalidException, ArtistDetailsExceptions {
		try {
			Schedule invalidSchedule = new Schedule();

			invalidSchedule.setEventName(null);

			// Validate the schedule with null event name, expect an exception to be thrown
			ScheduleValidations.validateName(invalidSchedule.getEventName());

			Assertions.fail("Expected IllegalArgumentException was not thrown.");
		} catch (ScheduleValueInvalidException e) {
			e.printStackTrace();
			// Check if the correct error message is provided
			Assertions.assertEquals(ScheduleErrors.INVALID_EVENT_NAME_NULL, e.getMessage());
		}
	}

	// Test case for validating a schedule with a past date
	@Test
	void testValidateSchedulePastDate() throws ScheduleValueInvalidException {
		try {
			Schedule invalidSchedule = new Schedule();
			invalidSchedule.setDate(LocalDate.of(2021, 1, 1));
			invalidSchedule.setArtistId(3);

			// Validate the schedule with a past date, expect an exception to be thrown
			ScheduleValidations.validateDate(invalidSchedule.getDate());

			Assertions.fail("Expected IllegalArgumentException was not thrown.");
		} catch (ScheduleValueInvalidException e) {
			// Check if the correct error message is provided
			Assertions.assertEquals(ScheduleErrors.INVALID_DATE_EVENT_PASSED, e.getMessage());
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
			Assertions.assertEquals(ScheduleErrors.INVALID_TIME_OF_EVENT_NULL, e.getMessage());
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
			Assertions.assertEquals(ScheduleErrors.INVALID_DATE_NULL, e.getMessage());
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
		} catch (ArtistDetailsExceptions ex) {
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
		} catch (ArtistDetailsExceptions ex) {
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
		} catch (ArtistDetailsExceptions e) {
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
		} catch (ArtistDetailsExceptions e) {
			assertEquals("Gender of artist is required", e.getMessage());
			return;
		}
		fail("Expected IllegalArgumentException was not thrown.");
	}

	
	@Test
	void testValidateService_ValidServices_ReturnsTrue() throws ServiceValueInvalidException {
		// Create a list of valid services
		List<Service> services = new ArrayList<>();
		Service validService = new Service(1, ServiceCategory.MEHANDI, "Service", 122,
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
		List<Service> emptyServices = new ArrayList<>();

		// Validate the empty list of services, expect a valid result
		boolean result = ArtitsValidator.validateService(emptyServices);

		// Assert that the result is true
		Assertions.assertTrue(result);
	}

	// Test cases for validateLocation
	@Test
	void testValidateLocation_ValidLocation_ReturnsTrue() throws ArtistDetailsExceptions {
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
		} catch (ArtistDetailsExceptions e) {

			// Check if the correct error message is provided
			Assertions.assertEquals(ArtistErrors.INVALID_LOCATION, e.getMessage());
		}

	}

}
