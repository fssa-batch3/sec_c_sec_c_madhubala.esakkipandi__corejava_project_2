package com.fssa.glossyblends.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.ArrayList;
import java.sql.ResultSet;

import com.fssa.glossyblends.customexception.DAOException;
import com.fssa.glossyblends.model.Schedule;
import com.fssa.glossyblends.util.ConnectionUtil;

/**
 * Data Access Object (DAO) for managing schedule data in the database.
 */

public class ScheduleDAO {

	private ScheduleDAO() {
		// Private constructor to prevent instantiation
	}

	// Add a new schedule to the database
	/**
	 * Adds a schedule for an artist with the provided email.
	 *
	 * @param email          The email of the artist.
	 * @param listOfSchedule The schedule to be added.
	 * @return True if the schedule was successfully added, otherwise false.
	 * @throws SQLException If an SQL exception occurs during database interaction.
	 * @throws DAOException If an exception specific to the data access layer
	 *                      occurs.
	 */
	public static boolean addSchedule(String email, Schedule listOfSchedule) throws SQLException, DAOException {
		String query = "INSERT INTO artist_schedule (artist_id, event_date, event_name, event_time) VALUES (?, ?, ?, ?)";

		int artistId = PostDAO.getIdByArtistEmail(email);

		try (Connection connection = ConnectionUtil.getConnection()) {
			try (PreparedStatement smt = connection.prepareStatement(query)) {
				smt.setInt(1, artistId);

				LocalDate eventDate = listOfSchedule.getDate();

				smt.setDate(2, java.sql.Date.valueOf(eventDate));
				LocalDateTime timeOfEvent = listOfSchedule.getTimeOfEvent();
				Timestamp sqlTimestampOfEvent = Timestamp.valueOf(timeOfEvent);
				smt.setTimestamp(4, sqlTimestampOfEvent);
				smt.setString(3, listOfSchedule.getEventName());

				int rowsAffected = smt.executeUpdate();

				return rowsAffected > 0;
			}
		} catch (SQLException e) {
			throw new DAOException("Error adding schedule to the database.", e);
		}
	}

	/**
	 * Deletes a schedule with the specified artist ID and schedule ID.
	 *
	 * @param artistId The ID of the artist.
	 * @param id       The ID of the schedule.
	 * @return True if the schedule was successfully deleted, otherwise false.
	 * @throws SQLException If an SQL exception occurs during database interaction.
	 * @throws DAOException If an exception specific to the data access layer
	 *                      occurs.
	 */
	public static boolean deleteSchedule(int artistId, int id) throws SQLException, DAOException {
		String query = "DELETE FROM artist_schedule WHERE artist_id = ? AND id = ?";

		try (Connection connection = ConnectionUtil.getConnection()) {
			try (PreparedStatement smt = connection.prepareStatement(query)) {
				smt.setInt(1, artistId);
				smt.setInt(2, id);

				int rowsAffected = smt.executeUpdate();

				return rowsAffected > 0;
			}
		} catch (SQLException e) {
			throw new DAOException("Error deleting schedule from the database.", e);
		}
	}

	/**
	 * Retrieves a list of schedules associated with the artist ID.
	 *
	 * @param artistId The ID of the artist.
	 * @return A list of schedules associated with the artist.
	 * @throws DAOException If an exception specific to the data access layer
	 *                      occurs.
	 */
	public static List<Schedule> getSchedulesByArtistId(int artistId) throws DAOException {
		List<Schedule> schedulesList = new ArrayList<>();

		String query = "SELECT * FROM artist_schedule WHERE artist_id = ?";

		try (Connection connection = ConnectionUtil.getConnection()) {
			try (PreparedStatement smt = connection.prepareStatement(query)) {
				smt.setInt(1, artistId);

				try (ResultSet rs = smt.executeQuery()) {
					while (rs.next()) {
						Schedule schedule = new Schedule();
						schedule.setArtistId(rs.getInt("artist_id"));
						schedule.setEventName(rs.getString("event_name"));
						LocalDate eventDate = rs.getDate("event_date").toLocalDate();
						schedule.setDate(eventDate);
						LocalDateTime eventTime = rs.getTimestamp("event_time").toLocalDateTime();
						schedule.setTimeOfEvent(eventTime);
						schedulesList.add(schedule);
					}
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return schedulesList;
	}

}
