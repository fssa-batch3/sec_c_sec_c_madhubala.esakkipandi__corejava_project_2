package com.fssa.glossyblends.artistservicelayer;

import com.fssa.glossyblends.customexception.ArtistDetailsExceptions;
import com.fssa.glossyblends.customexception.DAOException;
import com.fssa.glossyblends.dao.ArtistDAO;
import com.fssa.glossyblends.model.Artist;
import com.fssa.glossyblends.model.Post;
import com.fssa.glossyblends.validator.ArtitsValidator;

import java.sql.SQLException;
import java.util.List;

public class ArtistService {

	// Check if the email is present in the list
	private boolean isEmailPresent(List<String> emailList, String email) {
		return emailList.contains(email);
	}

	// Method for adding an artist
	public boolean addArtist(Artist artist) throws ArtistDetailsExceptions, DAOException, SQLException {
		if (ArtitsValidator.validateArtist(artist)) { // Validate the artist using the validator
			List<String> emailList = ArtistDAO.getAllEmails(); // Get a list of all emails

			if (!isEmailPresent(emailList, artist.getEmail())) { // Check if email is not already in use
				ArtistDAO.addArtist(artist); // Add the artist to the database
				return true; // Successfully added
			}
		}

		return false; // Failed to add artist
	}

	// Method for updating artist details
	public boolean updateArtist(Artist artist) throws ArtistDetailsExceptions, DAOException, SQLException {
		if (!ArtitsValidator.validateArtist(artist)) { // Validate the artist using the validator
			return false; // Invalid artist data
		}

		ArtistDAO.updateArtist(artist); // Update the artist in the database
		return true; // Successfully updated
	}

	// Method for deleting an artist record
	public boolean deleteArtist(Artist artist) throws DAOException, SQLException {

		// No need to validate here, directly delete the artist

		return ArtistDAO.deleteArtist(artist); // Delete the artist from the database
	}

	// Method for getting all the artist's posts using the artist ID
	public List<Post> getPostByArtistId(int artistId) throws SQLException, DAOException {
		
		return ArtistDAO.getPostsByArtistId(artistId); // Get the artist's posts from the database
		
	}
}
