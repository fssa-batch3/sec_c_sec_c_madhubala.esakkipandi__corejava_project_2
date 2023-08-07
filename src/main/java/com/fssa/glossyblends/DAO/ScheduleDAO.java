package com.fssa.glossyblends.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;

import com.fssa.glossyblends.Validator.ScheduleValidations;
import com.fssa.glossyblends.model.Artist.schedule;

public class ScheduleDAO {

	
    private Connection connection;

    public ScheduleDAO(Connection connection) {
        this.connection = connection;
    }

    public boolean addSchedule(schedule listOfSchedule) throws IllegalArgumentException {
        // Validate the schedule before adding
        if (ScheduleValidations.validateSchedule(listOfSchedule)) {
            String query = "INSERT INTO artist_schedule (artist_id, event_date, event_name, event_time) VALUES (?, ?, ?, ?)";
            try (PreparedStatement smt = connection.prepareStatement(query)) {
                smt.setInt(1, listOfSchedule.getArtistId());
                LocalDate eventDate = listOfSchedule.getDate(); 
                if (eventDate != null) {
                    smt.setDate(2, java.sql.Date.valueOf(eventDate));
                } else {
                    throw new IllegalArgumentException("Event date cannot be null.");
                }
                
                LocalDateTime timeOfEvent = listOfSchedule.getTimeOfEvent();
                if (timeOfEvent != null) {
                    Timestamp sqlTimestampOfEvent = Timestamp.valueOf(timeOfEvent);
                    smt.setTimestamp(4, sqlTimestampOfEvent); // Use index 4 to set the event_time parameter
                } 

                smt.setString(3, listOfSchedule.getEventName());

                int rowsAffected = smt.executeUpdate();

                                
                if (rowsAffected > 0) {
                    System.out.println("Schedule details saved to the database.");
                    return true;
                } else {
                    System.out.println("Failed to save schedule details to the database.");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return false;
    }


}
