package com.fssa.glossyblends.service;

import java.sql.SQLException;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.fssa.glossyblends.artistservicelayer.ArtistService;
import com.fssa.glossyblends.customexception.ArtistDetailsInvalidExceptions;
import com.fssa.glossyblends.customexception.DatabaseConnectionException;
import com.fssa.glossyblends.customexception.PostValueInvalidException;
import com.fssa.glossyblends.customexception.ServiceValueInvalidException;
import com.fssa.glossyblends.dao.ArtistDAO;
import com.fssa.glossyblends.model.Artist;
import com.fssa.glossyblends.model.Artist.gender;
import com.fssa.glossyblends.model.Post;

/**
 * Unit tests for CRUD (Create, Read, Update, Delete) operations on artist.
 */
class TestArtistCrud {

	@Test
	void testAddArtist_ValidInput() throws ArtistDetailsInvalidExceptions, DatabaseConnectionException {
		ArtistService artistservice = new ArtistService();

		Artist artist = new Artist();
		artist.setUsername("jallelaa");
		artist.setPassword("TestPassword123");


		artist.setEmail("MadhubalaS@gmail.com");
		artist.setPhonenNumber("1234567890");
		artist.setYearsOfExperience(5);
		artist.setAvailable(true);
		
		artist.setLanguagesSpoken("English");
		artist.setLocation("chennai");
		artist.setGenderOfArtist(Artist.gender.FEMALE);

		boolean isAdded = artistservice.addArtist(artist);
		Assertions.assertTrue(isAdded);
	}

	@Test
	void UpdateArtistTestService()
			throws SQLException, ArtistDetailsInvalidExceptions, PostValueInvalidException, ServiceValueInvalidException, DatabaseConnectionException {

		ArtistService artistService = new ArtistService();

		int artistId = 9;

		Artist retrievedArtist = ArtistDAO.getArtistById(String.valueOf(artistId));

		if (retrievedArtist != null) {

			retrievedArtist.setYearsOfExperience(3);
			retrievedArtist.setUsername("Jothi");
			retrievedArtist.setAvailable(false);

			boolean isUpdated = artistService.updateArtist(retrievedArtist);

			Assertions.assertTrue(isUpdated);

			Artist updatedArtist = ArtistDAO.getArtistById(String.valueOf(artistId));

			// Assert the updated values
			Assertions.assertEquals("Jothi", updatedArtist.getUsername());
			Assertions.assertEquals("joo123@example.com", updatedArtist.getEmail());
			Assertions.assertEquals("1234567890", updatedArtist.getPhonenNumber());
			Assertions.assertEquals(3, updatedArtist.getYearsOfExperience());
			Assertions.assertEquals(false, updatedArtist.isAvailable());
			Assertions.assertEquals("English", updatedArtist.getLanguagesSpoken());
			Assertions.assertEquals("chennai", updatedArtist.getLocation());
			Assertions.assertEquals(gender.FEMALE, updatedArtist.getGenderOfArtist());
		} else {
			Assertions.fail("Retrieved artist is null.");
		}
	}

	@Test
	void deleteArtistTestCase()
			throws ArtistDetailsInvalidExceptions, PostValueInvalidException, ServiceValueInvalidException, DatabaseConnectionException {

		ArtistService artistservice = new ArtistService();
		int artistIdToDelete = 73;
		Artist artistToDelete = ArtistDAO.getArtistById(String.valueOf(artistIdToDelete));

		if (artistToDelete != null) {
			// Delete the artist
			boolean isDeleted = artistservice.deleteArtist(artistToDelete);
			Assertions.assertTrue(isDeleted);

			
			// Verify that the artist has been deleted
			Artist deletedArtist = ArtistDAO.getArtistById(String.valueOf(artistIdToDelete));
			Assertions.assertNull(deletedArtist, "Deleted artist should not be found.");
		} else {
			Assertions.fail("Artist to delete not found.");
		}
	}

	@Test
	void testGetPostsByArtistId_ValidInput() throws DatabaseConnectionException {
		try {
			ArtistService artistservice = new ArtistService();
			int artistId = 10;

			List<Post> posts = artistservice.getPostByArtistId(artistId);

			Assertions.assertFalse(posts.isEmpty());
			Assertions.assertEquals(1, posts.size());

			for (Post post : posts) {
				System.out.println("Post Title: " + post.getTitle());
			}
		} catch (SQLException e) {
			Assertions.fail("Exception thrown: " + e.getMessage());
		}
	}

	
	@Test
	void testGetPostsByArtistId_InvalidArtistId() throws DatabaseConnectionException {
		try {
			ArtistService artistservice = new ArtistService();
			int invalidArtistId = -1;

			List<Post> posts = artistservice.getPostByArtistId(invalidArtistId);

			Assertions.assertNotNull(posts);
			Assertions.assertTrue(posts.isEmpty());
		} catch (SQLException e) {
			Assertions.fail("Exception thrown: " + e.getMessage());
		}

		
	}
}
