package com.fssa.glossyblends.ArtistServiceLayer;

import com.fssa.glossyblends.CustomException.PostValueInvalidException;
import com.fssa.glossyblends.CustomException.ServiceValueInvalidException;
import com.fssa.glossyblends.DAO.ArtistDAO;
import com.fssa.glossyblends.Validator.ArtitsValidator;
import com.fssa.glossyblends.model.Artist.Artist;
import com.fssa.glossyblends.model.Artist.Post;

import java.util.List;

public class ArtistService {
	private ArtistDAO artistDAO;

	public ArtistService(ArtistDAO artistDAO) {
		this.artistDAO = artistDAO;
	}


	private boolean isEmailPresent(List<String> emailList, String email) {	
		
		System.out.println("lkjhgfd");
		
		return emailList.contains(email);

		

	}

	public boolean addArtist(Artist artist) throws IllegalArgumentException, PostValueInvalidException, ServiceValueInvalidException {
	    if (ArtitsValidator.validateArtist(artist)) {
	        List<String> emailList = artistDAO.getAllEmails();

	        if (!isEmailPresent(emailList, artist.getEmail())) {
	            artistDAO.addArtist(artist);
	            System.out.println("Madhu alaaded");
	            return true;
	            
	        }
	    }

	    return false;
	}



	public boolean updateArtist(Artist artist)
			throws IllegalArgumentException, PostValueInvalidException, ServiceValueInvalidException {
		// Validate the artist object using the ArtistValidator
		if (!ArtitsValidator.validateArtist(artist)) {
			System.out.println("Invalid artist information for update.");
			return false;
		}

		List<String> emailList = artistDAO.getAllEmails();



		artistDAO.updateArtist(artist);
		return true;
	}

	public boolean deleteArtist(Artist artist)
			throws IllegalArgumentException, PostValueInvalidException, ServiceValueInvalidException {
		// Validate the artist object using the ArtistValidator

		return artistDAO.deleteArtist(artist);
	}

	public List<Post> getPostByArtistId(int artistId) {

		return artistDAO.getPostsByArtistId(artistId);

	}

}
