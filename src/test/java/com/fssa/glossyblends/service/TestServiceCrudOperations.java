package com.fssa.glossyblends.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.sql.Connection;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.fssa.glossyblends.artistservicelayer.ServiceProviding;
import com.fssa.glossyblends.customexception.ServiceValueInvalidException;
import com.fssa.glossyblends.dao.ServiceProvidingDAO;
import com.fssa.glossyblends.model.ServiceCategory;
import com.fssa.glossyblends.model.Services;
import com.fssa.glossyblends.util.ConnectionUtil;

 class TestServiceCrudOperations {

    @Test
     void testAddService() {
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
     void testGetServicesByArtistId() {
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
     void testUpdateService() {
        try {
            Connection connection = ConnectionUtil.getConnection();
            ServiceProvidingDAO serviceDAO = new ServiceProvidingDAO(connection);
            ServiceProviding serviceProviding = new ServiceProviding(serviceDAO);

            Services serviceToUpdate = serviceProviding.getServiceById(3, 12);

            System.out.println("before" + serviceToUpdate.getCost());

            Services updatedService = serviceProviding.getServiceById(3, 12);
            
            
            updatedService.setCost(10000);
            boolean updated2 = serviceProviding.updateService(updatedService);

            Assertions.assertTrue(updated2);

            if (updated2) {
                System.out.println("after" + updatedService.getCost()+"updated");
            }

            assertEquals(10000, updatedService.getCost(), "Service cost not updated.");

        } catch (ServiceValueInvalidException ex) {
            ex.printStackTrace();
        }
    }

    @Test
     void testDeleteService() throws ServiceValueInvalidException {
        Connection connection = ConnectionUtil.getConnection();
        ServiceProvidingDAO serviceDAO = new ServiceProvidingDAO(connection);
        ServiceProviding serviceProviding = new ServiceProviding(serviceDAO);

        boolean deleted = serviceProviding.deleteServiceById(9,33);

        
        Assertions.assertTrue(deleted);
        if (deleted) {
            System.out.println("Deleted");
        } else {
            System.out.println("Not deleted");
        }
    }

    
    
    
    @Test
     void testUpdateServiceWithInvalidValues() {
        Connection connection = ConnectionUtil.getConnection();

        ServiceProvidingDAO serviceDAO = new ServiceProvidingDAO(connection);
        ServiceProviding serviceProviding = new ServiceProviding(serviceDAO);

        Services invalidService = new Services();
        invalidService.setId(91);
        invalidService.setArtistId(4);
        invalidService.setName(null);
        invalidService.setCost(-1);

        
        
        
        try {
          boolean updated  =serviceProviding.updateService(invalidService);
            

            Assertions.assertFalse(updated);
        } catch (ServiceValueInvalidException e) {
            System.out.println(e.getMessage());
        }
        
        
        
    }
    
    
    
}
