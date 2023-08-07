package com.fssa.glossyblends.ArtistServiceLayer;

import java.sql.Connection;
import java.time.LocalDateTime;
import java.util.List;

import com.fssa.glossyblends.DAO.ScheduleDAO;
import com.fssa.glossyblends.Validator.PostValidations;
import com.fssa.glossyblends.Validator.ScheduleValidations;
import com.fssa.glossyblends.model.Artist.Post;
import com.fssa.glossyblends.model.Artist.schedule;

public class ScheduleServiceLayer {

    private ScheduleDAO scheduleDAO;

    public ScheduleServiceLayer(Connection connection) {
        scheduleDAO = new ScheduleDAO(connection);
    }

   
    
    
    
    
    public boolean addSchedule(schedule listOfSchedule)  {
        // Validate the schedule before adding
        if (ScheduleValidations.validateSchedule(listOfSchedule)) {
            LocalDateTime timeOfEvent = listOfSchedule.getTimeOfEvent();
            if (timeOfEvent != null) {
                return scheduleDAO.addSchedule(listOfSchedule);
            } 

        }
        return false;

    }
    
    
    
    
    
    
    
    
    
    
}
