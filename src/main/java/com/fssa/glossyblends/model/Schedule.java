package com.fssa.glossyblends.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Schedule {
	private int artistId;
	private int schduleId;
	private LocalDate date;
	private String eventName;
	private LocalDateTime timeOfEvent;

	// constructor of schedule object
	public Schedule(int artistId, String eventName, LocalDate date, LocalDateTime timeOfEvent) {
		this.artistId = artistId;
		this.date = date;
		this.eventName = eventName;
		this.timeOfEvent = timeOfEvent;
	}

	public Schedule() {
		// Default Constructor
	}
	

	// getter method for id
	public int getSchduleId() {
		return schduleId;
	}

	// setter method for schdule id
	public void setSchduleId(int schduleId) {
		this.schduleId = schduleId;
	}

	// getter method for date
	public LocalDate getDate() {
		return date;
	}

	// setter method for date

	public void setDate(LocalDate date) {
		this.date = date;
	}

	// getter method for artist id
	public int getArtistId() {
		return artistId;
	}

	// setter method for artits id

	public void setArtistId(int artistId) {
		this.artistId = artistId;
	}

	// getter method event name
	public String getEventName() {
		return eventName;
	}

	// setter method for event name

	public void setEventName(String eventName) {
		this.eventName = eventName;
	}

	// getter method time of the event
	public LocalDateTime getTimeOfEvent() {
		return timeOfEvent;
	}
	// setter method for time of the event

	public void setTimeOfEvent(LocalDateTime timeOfEvent) {
		this.timeOfEvent = timeOfEvent;
	}
}
