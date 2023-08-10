package com.fssa.glossyblends.model;

public class Post {
	private int postId;
	private int artistId; // Add artistId property
	private String title;
	private String description;
	private String postUrl;

	public Post() {
		// Default constructor
	}

	public Post(int postId, int artistId, String title, String description, String postUrl) {
		this.postId = postId;
		this.artistId = artistId;
		this.title = title;
		this.description = description;
		this.postUrl = postUrl;
	}

	public int getPostId() {
		return postId;
	}

	public String getTitle() {
		return title;
	}

	public String getDescription() {
		return description;
	}

	public String getPostUrl() {
		return postUrl;
	}

	public void setPostId(int i) {
		this.postId = i;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setPostUrl(String postUrl) {
		this.postUrl = postUrl;
	}

	public void setArtistId(int artistId) {
		this.artistId = artistId;
	}

	public int getArtistId() {
		return artistId;
		
	}


	
	
}
