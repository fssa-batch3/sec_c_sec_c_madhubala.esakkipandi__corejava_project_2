package com.fssa.glossyblends.artistservicelayer;

import java.time.LocalDateTime;
import java.util.List;

import com.fssa.glossyblends.dao.ScheduleDAO;

import com.fssa.glossyblends.model.Schedule;

import com.fssa.glossyblends.validator.ScheduleValidations;

public class ScheduleServiceLayer {

	private ScheduleDAO scheduleDAO;

	public ScheduleServiceLayer(ScheduleDAO scheduleDAO) {
this.scheduleDAO=scheduleDAO;
}

	public boolean addSchedule(Schedule listOfSchedule) {
		// Validate the schedule before adding
		if (ScheduleValidations.validateSchedule(listOfSchedule)) {
			LocalDateTime timeOfEvent = listOfSchedule.getTimeOfEvent();
			if (timeOfEvent != null) {
				return scheduleDAO.addSchedule(listOfSchedule);
			}

		}
		return false;

	}

	public boolean deleteSchedule(int artistId, int id) {

		return scheduleDAO.deleteSchedule(artistId, id);

	}

	public List<Schedule> getSchedulesByArtistId(int id) {

		return scheduleDAO.getSchedulesByArtistId(id);

	}

}









