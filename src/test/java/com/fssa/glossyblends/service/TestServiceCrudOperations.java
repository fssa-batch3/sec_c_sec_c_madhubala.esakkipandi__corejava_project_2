package com.fssa.glossyblends.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.fssa.glossyblends.artistservicelayer.ServiceProviding;
import com.fssa.glossyblends.customexception.DatabaseConnectionException;
import com.fssa.glossyblends.customexception.ServiceValueInvalidException;
import com.fssa.glossyblends.model.ServiceCategory;
import com.fssa.glossyblends.model.Services;

/**
 * Unit tests for CRUD (Create, Read, Update, Delete) operations on services.
 */
class TestServiceCrudOperations {

	/**
	 * Test adding a new service.
	 * @throws DatabaseConnectionException 
	 *
	 */
	@Test
	void testAddService() throws ServiceValueInvalidException, DatabaseConnectionException {
		ServiceProviding serviceProviding = new ServiceProviding();

		Services service = new Services();
		service.setArtistId(9);
		service.setCategory(ServiceCategory.HAIR_STYLE);
		service.setCost(90000);
		service.setName("Haircutting");
		service.setSampleImage("https://example.com/haircut.jpg");

		boolean added = serviceProviding.addService(service);

		assertTrue(added, "Service should have been added successfully.");
	}

	/**
	 * Test getting services by artist ID.
	 * @throws DatabaseConnectionException 
	 */
	@Test
	void testGetServicesByArtistId() throws DatabaseConnectionException {
		ServiceProviding serviceProviding = new ServiceProviding();
		List<Services> serviceList = serviceProviding.getServicesByArtistId(12);

		for (Services service : serviceList) {
			System.out.println(service.getCategory());
		}

		assertEquals(1, serviceList.size(), "Size should match.");
	}

	/**
	 * Test updating an existing service.
	 * @throws DatabaseConnectionException 
	 */
	@Test
	void testUpdateService() throws DatabaseConnectionException {
		try {
			ServiceProviding serviceProviding = new ServiceProviding();

			Services serviceToUpdate = serviceProviding.getServiceById(3, 12);

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
	 * @throws DatabaseConnectionException 
	 *
	 */
	@Test
	void testDeleteService() throws ServiceValueInvalidException, DatabaseConnectionException {
		ServiceProviding serviceProviding = new ServiceProviding();

		boolean deleted = serviceProviding.deleteServiceById(9, 68);

		Assertions.assertTrue(deleted);
	}

	/**
	 * Test updating a service with invalid values.
	 * @throws DatabaseConnectionException 
	 */
	@Test
	void testUpdateServiceWithInvalidValues() throws DatabaseConnectionException {

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
