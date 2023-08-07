package com.fssa.glossyblends.ServiceTestCase;

import Connection.ConnectionUtil;
import com.fssa.glossyblends.DAO.*;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.sql.Connection;
import java.util.List;

import com.fssa.glossyblends.model.Artist.*;
import com.fssa.glossyblends.ArtistServiceLayer.*;
import com.fssa.glossyblends.CustomException.ServiceValueInvalidException;

public class TestServiceCrudOperations {

    @Test
    public void testAddService() {
        try {
            Connection connection = ConnectionUtil.getConnection();

            ServiceProvidingDAO serviceDAO = new ServiceProvidingDAO(connection);
            ServiceProviding serviceProviding = new ServiceProviding(serviceDAO);

            Services service = new Services();
            service.setArtistId(4);
            service.setCategory(ServiceCategory.HAIR_STYLE);
            service.setCost(90000);
            service.setName("Haircuting");
            service.setSampleImage("https://example.com/haircut.jpg");

            boolean added = serviceProviding.addService(service);

            assertTrue(added, "Service should have been added successfully.");

        } catch (ServiceValueInvalidException ex) {
            fail("Exception should not have been thrown: " + ex.getMessage());
        }
    }

    @Test
    public void testGetServicesByArtistId() {
        try {
            Connection connection = ConnectionUtil.getConnection();

            ServiceProvidingDAO serviceDAO = new ServiceProvidingDAO(connection);
            ServiceProviding serviceProviding = new ServiceProviding(serviceDAO);
            List<Services> service = serviceProviding.getServicesByArtistId(2);

            for (Services ser : service) {
                System.out.println(ser.getCategory());
            }

            assertEquals(25, service.size(), "Size should match.");

        } catch (ServiceValueInvalidException ex) {
            ex.getMessage();
        }
    }

    @Test
    public void testUpdateService() {
        try {
            Connection connection = ConnectionUtil.getConnection();
            ServiceProvidingDAO serviceDAO = new ServiceProvidingDAO(connection);
            ServiceProviding serviceProviding = new ServiceProviding(serviceDAO);

            Services serviceToUpdate = serviceProviding.getServiceById(91, 4);

            System.out.println("before" + serviceToUpdate.getCost());

            Services updatedService = serviceProviding.getServiceById(91, 4);
            updatedService.setCost(45678);
            boolean updated2 = serviceProviding.updateService(updatedService);

            assertTrue(updated2);

            if (updated2) {
                System.out.println("after" + updatedService.getCost());
            }

            assertEquals(45678, updatedService.getCost(), "Service cost not updated.");

        } catch (ServiceValueInvalidException ex) {
            ex.printStackTrace();
        }
    }

    @Test
    public void testDeleteService() throws ServiceValueInvalidException {
        Connection connection = ConnectionUtil.getConnection();
        ServiceProvidingDAO serviceDAO = new ServiceProvidingDAO(connection);
        ServiceProviding serviceProviding = new ServiceProviding(serviceDAO);

        boolean deleted = serviceProviding.deleteServiceById(99, 4);

        if (deleted) {
            System.out.println("Deleted");
        } else {
            System.out.println("Not deleted");
        }
    }

    @Test
    public void testUpdateServiceWithInvalidValues() {
        Connection connection = ConnectionUtil.getConnection();

        ServiceProvidingDAO serviceDAO = new ServiceProvidingDAO(connection);
        ServiceProviding serviceProviding = new ServiceProviding(serviceDAO);

        Services invalidService = new Services();
        invalidService.setId(91);
        invalidService.setArtistId(4);
        invalidService.setName(null);
        invalidService.setCost(-1);

        try {
            serviceProviding.updateService(invalidService);
        } catch (ServiceValueInvalidException e) {
            System.out.println(e.getMessage());
        }
    }
}
