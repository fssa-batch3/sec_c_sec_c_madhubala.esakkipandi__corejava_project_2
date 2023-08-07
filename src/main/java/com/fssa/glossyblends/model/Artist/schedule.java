package com.fssa.glossyblends.model.Artist;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class schedule {
    private int artistId;
    private int schduleId;
    private LocalDate date;
    private String eventName;
    private LocalDateTime timeOfEvent;

    public schedule(int artistId, String eventName, LocalDate date, LocalDateTime timeOfEvent) {
        this.artistId = artistId;
//        this.schduleId = schduleId;
        this.date = date;
        this.eventName = eventName;
        this.timeOfEvent = timeOfEvent;
    }

  

	public schedule() {
		
	}

	public int getSchduleId() {
        return schduleId;
    }

    public void setSchduleId(int schduleId) {
        this.schduleId = schduleId;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public int getArtistId() {
        return artistId;
    }

    public void setArtistId(int artistId) {
        this.artistId = artistId;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public LocalDateTime getTimeOfEvent() {
        return timeOfEvent;
    }

    public void setTimeOfEvent(LocalDateTime timeOfEvent) {
        this.timeOfEvent = timeOfEvent;
    }
}
