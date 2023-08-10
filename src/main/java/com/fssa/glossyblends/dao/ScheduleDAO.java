package com.fssa.glossyblends.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.ArrayList;
import java.sql.ResultSet;

import com.fssa.glossyblends.model.Schedule;
import com.fssa.glossyblends.util.ConnectionUtil;

public class ScheduleDAO {

	
 
    public static boolean addSchedule(Schedule listOfSchedule) throws IllegalArgumentException, SQLException {
       
            String query = "INSERT INTO artist_schedule (artist_id, event_date, event_name, event_time) VALUES (?, ?, ?, ?)";
            
        	try(Connection connection=ConnectionUtil.getConnection()){

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
                    return true;
                } 
            } 
        }
        	catch (SQLException e) {
                e.printStackTrace();
            }
        return false;
    }

    
   
 // ScheduleDAO class
    public static boolean deleteSchedule(int artistId, int id) throws SQLException {
        String query = "DELETE FROM artist_schedule WHERE artist_id = ? AND id = ?";
    	try(Connection connection=ConnectionUtil.getConnection()){

        try (PreparedStatement smt = connection.prepareStatement(query)) {
            smt.setInt(1, artistId);
            smt.setInt(2, id);

            int rowsAffected = smt.executeUpdate();

            if (rowsAffected > 0) {
                return true;
            } 
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    	}
    }

    
    
    public static List<Schedule> getSchedulesByArtistId(int artistId) {
        List<Schedule> schedulesList = new ArrayList<>();

        String query = "SELECT * FROM artist_schedule WHERE artist_id = ?";
    	try(Connection connection=ConnectionUtil.getConnection()){

        try (PreparedStatement smt = connection.prepareStatement(query)) {
            smt.setInt(1, artistId);

            try (ResultSet rs = smt.executeQuery()) {
                while (rs.next()) {
                	Schedule schedule = new Schedule();
                    schedule.setArtistId(rs.getInt("artist_id"));
                    schedule.setEventName(rs.getString("event_name"));

                    LocalDate eventDate = rs.getDate("event_date").toLocalDate();
                    schedule.setDate(eventDate);

                    LocalDateTime eventTime = rs.getTimestamp("event_time").toLocalDateTime();
                    schedule.setTimeOfEvent(eventTime);

                    schedulesList.add(schedule);
                }
            }
        } 
    }catch (SQLException e) {
        e.printStackTrace();
    }

    return schedulesList;
    
    }
    }
    


