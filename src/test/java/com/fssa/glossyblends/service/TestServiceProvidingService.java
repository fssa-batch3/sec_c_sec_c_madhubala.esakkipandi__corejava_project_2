package com.fssa.glossyblends.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.sql.SQLException;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.fssa.glossyblends.customexception.DAOException;
import com.fssa.glossyblends.customexception.ServiceValueInvalidException;
import com.fssa.glossyblends.model.ServiceCategory;
import com.fssa.glossyblends.model.Service;

/**
 * Unit tests for CRUD (Create, Read, Update, Delete) operations on services.
 */
class TestServiceProvidingService {

	/**
	 * Test adding a new service.
	 *
	 * @throws ServiceValueInvalidException if the service values are invalid.
	 * @throws DAOException                 if there's an issue with the DAO
	 *                                      operations.
	 * @throws SQLException                 if there's an issue with SQL operations.
	 */
	@Test
	void testAddService() throws ServiceValueInvalidException, DAOException, SQLException {

		ServiceProviding serviceProviding = new ServiceProviding();
		try {
			String email = "madhubala.esakkipandi@fssa.freshworks.com";
			Service service = new Service();
			service.setCategory(ServiceCategory.HAIR_STYLE);
			service.setCost(1000);
			service.setName("curlingHairstyle");
			service.setSampleImage("https://iili.io/HyPuMns.jpg");
			boolean added = serviceProviding.addService(email, service);
			assertTrue(added, "Service  has been added successfully.");
		} catch (ServiceValueInvalidException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());

		}
	}

	/**
	 * Test getting services by artist ID.
	 * 
	 * @throws DAOexception
	 */
	@Test
	void testGetServicesByArtistId() throws DAOException {
		ServiceProviding serviceProviding = new ServiceProviding();
		List<Service> serviceList = serviceProviding.getServicesByArtistId(6);

		for (Service service : serviceList) {
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

			Service updatedService = serviceProviding.getServiceById(51, 6);

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
	 * @throws ServiceValueInvalidException if the service values are invalid.
	 * @throws DAOException                 if there's an issue with the DAO
	 *                                      operations.
	 */
	@Test
	void testDeleteService() throws ServiceValueInvalidException, DAOException {
		ServiceProviding serviceProviding = new ServiceProviding();

		boolean deleted = serviceProviding.deleteServiceById(6, 16);

		Assertions.assertTrue(deleted);
	}

	/**
	 * Test updating a service with invalid values.
	 *
	 * @throws DAOException if there's an issue with the DAO operations.
	 */
	@Test
	void testUpdateServiceWithInvalidValues() throws DAOException {

		ServiceProviding serviceProviding = new ServiceProviding();

		Service invalidService = new Service();
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
