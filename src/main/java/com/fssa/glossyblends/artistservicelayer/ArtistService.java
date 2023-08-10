package com.fssa.glossyblends.artistservicelayer;

import com.fssa.glossyblends.dao.ArtistDAO;
import com.fssa.glossyblends.model.Artist;
import com.fssa.glossyblends.model.Post;
import com.fssa.glossyblends.validator.ArtitsValidator;

import java.sql.SQLException;
import java.util.List;

public class ArtistService {

	private boolean isEmailPresent(List<String> emailList, String email) {

		return emailList.contains(email);

	}

	
	
	public boolean addArtist(Artist artist)
			throws IllegalArgumentException {
		if (ArtitsValidator.validateArtist(artist)) {
			List<String> emailList = ArtistDAO.getAllEmails();

			if (!isEmailPresent(emailList, artist.getEmail())) {
				ArtistDAO.addArtist(artist);
				return true;

			}

		}

		return false;
	}

	public boolean updateArtist(Artist artist) throws IllegalArgumentException {
		// Validate the artist object using the ArtistValidator
		if (!ArtitsValidator.validateArtist(artist)) {
			return false;
		}



		ArtistDAO.updateArtist(artist);
		return true;
	}

	public boolean deleteArtist(Artist artist) throws IllegalArgumentException {
		// Validate the artist object using the ArtistValidator

		return ArtistDAO.deleteArtist(artist);
	}

	public List<Post> getPostByArtistId(int artistId) throws SQLException {

		return ArtistDAO.getPostsByArtistId(artistId);

	}

}
