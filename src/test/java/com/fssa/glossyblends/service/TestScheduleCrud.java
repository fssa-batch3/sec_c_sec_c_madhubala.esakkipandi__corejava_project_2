package com.fssa.glossyblends.service;

import java.sql.Connection;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.fssa.glossyblends.artistservicelayer.ScheduleServiceLayer;
import com.fssa.glossyblends.dao.ScheduleDAO;
import com.fssa.glossyblends.model.Schedule;
import com.fssa.glossyblends.util.ConnectionUtil;

 class TestScheduleCrud {

	@Test
	 void testAddSchedule() {

		Connection connection = ConnectionUtil.getConnection();
		ScheduleDAO scheduleDao = new ScheduleDAO(connection);

		ScheduleServiceLayer serviceOfSchedule = new ScheduleServiceLayer(scheduleDao);

		Schedule Schedule = new Schedule();
		Schedule.setArtistId(7);
		Schedule.setDate(LocalDate.now());
		Schedule.setEventName("Event in chennai");
		Schedule.setTimeOfEvent(LocalDateTime.now());

		boolean added = serviceOfSchedule.addSchedule(Schedule);

		System.out.println(added);
		Assertions.assertTrue(added);
	}

	@Test
	 void testDeleteSchedule() {

		Connection connection = ConnectionUtil.getConnection();
		ScheduleDAO scheduleDao = new ScheduleDAO(connection);

		ScheduleServiceLayer serviceOfSchedule = new ScheduleServiceLayer(scheduleDao);

		boolean deleted = serviceOfSchedule.deleteSchedule(7, 27);

		Assertions.assertTrue(deleted);

	}
	
	
	
	@Test
	 void testReadingListOfScehdule() {
		
		Connection connection = ConnectionUtil.getConnection();
		ScheduleDAO scheduleDao = new ScheduleDAO(connection);

		ScheduleServiceLayer serviceOfSchedule = new ScheduleServiceLayer(scheduleDao);

		
		
		List<Schedule> schedules=serviceOfSchedule.getSchedulesByArtistId(13);
		
		Assertions.assertEquals(1,schedules.size());
		for(Schedule list:schedules) {
			
			System.out.println(list.getEventName());
		}
	}
	
	
	
	

}
