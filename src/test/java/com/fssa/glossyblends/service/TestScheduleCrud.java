package com.fssa.glossyblends.service;

import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.fssa.glossyblends.artistservicelayer.ScheduleServiceLayer;
import com.fssa.glossyblends.customexception.ScheduleValueInvalidException;
import com.fssa.glossyblends.model.Schedule;

/**
 * Unit tests for CRUD (Create, Read, Update, Delete) operations on schedules.
 */
class TestScheduleCrud {

    /**
     * Test adding a new schedule.
     *
     * @throws SQLException             if a SQL error occurs
     * @throws ScheduleValueInvalidException if the schedule value is invalid
     */
    @Test
    void testAddSchedule() throws  SQLException, ScheduleValueInvalidException {

        ScheduleServiceLayer serviceOfSchedule = new ScheduleServiceLayer();

        Schedule schedule = new Schedule();
        schedule.setArtistId(7);
        schedule.setDate(LocalDate.now());
        schedule.setEventName("Event in Chennai");
        schedule.setTimeOfEvent(LocalDateTime.now());

        boolean added = serviceOfSchedule.addSchedule(schedule);

        System.out.println(added);
        Assertions.assertTrue(added);
    }

    /**
     * Test deleting a schedule.
     *
     * @throws SQLException             if a SQL error occurs
     * @throws ScheduleValueInvalidException if the schedule value is invalid
     */
    @Test
    void testDeleteSchedule() throws SQLException, ScheduleValueInvalidException {

        ScheduleServiceLayer serviceOfSchedule = new ScheduleServiceLayer();

        boolean deleted = serviceOfSchedule.deleteSchedule(7, 53);

        Assertions.assertTrue(deleted);
    }

    /**
     * Test reading a list of schedules by artist ID.
     *
     * @throws ScheduleValueInvalidException if the schedule value is invalid
     */
    @Test
    void testReadingListOfScehdule() throws ScheduleValueInvalidException {

        ScheduleServiceLayer serviceOfSchedule = new ScheduleServiceLayer();

        List<Schedule> schedules = serviceOfSchedule.getSchedulesByArtistId(13);

        Assertions.assertEquals(1, schedules.size());
        for (Schedule list : schedules) {

            System.out.println(list.getEventName());
        }
    }

}
