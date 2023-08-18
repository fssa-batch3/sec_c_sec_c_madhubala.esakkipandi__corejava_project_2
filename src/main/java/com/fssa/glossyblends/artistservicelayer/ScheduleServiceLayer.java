package com.fssa.glossyblends.artistservicelayer;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.List;

import com.fssa.glossyblends.customexception.DatabaseConnectionException;
import com.fssa.glossyblends.customexception.ScheduleValueInvalidException;
import com.fssa.glossyblends.dao.ScheduleDAO;

import com.fssa.glossyblends.model.Schedule;

import com.fssa.glossyblends.validator.ScheduleValidations;

public class ScheduleServiceLayer {

	public boolean addSchedule(Schedule listOfSchedule) throws SQLException, ScheduleValueInvalidException, DatabaseConnectionException {
		// Validate the schedule before adding
		if (ScheduleValidations.validateSchedule(listOfSchedule)) {
			LocalDateTime timeOfEvent = listOfSchedule.getTimeOfEvent();
			if (timeOfEvent != null) {
				return ScheduleDAO.addSchedule(listOfSchedule);
			}

			
		}
		return false;

	}

	// delete the schdule using te artist id and Schedule id
	public boolean deleteSchedule(int artistId, int id) throws SQLException, DatabaseConnectionException {

		return ScheduleDAO.deleteSchedule(artistId, id);

	}

	// get the list of schdule using the id of particular artist
	public List<Schedule> getSchedulesByArtistId(int id) throws DatabaseConnectionException {

		return ScheduleDAO.getSchedulesByArtistId(id);

	}

}
