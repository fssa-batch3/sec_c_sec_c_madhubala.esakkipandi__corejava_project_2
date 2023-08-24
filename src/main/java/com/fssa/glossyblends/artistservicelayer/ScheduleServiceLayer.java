package com.fssa.glossyblends.artistservicelayer;

import java.sql.SQLException;
import java.util.List;

import com.fssa.glossyblends.customexception.ArtistDetailsExceptions;
import com.fssa.glossyblends.customexception.DAOException;
import com.fssa.glossyblends.customexception.ScheduleValueInvalidException;
import com.fssa.glossyblends.dao.ScheduleDAO;
import com.fssa.glossyblends.model.Schedule;
import com.fssa.glossyblends.validator.ScheduleValidations;

public class ScheduleServiceLayer {

	public boolean addSchedule(String email, Schedule schedule) throws SQLException, DAOException, ScheduleValueInvalidException, ArtistDetailsExceptions {
	   
		  if (ScheduleValidations.validateSchedule(schedule)) {
	    return ScheduleDAO.addSchedule(email, schedule);
		  }
		return false;
	}



	// delete the schdule using te artist id and Schedule id
	public boolean deleteSchedule(int artistId, int id) throws SQLException, DAOException {

		return ScheduleDAO.deleteSchedule(artistId, id);

	}

	// get the list of schdule using the id of particular artist
	public List<Schedule> getSchedulesByArtistId(int id) throws DAOException {

		return ScheduleDAO.getSchedulesByArtistId(id);

	}

}
