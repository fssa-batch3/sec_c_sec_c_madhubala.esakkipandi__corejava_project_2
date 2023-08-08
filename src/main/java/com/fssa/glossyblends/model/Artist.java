package com.fssa.glossyblends.model;

import java.util.List;
//import java.util.ArrayList;

public class Artist {
	private int artistId;
	
	
	private String username;
	private String password;
	private String email;
	private String phoneNumber; 
	private int yearsOfExperience; 
	private boolean isAvailable; //
//	private List<Post> workLink ;
//	private List<Services> providingServices;
//	private List<Schedule> workingDaysCalender;
	private gender genderOfArtist;
	private List<String> socialMediaLinks;
	private String languagesSpoken;
	private String location;
	private double averageRating;


	// ENUM for gender

	public enum gender {

		FEMALE, MALE, TRANSGENDER

	}

	/// working blocking day calendar
//	public List<Schedule> getWorkingDaysCalender() {
//		return workingDaysCalender;
//	}
//
//	public void setWorkingDaysCalender(List<Schedule> workingDaysCalender) {
//		this.workingDaysCalender = workingDaysCalender;
//	}

//	public Artist() {
//		workLink = new ArrayList<Post>(); // Initialize the workLink list in the constructor
//		providingServices = new ArrayList<Services>();
//
//	}



	

//	// Service providing calendar
//	public List<Services> getProvidingServices() {
//		return providingServices;
//	}
//
//	public void setProvidingServices(List<Services> providingServices) {
//		this.providingServices = providingServices;
//	}
//
//	// Getter and setter for workLink (list of posts)
//	public List<Post> getWorkLink() {
//		return workLink;
//	}
//
//	public void setWorkLink(List<Post> workLink) {
//		this.workLink = workLink;
//	}

	// The addPost method remains the same as before

	// Artist id
	public int getArtistId() {
		return artistId;
	}

	public void setArtistId(int string) {
		this.artistId = string;
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
	public String getPhonenNumber() {	
		return phoneNumber;
	}

	public void setPhonenNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	
	// year of experience
	public int getYearsOfExperience() {
		return yearsOfExperience;
	}

	public void setYearsOfExperience(int yearsOfExperience) {
		this.yearsOfExperience = yearsOfExperience;
	}
	

	/// availability of artist
	public boolean isAvailable() {
		return isAvailable;
	}

	public void setAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
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
