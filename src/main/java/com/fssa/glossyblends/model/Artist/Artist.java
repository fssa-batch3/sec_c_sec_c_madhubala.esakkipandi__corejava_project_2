package com.fssa.glossyblends.model.Artist;

import java.util.List;
import java.util.ArrayList;

public class Artist {
	private int artist_id;
	
	
	private String username;
	private String password;
	private String email;
	private String phone_number; 
	private int years_of_experience; 
	private boolean is_available; //
	private List<Post> workLink = new ArrayList<Post>();
	private List<Services> providingServices;
	private List<schedule> workingDaysCalender;
	private gender genderOfArtist;
	private List<String> socialMediaLinks;
	private String languagesSpoken;
	private String location;
	private double averageRating;
	private List<String> reviews;

	// ENUM for gender

	public enum gender {

		FEMALE, MALE, TRANSGENDER

	}

	/// working blocking day calendar
	public List<schedule> getWorkingDaysCalender() {
		return workingDaysCalender;
	}

	public void setWorkingDaysCalender(List<schedule> workingDaysCalender) {
		this.workingDaysCalender = workingDaysCalender;
	}

	public Artist() {
		workLink = new ArrayList<Post>(); // Initialize the workLink list in the constructor
		providingServices = new ArrayList<Services>();

	}



	

	// Service providing calendar
	public List<Services> getProvidingServices() {
		return providingServices;
	}

	public void setProvidingServices(List<Services> providingServices) {
		this.providingServices = providingServices;
	}

	// Getter and setter for workLink (list of posts)
	public List<Post> getWorkLink() {
		return workLink;
	}

	public void setWorkLink(List<Post> workLink) {
		this.workLink = workLink;
	}

	// The addPost method remains the same as before

	// Artist id
	public int getArtistId() {
		return artist_id;
	}

	public void setArtistId(int string) {
		this.artist_id = string;
	}

	// artist name
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	// artist password
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	// artist email
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	// artist mobile number
	public String getPhone_number() {	
		return phone_number;
	}

	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}

	
	// year of experience
	public int getYearsOfExperience() {
		return years_of_experience;
	}

	public void setYearsOfExperience(int yearsOfExperience) {
		this.years_of_experience = yearsOfExperience;
	}
	

	/// availability of artist
	public boolean isAvailable() {
		return is_available;
	}

	public void setAvailable(boolean isAvailable) {
		this.is_available = isAvailable;
	}

	// location of artist
	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	// average rating for artist

	public double getAverageRating() {
		return averageRating;
	}

	public void setAverageRating(double averageRating) {
		this.averageRating = averageRating;
	}

	/// list of reviews for artist
	public List<String> getReviews() {
		return reviews;
	}

	public void setReviews(List<String> reviews) {
		this.reviews = reviews;
	}

	// social media link
	public List<String> getSocialMediaLinks() {
		return socialMediaLinks;
	}

	public void setSocialMediaLinks(List<String> socialMediaLinks) {
		this.socialMediaLinks = socialMediaLinks;
	}

	// languages spoken

	public String getLanguagesSpoken() {
		return languagesSpoken;
	}

	public void setLanguagesSpoken(String languagesSpoken) {
		this.languagesSpoken = languagesSpoken;
	}

	// gender of artist

	public gender getGenderOfArtist() {
		return genderOfArtist;
	}

	public void setGenderOfArtist(gender genderOfArtist) {
		this.genderOfArtist = genderOfArtist;
	}

	
	
	
}
