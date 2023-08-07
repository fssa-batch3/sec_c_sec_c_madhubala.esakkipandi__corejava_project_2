package com.fssa.glossyblends.Validator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
//import static org.junit.jupiter.api.Assertions.*;

import com.fssa.glossyblends.CustomException.PostValueInvalidException;
import com.fssa.glossyblends.CustomException.ServiceValueInvalidException;
import com.fssa.glossyblends.model.Artist.Artist;
import com.fssa.glossyblends.model.Artist.Artist.gender;
import com.fssa.glossyblends.model.Artist.ErrorMessages;
import com.fssa.glossyblends.model.Artist.Post;
import com.fssa.glossyblends.model.Artist.schedule;

import com.fssa.glossyblends.model.Artist.ServiceCategory;
import com.fssa.glossyblends.model.Artist.Services;

import java.time.LocalDate;
import java.time.LocalDateTime;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
//import static org.junit.Assert.*;

public class TestArtitsValidator {

//validTestcase for username
	@Test
	public void testValidationOfUserNameValid() {

		Artist artist = new Artist();

		String name = "Madhubala";
		artist.setUsername(name);

		Assertions.assertTrue(ArtitsValidator.validateUsername(artist.getUsername()));

	}

	@Test
	public void testValidationEmailValid() {

		Artist ar = new Artist();

		ar.setEmail("Madhu@gamil.com");

		Assertions.assertTrue(ArtitsValidator.validateEmail(ar.getEmail()));
	}

	@Test
	public void testValidationNullEmailValid() {

		Artist ar = new Artist();

		ar.setEmail(null);

		try {

			Assertions.assertTrue(ArtitsValidator.validateEmail(ar.getEmail()));
			Assertions.fail("It should throw exception");
		} catch (IllegalArgumentException ex) {

			Assertions.assertEquals(ErrorMessages.INVALID_EMAIL_NULL, ex.getMessage());
		}
	}

	@Test
	public void testValidationEmailInValid() {

		Artist ar = new Artist();

		ar.setEmail("Madhugamil.com");

		try {

			Assertions.assertTrue(ArtitsValidator.validateEmail(ar.getEmail()));
			Assertions.fail("It should throw exception");
		} catch (IllegalArgumentException ex) {

			Assertions.assertEquals(ErrorMessages.INVALID_EMAIL_FORMAT, ex.getMessage());
		}
	}

	@Test
	public void testValidateArtist_ValidArtist_ReturnsTrue()
			throws IllegalArgumentException, PostValueInvalidException, ServiceValueInvalidException {

		Artist artist = new Artist();
		artist.setUsername("TestArtist");
		artist.setPassword("TestPassword123");
		artist.setEmail("test@example.com");
		artist.setPhone_number("1234567890");
		artist.setYearsOfExperience(5);
		artist.setAvailable(true);
		artist.setLanguagesSpoken("English");
		artist.setLocation("chennai");
		artist.setGenderOfArtist(gender.FEMALE);

//
//		List<Services> services = new ArrayList<>();
//		services.add(new Services(1, ServiceCategory.MEHANDI, "Service", 122, "https://example.com/new_artwork.jpg"));
//		artist.setProvidingServices(services);
//
//		List<Post> posts = new ArrayList<>();
//		posts.add(new Post("Post1", 1, "aserA", "asdfghjS", "https://example.com/new_artwork.jpg"));
//		artist.setWorkLink(posts);
//		
//		
//		List<schedule> schedules = new ArrayList<>();
//		schedules.add(new schedule( 1,"EventName", LocalDate.of(2023, 8, 3), LocalDateTime.of(2023, 8, 3, 10, 0)));
//		schedules.add(new schedule(1,"EventName", LocalDate.of(2023, 8, 4), LocalDateTime.of(2023, 8, 4, 15, 30)));
		// Add more schedules if needed

//		artist.setWorkingDaysCalender(schedules); // Use setWorkingDaysCalender to set the schedules

		boolean result = ArtitsValidator.validateArtist(artist);

		Assertions.assertTrue(result);

	}

	@Test
	public void testValidateArtistWithNull()
			throws IllegalArgumentException, ServiceValueInvalidException, PostValueInvalidException {
		try {
			Artist artist = null;
			ArtitsValidator.validateArtist(artist);
			Assertions.fail("Expected IllegalArgumentException was not thrown");
		} catch (IllegalArgumentException ex) {
			Assertions.assertEquals("Artist object is null", ex.getMessage());
		}
	}

	@Test
	public void testValidateArtist_InvalidUsername_ThrowsIllegalArgumentException()
			throws PostValueInvalidException, ServiceValueInvalidException {
		try {
			Artist artist = new Artist();
			artist.setUsername(null); // Invalid username

			ArtitsValidator.validateUsername(artist.getUsername());
			Assertions.fail("IllegalArgumentException should be thrown for invalid username.");
		} catch (IllegalArgumentException e) {
			Assertions.assertEquals(ErrorMessages.INVALID_USERNAME_NULL, e.getMessage());

		}
	}

	@Test
	public void validUsername() throws IllegalArgumentException {

		Artist artist = new Artist();
		artist.setUsername("Madhubala"); // Invalid username

		boolean val = ArtitsValidator.validateUsername(artist.getUsername());

		Assertions.assertTrue(val);
	}

	@Test
	public void testValidateArtist_InvalidPassword_ThrowsIllegalArgumentException()
			throws PostValueInvalidException, ServiceValueInvalidException {
		try {
			Artist artist = new Artist();

			artist.setPassword(null); // Invalid password

			ArtitsValidator.validatePassword(artist.getPassword());
			Assertions.fail("IllegalArgumentException should be thrown for invalid password.");
		} catch (IllegalArgumentException e) {
			Assertions.assertEquals(ErrorMessages.PASSWORD_NULL, e.getMessage());
		}
	}

	// InvalidTestcase for username

	@Test
	public void testValidationOfUserNameInValid() {

		try {
			Artist artist = new Artist();

			artist.setUsername(".23456789");

			ArtitsValidator.validateUsername(artist.getUsername());
			Assertions.fail("The testcase failed for name validations");

		} catch (IllegalArgumentException ex) {

			Assertions.assertEquals(ErrorMessages.INVALID_SERVICE_NAME_PATTERN, ex.getMessage());
		}

	}

	@Test

	// Valid testcases year of experience
	public void testValidateYearsOfExperienceValid() {

		Artist artist = new Artist();

		int yearsOfExperience = 5;

		artist.setYearsOfExperience(yearsOfExperience);
		Assertions.assertTrue(ArtitsValidator.validateYearsOfExperience(artist.getYearsOfExperience()));
	}

	// Invalid yearsOfExperience (less than or equal to 0) should throw an
	// IllegalArgumentException
//Invalid input testcases 
	@Test
	public void testValidateYearsOfExperienceInvalid() {
		int yearsOfExperience = -2;

		Artist artist = new Artist();

		artist.setYearsOfExperience(yearsOfExperience);

		try {

			ArtitsValidator.validateYearsOfExperience(artist.getYearsOfExperience());
			Assertions.fail("expected exception was not thrown.");

		} catch (IllegalArgumentException e) {
			Assertions.assertEquals(ErrorMessages.INVALID_YEARS_OF_EXPERIENCE_NEGATIVE, e.getMessage());
		}

	}

	// phone number testcase valid
	@Test
	public void testValidatePhoneNumberValid() {

		Artist artist = new Artist();
		artist.setPhone_number("12345678");

		Assertions.assertTrue(ArtitsValidator.validatePhoneNumber(artist.getPhone_number()));
	}

	@Test
	public void testValidatePhoneNumberInValid() {

		try {

			Artist artist = new Artist();
			artist.setPhone_number("Madh123342");

			ArtitsValidator.validatePhoneNumber(artist.getPhone_number());

			Assertions.fail("expected exception was not thrown.");

		} catch (IllegalArgumentException e) {
			Assertions.assertEquals(ErrorMessages.INVALID_PHONE_NUMBER_FORMAT, e.getMessage());
		}

	}

	// null Mobile number Testcase
	@Test

	public void testValidatePhoneNumberNull() {
		Artist artist = new Artist();
		artist.setPhone_number(null);

		try {
			ArtitsValidator.validatePhoneNumber(artist.getPhone_number());
			Assertions.fail("expected exception was not thrown.");

		} catch (IllegalArgumentException e) {
			Assertions.assertEquals(ErrorMessages.INVALID_PHONE_NUMBER_NULL, e.getMessage());
		}

	}

	@Test
	public void testValidatePhoneNumberEmpty() {

		Artist artist = new Artist();
		artist.setPhone_number(" ");
		try {
			ArtitsValidator.validatePhoneNumber(artist.getPhone_number());
			Assertions.fail("expected exception was not thrown.");

		} catch (IllegalArgumentException e) {
			Assertions.assertEquals(ErrorMessages.INVALID_PHONE_NUMBER_NULL, e.getMessage());
		}

	}

//teast case for valid input for post

	@Test
	public void testValidatePost_ValidPost_ReturnsTrue() throws PostValueInvalidException {
		Post validPost = new Post(1, 1, "Valid Titl", "Valid Description", "https://example.com/image.jpg");
//	        validPost.setTitle("Valid Title");
//	        validPost.setDescription("Valid Description");
//	        validPost.setPostUrl("https://example.com/image.jpg");
		validPost.setPostId(2);
		validPost.setArtistId(2);

		Assertions.assertTrue(PostValidations.validatePost(validPost));
	}

	@Test
	public void testValidateTitle_NullTitle_ThrowsIllegalArgumentException() throws PostValueInvalidException {
		try {
			Post invalidPost = new Post();
			invalidPost.setTitle(null);
			PostValidations.validateTitle(invalidPost.getTitle());
			Assertions.fail("Expected IllegalArgumentException was not thrown.");
		} catch (PostValueInvalidException e) {
			Assertions.assertEquals(ErrorMessages.INVALID_POST_TITLE_NULL, e.getMessage());
		}
	}

	@Test
	public void testValidateTitle_InvalidTitleFormat_ThrowsIllegalArgumentException() throws PostValueInvalidException {
		try {
			Post invalidPost = new Post();
			invalidPost.setTitle("Invalid#$%Title");
			PostValidations.validateTitle(invalidPost.getTitle());
			Assertions.fail("Expected IllegalArgumentException was not thrown.");
		} catch (PostValueInvalidException e) {
			Assertions.assertEquals(ErrorMessages.INVALID_POST_TITLE_NULL, e.getMessage());
		}
	}

	@Test
	public void testValidateDescription_NullDescription_ThrowsIllegalArgumentException()
			throws PostValueInvalidException {
		try {
			Post invalidPost = new Post();
			invalidPost.setDescription(null);
			PostValidations.validateDescription(invalidPost.getDescription());
			Assertions.fail("Expected IllegalArgumentException was not thrown.");
		} catch (PostValueInvalidException e) {
			Assertions.assertEquals(ErrorMessages.INVALID_POST_DESCRIPTION_NULL, e.getMessage());
		}
	}

	@Test
	public void testValidateDescription_ThrowsIllegalArgumentException() throws PostValueInvalidException {

		Post invalidPost = new Post();
		invalidPost.setDescription("Valid Description");
		PostValidations.validateDescription(invalidPost.getDescription());
		Assertions.assertTrue(PostValidations.validateDescription(invalidPost.getDescription()));

	}

	@Test
	public void testValidTitle_ThrowsIllegalArgumentException() throws PostValueInvalidException {

		Post invalidPost = new Post();
		invalidPost.setTitle("Valid Title");
		Assertions.assertTrue(PostValidations.validateTitle(invalidPost.getTitle()));

	}

	@Test
	public void testInValidateDescription_ThrowsIllegalArgumentException() throws PostValueInvalidException {
		try {
			Post invalidPost = new Post();
			invalidPost.setDescription(".....");
			PostValidations.validateDescription(invalidPost.getDescription());
			Assertions.fail("Expected IllegalArgumentException was not thrown.");
		} catch (PostValueInvalidException e) {
			Assertions.assertEquals(ErrorMessages.DESCRIPTION_LENGTH_FORMAT, e.getMessage());
		}
	}

	@Test
	public void testValidatePost_ValidPostt_ReturnsTrue() throws PostValueInvalidException {
		Post validPost = new Post(1, 1, "Valid Title", "Valid Description", "https://example.com/image.jpg");

		boolean result = PostValidations.validatePost(validPost);

		Assertions.assertTrue(result);
	}

	@Test
	public void testValidateImageUrl_NullImageUrl() throws PostValueInvalidException {
		try {
			Post invalidPost = new Post();
			invalidPost.setPostUrl(null);
			PostValidations.validateImageUrl(invalidPost.getPostUrl());
			Assertions.fail("Expected IllegalArgumentException was not thrown.");
		} catch (PostValueInvalidException e) {
			Assertions.assertEquals(ErrorMessages.INVALID_IMAGE_URL, e.getMessage());
		}
	}

	@Test
	public void testValidateImageUrl_InvalidImageUrlFormat()
			throws PostValueInvalidException {
		try {
			Post invalidPost = new Post();
			invalidPost.setPostUrl("invalid-url");
			PostValidations.validateImageUrl(invalidPost.getPostUrl());
			Assertions.fail("Expected IllegalArgumentException was not thrown.");
		} catch (PostValueInvalidException e) {
			Assertions.assertEquals(ErrorMessages.INVALID_SERVICE_IMAGE_URL_FORMAT_PATTERN, e.getMessage());
		}
	}

//testcase for valid input for Service
//
	@Test
//
	public void testValidateSerivecValid() throws IllegalArgumentException, ServiceValueInvalidException {
		List<Services> ServiceList = new ArrayList<Services>();
		Services Service1 = new Services(0, ServiceCategory.HAIR_STYLE, "Haircut", 50,
				"https://example.com/haircut.jpg");

		ServiceList.add(Service1);
		Assertions.assertTrue(ArtitsValidator.validateService(ServiceList));
	}

//testcase for pasword null

	@Test
	public void testValidationOfPasswordValid() {
		Artist artist = new Artist();
		artist.setPassword("StrongPass123");

		Assertions.assertTrue(ArtitsValidator.validatePassword(artist.getPassword()));

	}

// InvalidTestcase for password

	@Test
	public void testValidationOfPasswordNullValid() {
		Artist artist = new Artist();
		artist.setPassword(null);

		try {
			ArtitsValidator.validatePassword(artist.getPassword());
			Assertions.fail("The testcase failed for Password validations");

		} catch (IllegalArgumentException ex) {

			Assertions.assertEquals(ErrorMessages.PASSWORD_NULL, ex.getMessage());
		}

	}

	@Test
	public void testValidationOfPasswordInValid() {
		Artist artist = new Artist();
		artist.setPassword("madhu");

		try {
			ArtitsValidator.validatePassword(artist.getPassword());
			Assertions.fail("The testcase failed for Password validations");

		} catch (IllegalArgumentException ex) {

			Assertions.assertEquals(ErrorMessages.PASSWORD_INVALID_PATTERN, ex.getMessage());
		}

	}

//testcase for Location null

	@Test
	public void testValidationOfLocationValid() {
		Artist artist = new Artist();
		artist.setLocation("chennai");

		Assertions.assertTrue(ArtitsValidator.validateLocation(artist.getLocation()));

	}

//InvalidTestcase for validate Location

	@Test
	public void testValidationOfLoctionNull() {
		Artist artist = new Artist();
		artist.setLocation(null);

		try {
			ArtitsValidator.validateLocation(artist.getLocation());

		} catch (IllegalArgumentException ex) {

			Assertions.assertEquals(ErrorMessages.INVALID_LOCATION_NULL, ex.getMessage());
		}

	}

	@Test
	public void testValidationOfLoctionInValid() {

		try {
			Artist ar = new Artist();
			ar.setLocation("Madhurai");
			ArtitsValidator.validateLocation(ar.getLocation());
			Assertions.fail("The testcase failed for Password validations");

		} catch (IllegalArgumentException ex) {

			Assertions.assertEquals(ErrorMessages.INVALID_LOCATION, ex.getMessage());
		}

	}

//validations for languages spoken

	@Test
	public void testValidationOfLanguagesSpoken() {
		Artist ar = new Artist();
		ar.setLanguagesSpoken(null);

		try {

			ArtitsValidator.validateLanguagesSpoken(ar.getLanguagesSpoken());

			Assertions.fail("Expected errro mesage was nit occured Test case failed");

		} catch (IllegalArgumentException ex) {

			Assertions.assertEquals(ErrorMessages.INVALID_LANGUAGE_NULL, ex.getMessage());

		}

	}

//valid input for languages

	@Test
	public void ValidationOflanguageValid() {

		String language = "Tamil";
		Artist artist = new Artist();
		artist.setLanguagesSpoken(language);
		Assertions.assertTrue(ArtitsValidator.validateLanguagesSpoken(artist.getLanguagesSpoken()));

	}

//testcase for socaial media link

	@Test
	public void testValidSocialMediaLinks() {

		Artist artist = new Artist();

		List<String> validLinks = Arrays.asList("https://www.example.com", "http://www.example.com",
				"https://twitter.com/user123", "http://facebook.com/page456");
		artist.setSocialMediaLinks(validLinks);

		Assertions.assertTrue((ArtitsValidator.validateSocialMediaLinks(artist.getSocialMediaLinks())));
	}

	@Test
	public void testEmptyList() {
		List<String> emptyList = new ArrayList<String>();
		try {
			ArtitsValidator.validateSocialMediaLinks(emptyList);
			Assertions.fail("Expected IllegalArgumentException was not thrown.");
		} catch (IllegalArgumentException e) {
			Assertions.assertEquals("Social media links cannot be empty or null.", e.getMessage());
		}
	}

	@Test
	public void testNullList() {
		try {

			Artist artist = new Artist();
			artist.setSocialMediaLinks(null);
			ArtitsValidator.validateSocialMediaLinks(artist.getSocialMediaLinks());
			Assertions.fail("Expected IllegalArgumentException was not thrown.");
		} catch (IllegalArgumentException e) {
			Assertions.assertEquals("Social media links cannot be empty or null.", e.getMessage());
		}
	}

	@Test
	public void testInvalidLink() {

		List<String> invalidLinks = Arrays.asList("www.example.com", "ftp://example.com", "https:/twitter.com/user123",
				"http://facebook .com/page456");

		try {
			ArtitsValidator.validateSocialMediaLinks(invalidLinks);
		} catch (IllegalArgumentException e) {
			Assertions.assertEquals("Invalid social media link: www.example.com", e.getMessage());
		}

	}

	@Test
	public void testValidateSchedule() {
		List<schedule> scheduleList = new ArrayList<>();

		// Create valid schedules
		schedule schedule1 = new schedule(1, "Event", LocalDate.now(), LocalDateTime.now());

		scheduleList.add(schedule1);

		boolean result = false;
		try {
			result = ArtitsValidator.validateschedule(scheduleList);
		} catch (Exception e) {
			Assertions.fail("Exception thrown: " + e.getMessage());
		}

		Assertions.assertTrue(result);
	}

	@Test
	public void testValidateScheduleNullEventName() {
		try {
			schedule invalidSchedule = new schedule();
			invalidSchedule.setArtistId(3);
			invalidSchedule.setSchduleId(3);
			invalidSchedule.setEventName(null);
			;
			invalidSchedule.setDate(LocalDate.now());
			;
			invalidSchedule.setTimeOfEvent(LocalDateTime.now());

			ScheduleValidations.validateSchedule(invalidSchedule);

			Assertions.fail("Expected IllegalArgumentException was not thrown.");
		} catch (IllegalArgumentException e) {
			Assertions.assertEquals(ErrorMessages.INVALI_EVENT_NAME_NULL, e.getMessage());
		}
	}

	@Test
	public void testValidateSchedulePastDate() {
		try {
			schedule invalidSchedule = new schedule(1, "EventName", LocalDate.of(2021, 1, 1), LocalDateTime.now());
			invalidSchedule.setArtistId(3);
			ScheduleValidations.validateSchedule(invalidSchedule);

			Assertions.fail("Expected IllegalArgumentException was not thrown.");
		} catch (IllegalArgumentException e) {
			Assertions.assertEquals(ErrorMessages.DATE_EVENT_PASSED, e.getMessage());
		}
	}

	@Test
	public void testValidateScheduleNullTimeOfEvent() {
		try {
			schedule invalidSchedule = new schedule(1, "EventName", LocalDate.now(), null);
			invalidSchedule.setArtistId(3);
			ScheduleValidations.validateSchedule(invalidSchedule);

			Assertions.fail("Expected IllegalArgumentException was not thrown.");
		} catch (IllegalArgumentException e) {
			Assertions.assertEquals(ErrorMessages.TIME_OF_EVENT_NULL, e.getMessage());
		}
	}

	@Test
	public void testValidateScheduleNullDate() {

		try {
			schedule invalidSchedule = new schedule(1, "EventName", null, LocalDateTime.now());
			invalidSchedule.setArtistId(3);
			ScheduleValidations.validateSchedule(invalidSchedule);

			Assertions.fail("Expected IllegalArgumentException was not thrown.");
		} catch (IllegalArgumentException e) {
			Assertions.assertEquals(ErrorMessages.DATE_EVENT_NAME_NULL, e.getMessage());
		}
	}
	
	
	 @Test
	    public void testValidateGender_Valid() {
	        try {
	            Artist artist = new Artist();
	            artist.setGenderOfArtist(gender.FEMALE);

	            ArtitsValidator.validateGender(artist.getGenderOfArtist());
	        } catch (IllegalArgumentException ex) {
	        	Assertions.fail("Unexpected IllegalArgumentException thrown: " + ex.getMessage());
	        }
	    }

	 
	 
	 
	 
	    @Test
	    public void testValidateGender_NullGender() {
	        try {
	            Artist artist = new Artist();

	            ArtitsValidator.validateGender(artist.getGenderOfArtist());
	            Assertions.fail("Expected IllegalArgumentException was not thrown");
	        } catch (IllegalArgumentException ex) {
	        	Assertions.assertEquals("Gender of artist is required", ex.getMessage());
	        }
	    }

}
