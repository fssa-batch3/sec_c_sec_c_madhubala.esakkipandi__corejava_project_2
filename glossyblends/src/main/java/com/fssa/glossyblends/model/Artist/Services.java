package com.fssa.glossyblends.model.Artist;

public class Services {
	private ServiceCategory category;
	private String name;
	private double cost;
	private String sampleImage;
	private int artistId;

	public Services(int artistId, ServiceCategory category, String name, double cost, String sampleImage) {
		this.category = category;
		this.name = name;
		this.artistId = artistId;
		this.cost = cost;
		this.sampleImage = sampleImage;
	}

	
	public Services() {
	}

	public ServiceCategory getCategory() {
		return category;
	}

	public void setCategory(ServiceCategory category) {
		this.category = category;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	public String getSampleImage() {
		
		return sampleImage;
	}

	public void setSampleImage(String sampleImage) {
		this.sampleImage = sampleImage;
	}

	public int getArtistId() {
		return artistId;
	}

	public void setArtistId(int artistId) {
		this.artistId = artistId;
	}

	

}
