package com.fssa.glossyblends.ArtistServiceLayer;

import com.fssa.glossyblends.CustomException.PostValueInvalidException;
import com.fssa.glossyblends.CustomException.ServiceValueInvalidException;
import com.fssa.glossyblends.DAO.ArtistDAO;
import com.fssa.glossyblends.Validator.ArtitsValidator;
import com.fssa.glossyblends.model.Artist;
import com.fssa.glossyblends.model.Post;

import java.sql.SQLException;
import java.util.List;


public class ArtistService {
	private static ArtistDAO artistDAO;

	public ArtistService(ArtistDAO artistDAO) {
		ArtistService.artistDAO = artistDAO;
	}

	private static boolean isEmailPresent(List<String> emailList, String email) {

		System.out.println("Already present");

		return emailList.contains(email);

	}
	

	public static boolean addArtist(Artist artist)
			throws IllegalArgumentException, PostValueInvalidException, ServiceValueInvalidException {
		if (ArtitsValidator.validateArtist(artist)) {
			List<String> emailList = ArtistDAO.getAllEmails();

			if (!isEmailPresent(emailList, artist.getEmail())) {
				ArtistDAO.addArtist(artist);
				System.out.println("Madhu alaaded");
				return true;

			}
			

			
		}

		return false;
	}

	public static boolean updateArtist(Artist artist)
			throws IllegalArgumentException, PostValueInvalidException, ServiceValueInvalidException {
		// Validate the artist object using the ArtistValidator
		if (!ArtitsValidator.validateArtist(artist)) {
			System.out.println("Invalid artist information for update.");
			return false;
		}

		List<String> emailList = ArtistDAO.getAllEmails();

		ArtistDAO.updateArtist(artist);
		return true;
	}

	public static boolean deleteArtist(Artist artist)
			throws IllegalArgumentException, PostValueInvalidException, ServiceValueInvalidException {
		// Validate the artist object using the ArtistValidator

		return ArtistDAO.deleteArtist(artist);
	}

	public static List<Post> getPostByArtistId(int artistId) throws SQLException {

		return ArtistDAO.getPostsByArtistId(artistId);

	}

}
