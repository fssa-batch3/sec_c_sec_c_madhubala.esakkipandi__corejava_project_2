package com.fssa.glossyblends.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.sql.SQLException;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.fssa.glossyblends.artistservicelayer.ServiceProviding;
import com.fssa.glossyblends.customexception.DAOException;
import com.fssa.glossyblends.customexception.ServiceValueInvalidException;
import com.fssa.glossyblends.model.ServiceCategory;
import com.fssa.glossyblends.model.Services;
import com.fssa.glossyblends.model.*;

/**
 * Unit tests for CRUD (Create, Read, Update, Delete) operations on services.
 */
class TestServiceCrudOperations {

	/**
	 * Test adding a new service.
	 * 
	 * @throws DAOException
	 * @throws SQLException
	 *
	 */
	@Test
	void testAddService() throws ServiceValueInvalidException, DAOException, SQLException {
		ServiceProviding serviceProviding = new ServiceProviding();
		String email="esakipandi@gmail.com";
		Services service = new Services();
		service.setCategory(ServiceCategory.HAIR_STYLE);
		service.setCost(90000);
		service.setName("Haircutting");
		service.setSampleImage("https://example.com/haircut.jpg");

		boolean added = serviceProviding.addService(email, service);

		assertTrue(added, "Service should have been added successfully.");
	}

	
	/**
	 * Test getting services by artist ID.
	 * 
	 * @throws DAOexception
	 */
	@Test
	void testGetServicesByArtistId() throws DAOException {
		ServiceProviding serviceProviding = new ServiceProviding();
		List<Services> serviceList = serviceProviding.getServicesByArtistId(12);

		for (Services service : serviceList) {
			System.out.println(service.getCategory());
		}

		assertEquals(1, serviceList.size(), "Size should match.");
	}

	/**
	 * Test updating an existing service.
	 * 
	 * @throws DAOexception
	 */
	@Test
	void testUpdateService() throws DAOException {
		try {
			ServiceProviding serviceProviding = new ServiceProviding();


			Services updatedService = serviceProviding.getServiceById(3, 12);

			updatedService.setCost(10000);
			boolean updated = serviceProviding.updateService(updatedService);

			Assertions.assertTrue(updated);

			assertEquals(10000, updatedService.getCost(), "Service cost not updated.");

		} catch (ServiceValueInvalidException ex) {
			ex.printStackTrace();
		}
	}

	/**
	 * Test deleting a service.
	 * 
	 * @throws DAOexception
	 *
	 */
	@Test
	void testDeleteService() throws ServiceValueInvalidException, DAOException {
		ServiceProviding serviceProviding = new ServiceProviding();

		boolean deleted = serviceProviding.deleteServiceById(9, 71);

		Assertions.assertTrue(deleted);
	}

	/**
	 * Test updating a service with invalid values.
	 * 
	 * @throws DAOexception
	 */
	@Test
	void testUpdateServiceWithInvalidValues() throws DAOException {

		ServiceProviding serviceProviding = new ServiceProviding();

		Services invalidService = new Services();
		invalidService.setId(91);
		invalidService.setArtistId(4);
		invalidService.setName(null);
		invalidService.setCost(-1);

		try {
			boolean updated = serviceProviding.updateService(invalidService);

			Assertions.assertFalse(updated);
		} catch (ServiceValueInvalidException e) {
			e.getMessage();
		}

	}
}
