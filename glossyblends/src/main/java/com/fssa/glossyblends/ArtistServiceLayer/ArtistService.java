package com.fssa.glossyblends.ArtistServiceLayer;

import com.fssa.glossyblends.CustomException.PostValueInvalidException;
import com.fssa.glossyblends.CustomException.ServiceValueInvalidException;
import com.fssa.glossyblends.DAO.ArtistDAO;
import com.fssa.glossyblends.Validator.ArtitsValidator;
import com.fssa.glossyblends.model.Artist.Artist;

import java.util.List;

public class ArtistService {
    private ArtistDAO artistDAO;

    public ArtistService(ArtistDAO artistDAO) {
        this.artistDAO = artistDAO;
    }

	// Method to check if an artist with a given name is already present in the database
    private boolean isEmailPresent(List<String> emailList, String email) {
        return emailList.contains(email);
    }

    public boolean addArtist(Artist artist) throws IllegalArgumentException, PostValueInvalidException, ServiceValueInvalidException {
        // Validate the artist object using the ArtistValidator
        if (!ArtitsValidator.validateArtist(artist)) {
            System.out.println("Invalid artist information.");
            return false;
        }

        // Get all emails from the DAO
        List<String> emailList = artistDAO.getAllEmails();

        // Check if the artist email is already present in the list
        if (isEmailPresent(emailList, artist.getEmail())) {
            System.out.println("Artist with the email '" + artist.getEmail() + "' already exists.");
            return false;
        }

        artistDAO.addArtist(artist);
        return true;
    }

    public boolean updateArtist(Artist artist) throws IllegalArgumentException, PostValueInvalidException, ServiceValueInvalidException {
        // Validate the artist object using the ArtistValidator
        if (!ArtitsValidator.validateArtist(artist)) {
            System.out.println("Invalid artist information for update.");
            return false;
        }

        // Get all emails from the DAO
        List<String> emailList = artistDAO.getAllEmails();

        // Check if the artist email is already present in the list (exclude the artist's own email)
//        for (String email : emailList) {
//            if (email.equals(artist.getEmail())) {
//                System.out.println("Artist with the email '" + artist.getEmail() + "' already exists.");
//                return false;
//            }
//        }
        
        
        
        artistDAO.updateArtist(artist);
        return true;
    }
    
    
    
    public boolean deleteArtist(Artist artist) throws IllegalArgumentException, PostValueInvalidException, ServiceValueInvalidException {
        // Validate the artist object using the ArtistValidator
        if (!ArtitsValidator.validateArtist(artist)) {
            System.out.println("Invalid artist information for deletion.");
            return false;
        }

        return artistDAO.deleteArtist(artist);
    }


	
    
    
    
    
    
    
    
    
    
    
}
