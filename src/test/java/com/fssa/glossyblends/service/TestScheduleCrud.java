
package com.fssa.glossyblends.service;

import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.fssa.glossyblends.artistservicelayer.ScheduleServiceLayer;
import com.fssa.glossyblends.model.Schedule;

 class TestScheduleCrud {

	@Test
	 void testAddSchedule() throws IllegalArgumentException, SQLException {

		
		ScheduleServiceLayer serviceOfSchedule = new ScheduleServiceLayer();

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
	 void testDeleteSchedule() throws SQLException {

		ScheduleServiceLayer serviceOfSchedule = new ScheduleServiceLayer();

		boolean deleted = serviceOfSchedule.deleteSchedule(7, 48);

		Assertions.assertTrue(deleted);

	}
	
	
	
	@Test
	 void testReadingListOfScehdule() {
		
	

		ScheduleServiceLayer serviceOfSchedule = new ScheduleServiceLayer();

		
		
		List<Schedule> schedules=serviceOfSchedule.getSchedulesByArtistId(13);
		
		Assertions.assertEquals(1,schedules.size());
		for(Schedule list:schedules) {
			
			System.out.println(list.getEventName());
		}
	}
	
	
	
	

}
