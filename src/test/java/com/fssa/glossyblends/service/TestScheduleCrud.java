package com.fssa.glossyblends.service;

import java.sql.Connection;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.fssa.glossyblends.ArtistServiceLayer.ScheduleServiceLayer;
import com.fssa.glossyblends.DAO.ScheduleDAO;
import com.fssa.glossyblends.model.schedule;
import com.fssa.glossyblends.util.ConnectionUtil;

public class TestScheduleCrud {

	@Test
	public void testAddSchedule() {

		Connection connection = ConnectionUtil.getConnection();
		ScheduleDAO scheduleDao = new ScheduleDAO(connection);

		ScheduleServiceLayer serviceOfSchedule = new ScheduleServiceLayer(scheduleDao);

		schedule Schedule = new schedule();
		Schedule.setArtistId(7);
		Schedule.setDate(LocalDate.now());
		Schedule.setEventName("Event in chennai");
		Schedule.setTimeOfEvent(LocalDateTime.now());

		boolean added = serviceOfSchedule.addSchedule(Schedule);

		System.out.println(added);
		Assertions.assertTrue(added);
	}

	@Test
	public void testDeleteSchedule() {

		Connection connection = ConnectionUtil.getConnection();
		ScheduleDAO scheduleDao = new ScheduleDAO(connection);

		ScheduleServiceLayer serviceOfSchedule = new ScheduleServiceLayer(scheduleDao);

		boolean deleted = serviceOfSchedule.deleteSchedule(7, 17);

		Assertions.assertTrue(deleted);

	}
	
	
	
	@Test
	public void testReadingListOfScehdule() {
		
		Connection connection = ConnectionUtil.getConnection();
		ScheduleDAO scheduleDao = new ScheduleDAO(connection);

		ScheduleServiceLayer serviceOfSchedule = new ScheduleServiceLayer(scheduleDao);

		
		
		List<schedule> schedules=serviceOfSchedule.getSchedulesByArtistId(13);
		
		Assertions.assertEquals(1,schedules.size());
		for(schedule list:schedules) {
			
			System.out.println(list.getEventName());
		}
	}
	
	
	
	

}
