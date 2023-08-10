package com.fssa.glossyblends.service;

import java.sql.SQLException;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.fssa.glossyblends.artistservicelayer.ArtistService;
import com.fssa.glossyblends.customexception.PostValueInvalidException;
import com.fssa.glossyblends.customexception.ServiceValueInvalidException;
import com.fssa.glossyblends.dao.ArtistDAO;
import com.fssa.glossyblends.model.Artist;
import com.fssa.glossyblends.model.Artist.gender;
import com.fssa.glossyblends.model.Post;



 class TestArtistCrud {
	@Test
	 void testAddArtist_ValidInput() {
		try {
//			Connection connection = ConnectionUtil.getConnection();
			ArtistDAO artistDAO = new ArtistDAO();

			ArtistService artistService = new ArtistService(artistDAO);

			Artist artist = new Artist();
			artist.setUsername("jallela");
			artist.setPassword("TestPassword123");
			artist.setEmail("jaleeallll@gmail.com");
			artist.setPhonenNumber("1234567890");
			artist.setYearsOfExperience(5);
			artist.setAvailable(true);

			artist.setLanguagesSpoken("English");
			artist.setLocation("chennai");
			artist.setGenderOfArtist(Artist.gender.FEMALE);
			artist.setAverageRating(3);

			
			
			boolean isAdded = ArtistService.addArtist(artist);
			Assertions.assertTrue(isAdded);

			if(isAdded) {
				
				System.out.println("Added");
			}
			else {
				System.out.println(" not Added");

			}

			
//			int artistId = ArtistDAO.getArtistByName(artist.getUsername());
//			Assertions.assertTrue(artistId > 0); 
//
//			Artist addedArtist = ArtistDAO.getArtistById(String.valueOf(artistId));
//			Assertions.assertEquals("joo", addedArtist.getUsername());
//			Assertions.assertEquals("Madhubal@gmail.com", addedArtist.getEmail());
//			Assertions.assertEquals("1234567890", addedArtist.getPhone_number());
//			Assertions.assertEquals(5, addedArtist.getYearsOfExperience());
//			Assertions.assertTrue(addedArtist.isAvailable());
//
//			Assertions.assertEquals("English", addedArtist.getLanguagesSpoken());
//			Assertions.assertEquals("chennai", addedArtist.getLocation());
//			Assertions.assertEquals(Artist.gender.FEMALE, addedArtist.getGenderOfArtist());

			
		} catch (  PostValueInvalidException | ServiceValueInvalidException e) {
			Assertions.fail("Exception thrown: " + e.getMessage());
		}
	}

	@Test
	 void UpdateArtistTestService()
			throws SQLException, IllegalArgumentException, PostValueInvalidException, ServiceValueInvalidException {
//		Connection connection = ConnectionUtil.getConnection();
	
		ArtistDAO artistDAO = new ArtistDAO();

		ArtistService artistService = new ArtistService(artistDAO);

		int artistId =9;

		Artist retrievedArtist = ArtistDAO.getArtistById(String.valueOf(artistId));

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

			Artist updatedArtist = ArtistDAO.getArtistById(String.valueOf(artistId));

			System.out.println(updatedArtist.getAverageRating());
			System.out.println(updatedArtist.getYearsOfExperience());

			Assertions.assertEquals("Jothi", updatedArtist.getUsername());
			Assertions.assertEquals("joo123@example.com", updatedArtist.getEmail());
			Assertions.assertEquals("1234567890", updatedArtist.getPhonenNumber());
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
	 void deleteArtistTestCase() throws IllegalArgumentException, PostValueInvalidException, ServiceValueInvalidException {
		ArtistDAO artistDAO = new ArtistDAO();

	

	 new ArtistService(artistDAO);
	    
	    int artistIdToDelete =45; 
	    Artist artistToDelete = ArtistDAO.getArtistById(String.valueOf(artistIdToDelete));
	    
	    if (artistToDelete != null) {
	        // Delete the artist
	        boolean isDeleted = ArtistService.deleteArtist(artistToDelete);
	        
	        if (isDeleted) {
	            System.out.println("Artist with ID " + artistIdToDelete + " deleted successfully.");
	        } else {
	            System.out.println("Failed to delete artist with ID " + artistIdToDelete + ".");
	        }
	        
	        
	        
	        
	        Assertions.assertTrue(isDeleted);
	        
	        // Verify that the artist has been deleted
	        Artist deletedArtist = ArtistDAO.getArtistById(String.valueOf(artistIdToDelete));
	        Assertions.assertNull(deletedArtist, "Deleted artist should not be found.");
	    } else {
	        System.out.println("Artist with ID " + artistIdToDelete + " not found.");
	        Assertions.fail("Artist to delete not found.");
	    }
	}
	
	
	@Test
	
	void testGetPostsByArtistId_ValidInput() {
	    try {

			ArtistDAO artistDAO = new ArtistDAO();

//			ArtistService artistService = new ArtistService(artistDAO);
	        
	  new ArtistService(artistDAO);

	        int artistId = 10; 
	        List<Post> posts = ArtistService.getPostByArtistId(artistId);
	        
	        Assertions.assertFalse(posts.isEmpty());
	       
	      Assertions.assertEquals(1,posts.size());

	        
	        
	        for (Post post : posts) {
	            System.out.println("Post Title: " + post.getTitle());
	            
	        }

	      
	    } catch (SQLException  e) {
	        Assertions.fail("Exception thrown: " + e.getMessage());
	    }
	}
	@Test
	 void testGetPostsByArtistId_InvalidArtistId() {
	    try {

			ArtistDAO artistDAO = new ArtistDAO();

//			ArtistService artistService = new ArtistService(artistDAO);
	      
	        
	  new ArtistService(artistDAO);

	        int invalidArtistId = -1; 

	        List<Post> posts = ArtistService.getPostByArtistId(invalidArtistId);
	        
	        Assertions.assertNotNull(posts);
	        Assertions.assertTrue(posts.isEmpty());
	        
	       
	    } catch (SQLException  e) {
	    	Assertions.fail("Exception thrown: " + e.getMessage());
	    }
	}

	
	
	

}
