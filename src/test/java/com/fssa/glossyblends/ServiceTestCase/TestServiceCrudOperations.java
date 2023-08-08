package com.fssa.glossyblends.ServiceTestCase;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.sql.Connection;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.fssa.glossyblends.ArtistServiceLayer.ServiceProviding;
import com.fssa.glossyblends.CustomException.ServiceValueInvalidException;
import com.fssa.glossyblends.DAO.ServiceProvidingDAO;
import com.fssa.glossyblends.model.ServiceCategory;
import com.fssa.glossyblends.model.Services;
import com.fssa.glossyblends.util.ConnectionUtil;

public class TestServiceCrudOperations {

    @Test
    public void testAddService() {
        try {
            Connection connection = ConnectionUtil.getConnection();

            ServiceProvidingDAO serviceDAO = new ServiceProvidingDAO(connection);
            ServiceProviding serviceProviding = new ServiceProviding(serviceDAO);

            Services service = new Services();
            service.setArtistId(9);
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
            List<Services> service = serviceProviding.getServicesByArtistId(12);

            for (Services ser : service) {
                System.out.println(ser.getCategory());
            }

            assertEquals(1, service.size(), "Size should match.");

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

            Services serviceToUpdate = serviceProviding.getServiceById(3, 12);

            System.out.println("before" + serviceToUpdate.getCost());

            Services updatedService = serviceProviding.getServiceById(2, 2);
            updatedService.setCost(10000);
            boolean updated2 = serviceProviding.updateService(updatedService);

            assertTrue(updated2);

            if (updated2) {
                System.out.println("after" + updatedService.getCost());
            }

            assertEquals(10000, updatedService.getCost(), "Service cost not updated.");

        } catch (ServiceValueInvalidException ex) {
            ex.printStackTrace();
        }
    }

    @Test
    public void testDeleteService() throws ServiceValueInvalidException {
        Connection connection = ConnectionUtil.getConnection();
        ServiceProvidingDAO serviceDAO = new ServiceProvidingDAO(connection);
        ServiceProviding serviceProviding = new ServiceProviding(serviceDAO);

        boolean deleted = serviceProviding.deleteServiceById(4, 13);

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
