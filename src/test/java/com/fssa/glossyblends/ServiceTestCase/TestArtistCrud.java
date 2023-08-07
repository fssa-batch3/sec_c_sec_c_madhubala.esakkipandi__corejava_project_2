package com.fssa.glossyblends.ServiceTestCase;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import com.fssa.glossyblends.DAO.ArtistDAO;
import com.fssa.glossyblends.model.Artist.Artist;
import com.fssa.glossyblends.model.Artist.Artist.gender;
import com.fssa.glossyblends.model.Artist.Post;


import Connection.ConnectionUtil;

import com.fssa.glossyblends.ArtistServiceLayer.ArtistService;

import com.fssa.glossyblends.CustomException.PostValueInvalidException;
import com.fssa.glossyblends.CustomException.ServiceValueInvalidException;

import java.sql.Connection;

import java.sql.SQLException;

import java.util.List;

public class TestArtistCrud {
	@Test
	public void testAddArtist_ValidInput() {
		try {
			Connection connection = ConnectionUtil.getConnection();
			ArtistDAO artistDAO = new ArtistDAO(connection);

			ArtistService artistService = new ArtistService(artistDAO);

			Artist artist = new Artist();
			artist.setUsername("Madhubala");
			artist.setPassword("TestPassword123");
			artist.setEmail("joo12@example.com");
			artist.setPhone_number("1234567890");
			artist.setYearsOfExperience(5);
			artist.setAvailable(true);

			artist.setLanguagesSpoken("English");
			artist.setLocation("chennai");
			artist.setGenderOfArtist(Artist.gender.FEMALE);
			artist.setAverageRating(3);

			// Note: artist_id is not set here, as it's typically auto-incremented in the
			// database
			// Set other properties such as social media links, services, posts, schedules

			boolean isAdded = artistService.addArtist(artist);
			Assertions.assertTrue(isAdded);

			Assertions.assertTrue(isAdded);

//			// Now check if the added artist exists in the database
			int artistId = artistDAO.getArtistByName(artist.getUsername());
			Assertions.assertTrue(artistId > 0); // Assuming artist ID should be greater than 0

			// Retrieve the artist from the database and compare attributes
			Artist addedArtist = artistDAO.getArtistById(String.valueOf(artistId));
			Assertions.assertEquals("Madhubala", addedArtist.getUsername());
			Assertions.assertEquals("joo12@example.com", addedArtist.getEmail());
			Assertions.assertEquals("1234567890", addedArtist.getPhone_number());
			Assertions.assertEquals(5, addedArtist.getYearsOfExperience());
			Assertions.assertTrue(addedArtist.isAvailable());

			Assertions.assertEquals("English", addedArtist.getLanguagesSpoken());
			Assertions.assertEquals("chennai", addedArtist.getLocation());
			Assertions.assertEquals(Artist.gender.FEMALE, addedArtist.getGenderOfArtist());

			connection.close();
		} catch (SQLException | PostValueInvalidException | ServiceValueInvalidException e) {
			Assertions.fail("Exception thrown: " + e.getMessage());
		}
	}

	@Test
	public void UpdateArtistTestService()
			throws SQLException, IllegalArgumentException, PostValueInvalidException, ServiceValueInvalidException {
		Connection connection = ConnectionUtil.getConnection();
		ArtistDAO artistDAO = new ArtistDAO(connection);

		ArtistService artistService = new ArtistService(artistDAO);
		int artistId =9;

		Artist retrievedArtist = artistDAO.getArtistById(String.valueOf(artistId));

		if (retrievedArtist != null) {

			double originalAverageRating = retrievedArtist.getAverageRating();
			System.out.println(originalAverageRating);
			retrievedArtist.setAverageRating(4.5);

			retrievedArtist.setYearsOfExperience(3);

			retrievedArtist.setAvailable(false);

			System.out.println(retrievedArtist.getYearsOfExperience() + "uyht");
			boolean isUpdated = artistService.updateArtist(retrievedArtist);

			System.out.println(retrievedArtist.getArtistId() + "id");

			
			if (isUpdated) {

				System.out.println("Updated");

			}
			Assertions.assertTrue(isUpdated);

			Artist updatedArtist = artistDAO.getArtistById(String.valueOf(artistId));

			System.out.println(updatedArtist.getAverageRating());
			System.out.println(updatedArtist.getYearsOfExperience());

			Assertions.assertEquals("Madhubala", updatedArtist.getUsername());
			Assertions.assertEquals("Jalele@example.com", updatedArtist.getEmail());
			Assertions.assertEquals("1234567", updatedArtist.getPhone_number());
			Assertions.assertEquals(3, updatedArtist.getYearsOfExperience());
			Assertions.assertEquals(false, updatedArtist.isAvailable());
			Assertions.assertEquals("English, Hindi", updatedArtist.getLanguagesSpoken());
			Assertions.assertEquals("chennai", updatedArtist.getLocation());
			Assertions.assertEquals(gender.FEMALE, updatedArtist.getGenderOfArtist());

			Assertions.assertEquals(4.5, updatedArtist.getAverageRating());
		} else {

			Assertions.fail("Retrieved artist is null.");

		}

	}
	
	
	@Test
	public void deleteArtistTestCase() throws IllegalArgumentException, PostValueInvalidException, ServiceValueInvalidException {
	    Connection connection = ConnectionUtil.getConnection();
	    ArtistDAO artistDao = new ArtistDAO(connection);
	    ArtistService artistService = new ArtistService(artistDao);
	    
	    int artistIdToDelete =1; // Replace this with the artist ID you want to delete
	    
	    // Retrieve the artist by ID
	    Artist artistToDelete = artistDao.getArtistById(String.valueOf(artistIdToDelete));
	    
	    if (artistToDelete != null) {
	        // Delete the artist
	        boolean isDeleted = artistService.deleteArtist(artistToDelete);
	        
	        if (isDeleted) {
	            System.out.println("Artist with ID " + artistIdToDelete + " deleted successfully.");
	        } else {
	            System.out.println("Failed to delete artist with ID " + artistIdToDelete + ".");
	        }
	        
	        
	        
	        Assertions.assertTrue(isDeleted);
	        
	        // Verify that the artist has been deleted
	        Artist deletedArtist = artistDao.getArtistById(String.valueOf(artistIdToDelete));
	        Assertions.assertNull(deletedArtist, "Deleted artist should not be found.");
	    } else {
	        System.out.println("Artist with ID " + artistIdToDelete + " not found.");
	        Assertions.fail("Artist to delete not found.");
	    }
	}
	
	
	@Test
	public void testGetPostsByArtistId_ValidInput() {
	    try {
	        Connection connection = ConnectionUtil.getConnection();
	        ArtistDAO artistDAO = new ArtistDAO(connection);
	        
	        ArtistService artistService = new ArtistService(artistDAO);

	        int artistId = 2; // Replace with a valid artist ID

	        List<Post> posts = artistService.getPostByArtistId(artistId);
	        
	        Assertions.assertFalse(posts.isEmpty());
	       
	      Assertions.assertEquals(6,posts.size());

	        
	        
	        // You can add more assertions or validation here based on your actual data
	        // For example:
	        // assertEquals(expectedSize, posts.size());
	        
	        for (Post post : posts) {
	            System.out.println("Post Title: " + post.getTitle());
	            // Add more print statements or assertions here based on your data
	            // assertEquals(expectedValue, post.getSomeProperty());
	        }

	        connection.close();
	    } catch (SQLException  e) {
	        Assertions.fail("Exception thrown: " + e.getMessage());
	    }
	}
	@Test
	public void testGetPostsByArtistId_InvalidArtistId() {
	    try {
	        Connection connection = ConnectionUtil.getConnection();
	        ArtistDAO artistDAO = new ArtistDAO(connection);
	      
	        
	        ArtistService artistService = new ArtistService(artistDAO);

	        int invalidArtistId = -1; // Replace with an invalid artist ID

	        List<Post> posts = artistService.getPostByArtistId(invalidArtistId);
	        
	        Assertions.assertNotNull(posts);
	        Assertions.assertTrue(posts.isEmpty());
	        
	        connection.close();
	    } catch (SQLException  e) {
	    	Assertions.fail("Exception thrown: " + e.getMessage());
	    }
	}

	
	
	

}