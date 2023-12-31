package com.fssa.glossyblends.model;

import java.util.List;

public class Artist {
	private int artistId;
	private String username;
	private String password;
	private String email;
	private long phoneNumber;
	private int yearsOfExperience;
	private boolean isAvailable;
	private gender genderOfArtist;
	private String languagesSpoken;
	private String location;
 private String imageurl;
	private List<Post> posts;
	private List<Service> service;
	private List<Schedule> schedule;

	public List<Post> getPosts() {
		return posts;
	}

	// Setter method for posts
	public void setPosts(List<Post> posts) {
		this.posts = posts;
	}
	// ENUM for gender

	public enum gender {

		FEMALE, MALE, TRANSGENDER

	}

	
	public Artist() {

	}

	// getter method for Artist id
	public int getArtistId() {
		return artistId;
	}

	// setter method for artist id
	public void setArtistId(int artistId) {
		this.artistId = artistId;
	}

	// artist name

	// getter method for username
	public String getUsername() {
		return username;
	}

//setter method for username
	public void setUsername(String username) {
		this.username = username;
	}

	// getter method artist password
	public String getPassword() {
		return password;
	}

//setter method for password
	public void setPassword(String password) {
		this.password = password;
	}

	// getter method artist email
	public String getEmail() {
		return email;
	}

//setter method for email
	public void setEmail(String email) {
		this.email = email;
	}

	// getter method for artist mobile number
	public long getPhonenNumber() {
		return phoneNumber;
	}

	// setter method for for mobile number
	public void setPhonenNumber(long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	// getter method for year of experience
	public int getYearsOfExperience() {
		return yearsOfExperience;
	}

	// setter method for year of experience
	public void setYearsOfExperience(int yearsOfExperience) {
		this.yearsOfExperience = yearsOfExperience;
	}

	/// setter method for availability of artist
	public boolean isAvailable() {
		return isAvailable;
	}

//setter method for availability 
	public void setAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}

	// getter method for location of artist
	public String getLocation() {
		return location;
	}

	// setter method for location
	public void setLocation(String location) {
		this.location = location;
	}

	// getter method for average rating for artist

	// getter method for languages spoken

	public String getLanguagesSpoken() {
		return languagesSpoken;
	}

	// setter method for language spoken
	public void setLanguagesSpoken(String languagesSpoken) {
		this.languagesSpoken = languagesSpoken;
	}

	// getter method for enum gender of artist

	public gender getGenderOfArtist() {
		return genderOfArtist;
	}

	// setter method for gender
	public void setGenderOfArtist(gender genderOfArtist) {
		this.genderOfArtist = genderOfArtist;
	}

	public List<Service> getService() {
		return service;
	}

	public void setService(List<Service> service) {
		this.service = service;
	}

	public List<Schedule> getSchedule() {
		return schedule;
	}

	public void setSchedule(List<Schedule> schedule) {
		this.schedule = schedule;
	}

	public String getImageurl() {
		return imageurl;
	}

	public void setImageurl(String imageurl) {
		this.imageurl = imageurl;
	}

}
