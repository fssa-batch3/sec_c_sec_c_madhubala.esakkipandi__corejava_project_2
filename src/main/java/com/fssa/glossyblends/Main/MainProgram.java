//package com.fssa.glossyblends.Main;
//
//import com.fssa.glossyblends.DAO.ArtistDAO;
//import com.fssa.glossyblends.DAO.PostDAO;
//import com.fssa.glossyblends.DAO.ScheduleDAO;
//
//import com.fssa.glossyblends.ArtistServiceLayer.ScheduleServiceLayer;
//import com.fssa.glossyblends.ArtistServiceLayer.ArtistService;
//
//import com.fssa.glossyblends.ArtistServiceLayer.PostServiceLayer; // Import the PostServiceLayer
//import com.fssa.glossyblends.CustomException.PostValueInvalidException;
//import com.fssa.glossyblends.CustomException.ServiceValueInvalidException;
//import com.fssa.glossyblends.model.Artist.Artist;
//import com.fssa.glossyblends.model.Artist.Post;
//import com.fssa.glossyblends.model.Artist.Services;
//import com.fssa.glossyblends.model.Artist.schedule;
//import com.fssa.glossyblends.DAO.ScheduleDAO;
//
//import com.fssa.glossyblends.model.Artist.ServiceCategory;
//import com.fssa.glossyblends.DAO.ServiceProvidingDAO; // Add this import statement
//
//import Connection.ConnectionUtil;
//
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.SQLException;
//import java.sql.Time;
//import java.time.LocalDate;
//import java.time.LocalDateTime;
//import java.time.LocalTime;
//import java.time.format.DateTimeFormatter;
//import java.util.ArrayList;
//import java.util.List;
//
//public class MainProgram {
//	public static void main(String[] args) throws IllegalArgumentException, PostValueInvalidException, ServiceValueInvalidException {
//
//		try {
//			Connection connection = ConnectionUtil.getConnection();
//
//			ArtistDAO artistDAO = new ArtistDAO(connection);
//
//			ArtistService artistService = new ArtistService(artistDAO);
//
//			/// add artist method
//
////			Artist madhubala = new Artist();
////			madhubala.setUsername("Prathiusha");
////			madhubala.setPassword("Prathiusha123");
////			madhubala.setEmail("Prathiusha@example.com");
////			madhubala.setPhone_number("1234567");
////			madhubala.setYearsOfExperience(10);
////			madhubala.setAvailable(true);
////			madhubala.setLocation("chennai");
////			madhubala.setLanguagesSpoken("English, Hindi");
////			madhubala.setGenderOfArtist(Artist.gender.FEMALE);
////			madhubala.setAverageRating(4.8);
////
////			List<String> socialMediaLinks = new ArrayList<String>();
////			socialMediaLinks.add("https://www.facebook.com/madhubala");
////			socialMediaLinks.add("https://www.instagram.com/madhubala");
////			socialMediaLinks.add("https://twitter.com/madhubala");
////
////			madhubala.setSocialMediaLinks(socialMediaLinks);
////           
////			artistService.addArtist(madhubala);
//
//			//////////////////////////////////////// end of add artist
//
//			
//			
//			
//			
//			
//			
//			
//			
//			
//			
//			
////			---------------update the artits details
//			int artistId = 3; // Replace this with the artist ID of the artist you want to update
//			Artist artist = artistDAO.getArtistById(String.valueOf(artistId));
//
//			if (artist != null) {
//			    // Step 2: Modify the required fields of the artist object
//			    artist.setUsername("NewUsername");
//			    artist.setPassword("Madhu1234");
//
//			    artist.setEmail("Madhu@gmai.com.com");
//			    artist.setPhone_number("9876543210");
//
//			    // Step 3: Call the updateArtist method to update the artist in the database
//			    boolean isUpdateSuccessful = artistDAO.updateArtist(artist);
//
//			    if (isUpdateSuccessful) {
//			        System.out.println("Artist details updated successfully.");
//			    } else {
//			        System.out.println("Failed to update artist details.");
//			    }
//
//			    // Step 4: Retrieve the artist again from the database to ensure the changes were saved
//			    Artist updatedArtist = artistDAO.getArtistById(String.valueOf(artistId));
//			    if (updatedArtist != null) {
//			        // Print the updated details to verify
//			        System.out.println("Updated Artist Details:");
//			        System.out.println("Username: " + updatedArtist.getUsername());
//			        System.out.println("Email: " + updatedArtist.getEmail());
//			        System.out.println("Phone Number: " + updatedArtist.getPhone_number());
//			        // ...
//			    } else {
//			        System.out.println("Artist with the specified ID not found.");
//			    }
//			} else {
//			    System.out.println("Artist with the specified ID not found.");
//			}
//
//			
////			----------------------
//			
////			adding post
//			if (artist != null) {
//				artist.setArtistId(artistId);
//
//				Post newPost = new Post();
//				newPost.setPostId("post123");
//				newPost.setArtistId(artistId);
//				newPost.setTitle("New Artwork");
//				newPost.setDescription("This is my artt5");
//				newPost.setPostUrl("https://example.com/new_artwork.jpg");
//
//				artist.getWorkLink().add(newPost);
//
//				
//				// Update the artist in the database to include the new post
//				boolean isUpdateSuccessful = artistDAO.updateArtist(artist);
//
//				if (isUpdateSuccessful) {
//					System.out.println("New artwork added to the artist's profile.");
//				} else {
//					System.out.println("Failed to update the artist's profile.");
//				}
//
//				PostServiceLayer postService = new PostServiceLayer(connection);
//				boolean isPostAdded = postService.addPost(newPost);
//
//				if (isPostAdded) {
//					System.out.println("New post added successfully.");
//				} else {
//					System.out.println("Failed to add the new post.");
//				}
//			} else {
//				System.out.println("Artist with the specified ID not found.");
//			}
//			
//			
//			
//			
//			
//
//// ---------------------------------  ------------------------------------------code for add post
//
////			ServiceProvidingDAO serviceDAO = new ServiceProvidingDAO(connection);
////
////			ServiceCategory category = ServiceCategory.HAIR_STYLE;
////			String name = "Haircut";
////			double cost = 50.0;
////			String sampleImage = "sample_image.jpg";
////
////			Services service = new Services(artistId, category, name, cost, sampleImage);
////
////			boolean isServiceAdded = serviceDAO.addService(service);
////
////			if (isServiceAdded) {
////				System.out.println("Service added successfully.");
////			} else {
////				System.out.println("Failed to add the service.");
////			}
//
////   -----------------------------------------------------code for add srvice         
//			
//			
//			
//			
//			ScheduleDAO scheduleDAO = new ScheduleDAO(connection);
//			ScheduleServiceLayer scheduleServiceLayer = new ScheduleServiceLayer(connection);
//
//			LocalDate date1 = LocalDate.of(2023, 8, 6);
//			String eventName1 = "Event";
//			LocalTime timeOfEvent1 = LocalTime.of(12, 10, 2, 3);
//
//			// Combine date and time to create a LocalDateTime object
//			LocalDateTime dateTimeOfEvent1 = LocalDateTime.of(date1, timeOfEvent1);
//
//			schedule schedule1 = new schedule(artistId, eventName1, date1, dateTimeOfEvent1);
//			schedule1.setArtistId(artistId);
//			schedule1.setDate(date1);
//			schedule1.setEventName(eventName1);
//
//			// Set the LocalDateTime value for the time of the event
//			schedule1.setTimeOfEvent(dateTimeOfEvent1);
//
//			boolean isSchedule1Added = scheduleServiceLayer.addSchedule(schedule1);
//
//			if (isSchedule1Added) {
//			    System.out.println("Schedule added successfully for artist with ID: " + artistId);
//			} else {
//			    System.out.println("Failed to add the schedule for artist with ID: " + artistId);
//			}
//
////----------------------------
//            
//            
//            
//            
//            
//            
////            int artistId = 3; // Replace this with the artist ID of the artist whose posts you want to retrieve
//
//            // Call the getPostsByArtistId method to retrieve the posts for the specified artist ID
//            List<Post> posts = artistDAO.getPostsByArtistId(artistId);
//
//            // Print the details of the retrieved posts
//            for (Post post : posts) {
//                System.out.println("Post ID: " + post.getPostId());
//                System.out.println("Title: " + post.getTitle());
//                System.out.println("Description: " + post.getDescription());
//                System.out.println("Post URL: " + post.getPostUrl());
//                // Add other properties as needed
//
//                System.out.println("---------------------------------");
//            }
//            
//            
//            
//            
//            
//            
//            
//            
//            
//            
//			connection.close();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//	}
//}
