package com.fssa.glossyblends.service;

import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.fssa.glossyblends.artistservicelayer.ScheduleServiceLayer;
import com.fssa.glossyblends.customexception.ArtistDetailsExceptions;
import com.fssa.glossyblends.customexception.DAOException;
import com.fssa.glossyblends.customexception.ScheduleValueInvalidException;
import com.fssa.glossyblends.model.Schedule;

/**
 * Unit tests for CRUD (Create, Read, Update, Delete) operations on schedules.
 */
class TestScheduleCrud {

    /**
     * Test adding a new schedule.
     * @throws DAOexception 
     * @throws ArtistDetailsInvalidExceptions 
     *
     */
	
	  @Test
	    void testAddSchedule() throws SQLException, DAOException, ScheduleValueInvalidException, ArtistDetailsExceptions {
	        Schedule schedule = new Schedule();
	        schedule.setDate(LocalDate.of(2023, 8, 25)); 
	        schedule.setTimeOfEvent(LocalDateTime.of(2023, 8, 25, 15, 30)); 
	        schedule.setEventName("Sample Event");

	        String artistEmail = "esakipandi@gmail.com"; 
	        
	        ScheduleServiceLayer service = new ScheduleServiceLayer();

	        boolean added = service.addSchedule(artistEmail, schedule);

	        Assertions.assertTrue(added);
	    }

    /**
     * Test deleting a schedule.
     * @throws DAOException 
     *
     */
    
    @Test
    void testDeleteSchedule() throws SQLException, ScheduleValueInvalidException, DAOException {

        ScheduleServiceLayer serviceOfSchedule = new ScheduleServiceLayer();

        boolean deleted = serviceOfSchedule.deleteSchedule(9, 78);

        Assertions.assertTrue(deleted);
    }

    
    
    
    
    /**
     * Test reading a list of schedules by artist ID.
     * @throws DAOexception 
     *
     */
    @Test
    void testReadingListOfScehdule() throws ScheduleValueInvalidException, DAOException {

        ScheduleServiceLayer serviceOfSchedule = new ScheduleServiceLayer();

        List<Schedule> schedules = serviceOfSchedule.getSchedulesByArtistId(13);

        Assertions.assertEquals(1, schedules.size());
        for (Schedule list : schedules) {

            System.out.println(list.getEventName());
        }
    }

}
