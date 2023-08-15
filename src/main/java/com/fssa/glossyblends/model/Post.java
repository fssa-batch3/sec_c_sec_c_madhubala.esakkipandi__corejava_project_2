package com.fssa.glossyblends.model;

public class Post {
	private int postId;
	private int artistId; 
	private String title;
	private String description;
	private String postUrl;

	public Post() {
		// Default constructor
	}

	//constructor for post object 
	public Post(int postId, int artistId, String title, String description, String postUrl) {
		this.postId = postId;
		this.artistId = artistId;
		this.title = title;
		this.description = description;
		this.postUrl = postUrl;
	}

	
	//getter method for postid
	public int getPostId() {
		return postId;
	}

	//getter method for title
	public String getTitle() {

		return title;
	}

	//getter method for description
	public String getDescription() {
		return description;
	}
//getter method for url of the post
	public String getPostUrl() {
		return postUrl;
	}

	//setter method url of the post
	public void setPostId(int i) {
		this.postId = i;
	}

	//setter method for title
	public void setTitle(String title) {
		this.title = title;
	}

	//setter method for description
	public void setDescription(String description) {
		this.description = description;
	}

	//setter method for  url of the post
	public void setPostUrl(String postUrl) {
		this.postUrl = postUrl;
	}

	//setter method for artist id 
	public void setArtistId(int artistId) {
		this.artistId = artistId;
	}

	//getter method for artist id
	public int getArtistId() {
		return artistId;

	}

}
