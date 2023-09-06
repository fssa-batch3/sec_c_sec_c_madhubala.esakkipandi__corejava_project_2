package com.fssa.glossyblends.service;

import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.fssa.glossyblends.customexception.ArtistDetailsExceptions;
import com.fssa.glossyblends.customexception.DAOException;
import com.fssa.glossyblends.customexception.ScheduleValueInvalidException;
import com.fssa.glossyblends.model.Schedule;

/**
 * Unit tests for CRUD (Create, Read, Update, Delete) operations on schedules.
 */
class TestScheduleService {

	/**
	 * Test adding a new schedule.
	 * 
	 * @throws ScheduleValueInvalidException if the schedule values are invalid.
	 * @throws ArtistDetailsExceptions       if there's an issue with artist
	 *                                       details.
	 * @throws DAOException                  if there's an issue with the DAO
	 *                                       operations.
	 * @throws SQLException                  if there's an issue with SQL
	 *                                       operations.
	 */

	@Test
	void testAddSchedule() throws SQLException, DAOException, ScheduleValueInvalidException, ArtistDetailsExceptions {
		Schedule schedule = new Schedule();

		try {
			schedule.setDate(LocalDate.of(2023, 10, 28));
			schedule.setTimeOfEvent(LocalDateTime.of(2023, 10, 28, 15, 30));
			schedule.setEventName("Samplevent");
			String artistEmail = "swethakarthika16@gmail.com";
			ScheduleService service = new ScheduleService();
			boolean added = service.addSchedule(artistEmail, schedule);
			Assertions.assertTrue(added);
		} catch (ScheduleValueInvalidException | DAOException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}

	}

	
	/**
	 * Test deleting a schedule.
	 * 
	 * @throws ScheduleValueInvalidException if the schedule values are invalid.
	 * @throws DAOException                  if there's an issue with the DAO
	 *                                       operations.
	 * @throws SQLException                  if there's an issue with SQL
	 *                                       operations.
	 */

	@Test
	void testDeleteSchedule() throws SQLException, ScheduleValueInvalidException, DAOException {

		ScheduleService serviceOfSchedule = new ScheduleService();

		boolean deleted = serviceOfSchedule.deleteSchedule(18, 10);

		Assertions.assertTrue(deleted);
	}

	/**
	 * Test reading a list of schedules by artist ID.
	 * 
	 * @throws ScheduleValueInvalidException if the schedule values are invalid.
	 * @throws DAOException                  if there's an issue with the DAO
	 *                                       operations.
	 */
	@Test
	void testReadingListOfScehdule() throws ScheduleValueInvalidException, DAOException {

		ScheduleService serviceOfSchedule = new ScheduleService();

		List<Schedule> schedules = serviceOfSchedule.getSchedulesByArtistId(18);

		Assertions.assertEquals(1, schedules.size());
		for (Schedule list : schedules) {

			System.out.println(list.getEventName());
		}
	}

}
