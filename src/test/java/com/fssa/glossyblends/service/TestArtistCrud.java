package com.fssa.glossyblends.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.fssa.glossyblends.ArtistServiceLayer.ArtistService;
import com.fssa.glossyblends.CustomException.PostValueInvalidException;
import com.fssa.glossyblends.CustomException.ServiceValueInvalidException;
import com.fssa.glossyblends.DAO.ArtistDAO;
import com.fssa.glossyblends.model.Artist;
import com.fssa.glossyblends.model.Artist.gender;
import com.fssa.glossyblends.model.Post;
import com.fssa.glossyblends.util.ConnectionUtil;



public class TestArtistCrud {
	@Test
	public void testAddArtist_ValidInput() {
		try {
			Connection connection = ConnectionUtil.getConnection();
			ArtistDAO artistDAO = new ArtistDAO(connection);

			ArtistService artistService = new ArtistService(artistDAO);

			Artist artist = new Artist();
			artist.setUsername("joo");
			artist.setPassword("TestPassword123");
			artist.setEmail("Madhubal@gmail.com");
			artist.setPhone_number("1234567890");
			artist.setYearsOfExperience(5);
			artist.setAvailable(true);

			artist.setLanguagesSpoken("English");
			artist.setLocation("chennai");
			artist.setGenderOfArtist(Artist.gender.FEMALE);
			artist.setAverageRating(3);

			
			boolean isAdded = artistService.addArtist(artist);
			Assertions.assertTrue(isAdded);

			

			int artistId = artistDAO.getArtistByName(artist.getUsername());
			Assertions.assertTrue(artistId > 0); 

			Artist addedArtist = artistDAO.getArtistById(String.valueOf(artistId));
			Assertions.assertEquals("joo", addedArtist.getUsername());
			Assertions.assertEquals("Madhubal@gmail.com", addedArtist.getEmail());
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
			retrievedArtist.setUsername("Jothi");
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

			Assertions.assertEquals("Jothi", updatedArtist.getUsername());
			Assertions.assertEquals("joo123@example.com", updatedArtist.getEmail());
			Assertions.assertEquals("1234567890", updatedArtist.getPhone_number());
			Assertions.assertEquals(3, updatedArtist.getYearsOfExperience());
			Assertions.assertEquals(false, updatedArtist.isAvailable());
			Assertions.assertEquals("English", updatedArtist.getLanguagesSpoken());
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
	    
	    int artistIdToDelete =5; 
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

	        int artistId = 10; 
	        List<Post> posts = artistService.getPostByArtistId(artistId);
	        
	        Assertions.assertFalse(posts.isEmpty());
	       
	      Assertions.assertEquals(1,posts.size());

	        
	        
	        for (Post post : posts) {
	            System.out.println("Post Title: " + post.getTitle());
	            
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

	        int invalidArtistId = -1; 

	        List<Post> posts = artistService.getPostByArtistId(invalidArtistId);
	        
	        Assertions.assertNotNull(posts);
	        Assertions.assertTrue(posts.isEmpty());
	        
	        connection.close();
	    } catch (SQLException  e) {
	    	Assertions.fail("Exception thrown: " + e.getMessage());
	    }
	}

	
	
	

}
