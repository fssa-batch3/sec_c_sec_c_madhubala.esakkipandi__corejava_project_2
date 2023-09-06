package com.fssa.glossyblends.service;

import java.sql.SQLException;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import com.fssa.glossyblends.model.*;
import com.fssa.glossyblends.customexception.ArtistDetailsExceptions;
import com.fssa.glossyblends.customexception.DAOException;
import com.fssa.glossyblends.dao.ArtistDAO;
import com.fssa.glossyblends.errormessages.ArtistErrors;
import com.fssa.glossyblends.model.Artist;
import com.fssa.glossyblends.model.Artist.gender;
import com.fssa.glossyblends.service.ArtistService;
import com.fssa.glossyblends.model.Post;

/**
 * Unit tests for CRUD (Create, Read, Update, Delete) operations on artist.
 */
class TestArtistService {

	/**
	 * Test adding a valid artist to the database.
	 * 
	 * @throws ArtistDetailsExceptions if there's an issue with artist details.
	 * @throws DAOException            if there's an issue with the DAO operations.
	 * @throws SQLException            if there's an issue with SQL operations.
	 */

	@Test
	void testAddArtist_ValidInput() {
		ArtistService artistservice = new ArtistService();
		try {
			Artist artist = new Artist();
			artist.setUsername("Kalai");
			artist.setPassword("Kalai123");
			artist.setEmail("Kalai@gmail.com");
			artist.setPhonenNumber(936672035);
			artist.setYearsOfExperience(5);
			artist.setAvailable(true);
			artist.setLanguagesSpoken("English");
			artist.setLocation("chennai");
			artist.setGenderOfArtist(Artist.gender.FEMALE);
			artist.setImageurl("https://iili.io/J97BLOB.jpg");

			boolean isAdded = artistservice.addArtist(artist);
			Assertions.assertTrue(isAdded);

		} catch (ArtistDetailsExceptions | DAOException | SQLException e) {
			System.out.println(e.getMessage());

			Assertions.assertEquals(ArtistErrors.EMAIL_ALREADY_PRESENT, e.getMessage());
		}
	}

	/**
	 * Test updating an artist's details in the database.
	 * 
	 * @throws ArtistDetailsExceptions if there's an issue with artist details.
	 * @throws DAOException            if there's an issue with the DAO operations.
	 * @throws SQLException            if there's an issue with SQL operations.
	 */
	@Test
	void UpdateArtistTestService() throws SQLException, ArtistDetailsExceptions, DAOException {

		ArtistService artistService = new ArtistService();

		int artistId = 26;

		Artist retrievedArtist = ArtistDAO.getArtistById(artistId);

		System.out.println(retrievedArtist.getUsername());
		if (retrievedArtist != null) {

			retrievedArtist.setYearsOfExperience(5);
			retrievedArtist.setUsername("Varshasri");
			retrievedArtist.setAvailable(false);
			boolean isUpdated = artistService.updateArtist(retrievedArtist);

			Assertions.assertTrue(isUpdated);

			Artist updatedArtist = ArtistDAO.getArtistById(artistId);
			Assertions.assertEquals("Varshasri", updatedArtist.getUsername());
			Assertions.assertEquals("varsha@gmail.com", updatedArtist.getEmail());
			Assertions.assertEquals(639907899, updatedArtist.getPhonenNumber());
			Assertions.assertEquals(5, updatedArtist.getYearsOfExperience());
			Assertions.assertEquals(false, updatedArtist.isAvailable());
			Assertions.assertEquals("English", updatedArtist.getLanguagesSpoken());
			Assertions.assertEquals("chennai", updatedArtist.getLocation());
			Assertions.assertEquals(gender.FEMALE, updatedArtist.getGenderOfArtist());
			Assertions.assertEquals("https://iili.io/HyPAMOP.jpg", updatedArtist.getImageurl());

		}
	}

	/**
	 * Test deleting an artist from the database.
	 * 
	 * @throws ArtistDetailsExceptions if there's an issue with artist details.
	 * @throws DAOException            if there's an issue with the DAO operations.
	 * @throws SQLException            if there's an issue with SQL operations.
	 */
	@Test
	void deleteArtistTestCase() throws ArtistDetailsExceptions, DAOException, SQLException {

		ArtistService artistservice = new ArtistService();
		int artistIdToDelete =18;
		Artist artistToDelete = ArtistDAO.getArtistById(artistIdToDelete);

		if (artistToDelete != null) {

			// Delete the artist
			boolean isDeleted = artistservice.deleteArtist(artistToDelete);
			Assertions.assertTrue(isDeleted);

			// Verify that the artist has been deleted
			Artist deletedArtist = ArtistDAO.getArtistById(artistIdToDelete);
			Assertions.assertNull(deletedArtist, "Deleted artist should not be found.");
		} else {
			Assertions.fail("Artist to delete not found.");
		}
	}

	/**
	 * Test retrieving posts by artist ID from the database.
	 * 
	 * @throws DAOException if there's an issue with the DAO operations.
	 */

	@Test
	void testGetPostsByArtistId_ValidInput() throws DAOException {
		try {
			ArtistService artistservice = new ArtistService();
			int artistId = 6;

			List<Post> posts = artistservice.getPostByArtistId(artistId);

			Assertions.assertFalse(posts.isEmpty());
			Assertions.assertEquals(10, posts.size());

			for (Post post : posts) {
				System.out.println("Post Title: " + post.getTitle());
			}

		} catch (SQLException e) {
			Assertions.fail("Exception thrown: " + e.getMessage());
		}
	}

	/**
	 * Test retrieving services by artist ID from the database.
	 * 
	 * @throws DAOException if there's an issue with the DAO operations.
	 */
	@Test
	void testGetServiceByArtistId() throws DAOException {
		try {
			ArtistService artistservice = new ArtistService();
			int artistId = 2;

			List<Service> services = artistservice.getServicesByArtistId(artistId);

			Assertions.assertFalse(services.isEmpty());
			Assertions.assertEquals(6, services.size());

			for (Service service : services) {
				System.out.println("Post Title: " + service.getCost() + " " + service.getName());
			}

		} catch (SQLException e) {
			Assertions.fail("Exception thrown: " + e.getMessage());
		}
	}

	/**
	 * Test retrieving posts by invalid artist ID from the database.
	 * 
	 * @throws DAOException if there's an issue with the DAO operations.
	 */
	@Test
	void testGetPostsByArtistId_InvalidArtistId() throws DAOException {
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

	
	
	@Test
	void testGetAllArtist() throws DAOException {
		try {
			ArtistService artistservice = new ArtistService();

			List<Artist> artists = artistservice.getAllartists();

			for (Artist artist : artists) {

				System.out.println(artist.getUsername());
			}
		} catch (SQLException e) {
			Assertions.fail("Exception thrown: " + e.getMessage());
		}

	}
}
