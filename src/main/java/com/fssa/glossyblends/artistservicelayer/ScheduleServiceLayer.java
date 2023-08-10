package com.fssa.glossyblends.artistservicelayer;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.List;

import com.fssa.glossyblends.dao.ScheduleDAO;

import com.fssa.glossyblends.model.Schedule;

import com.fssa.glossyblends.validator.ScheduleValidations;

public class ScheduleServiceLayer {



	public boolean addSchedule(Schedule listOfSchedule) throws IllegalArgumentException, SQLException {
		// Validate the schedule before adding
		if (ScheduleValidations.validateSchedule(listOfSchedule)) {
			LocalDateTime timeOfEvent = listOfSchedule.getTimeOfEvent();
			if (timeOfEvent != null) {
				return ScheduleDAO.addSchedule(listOfSchedule);
			}

		}
		return false;

	}

	public boolean deleteSchedule(int artistId, int id) throws SQLException {

		return ScheduleDAO.deleteSchedule(artistId, id);

	}

	public List<Schedule> getSchedulesByArtistId(int id) {

		return ScheduleDAO.getSchedulesByArtistId(id);

	}

}









