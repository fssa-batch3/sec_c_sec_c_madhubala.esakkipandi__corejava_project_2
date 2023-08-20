package com.fssa.glossyblends.artistservicelayer;

import com.fssa.glossyblends.customexception.DatabaseConnectionException;
import com.fssa.glossyblends.customexception.ServiceValueInvalidException;
import com.fssa.glossyblends.dao.ServiceProvidingDAO;
import com.fssa.glossyblends.model.Services;
import com.fssa.glossyblends.validator.ServiceValidations;

import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

public class ServiceProviding {

    // Add a new service
    public boolean addService(Services service) throws ServiceValueInvalidException, DatabaseConnectionException {
        try {
            if (ServiceValidations.validateService(service)) {
                return ServiceProvidingDAO.addService(service);
            } else {
                throw new ServiceValueInvalidException("Invalid service values");
            }
        } catch (ServiceValueInvalidException | SQLException e) {
            e.printStackTrace();
            return false; // Failed to add service
        } 
    }
    

    // Update an existing service
    public boolean updateService(Services service) throws ServiceValueInvalidException, DatabaseConnectionException {
        try {
            if (!ServiceValidations.validateService(service)) {
                return false; // Invalid service
            }

            ServiceProvidingDAO.updateService(service);
            return true; // Service updated successfully
        } catch (SQLException e) {
            e.printStackTrace();
            return false; // Failed to update service
        }
    }

    // Get services by artist ID
    public List<Services> getServicesByArtistId(int artistId) throws DatabaseConnectionException {
        try {
            return ServiceProvidingDAO.getServicesByArtistId(artistId);
        } catch (SQLException e) {
            e.printStackTrace();
            return Collections.emptyList(); // Failed to retrieve services
        }
    }

    // Get a specific service by ID and artist ID
    public Services getServiceById(int serviceId, int artistId) throws DatabaseConnectionException {
        try {
            return ServiceProvidingDAO.getServiceById(serviceId, artistId);
        } catch (SQLException e) {
            e.printStackTrace();
            return null; // Failed to retrieve service
        }
    }

    
    
    
    // Delete a service by ID and artist ID
    public boolean deleteServiceById(int artistId, int serviceId) throws DatabaseConnectionException {
        try {
            return ServiceProvidingDAO.deleteService(artistId, serviceId);
        } catch (SQLException e) {
            e.printStackTrace();
            return false; // Failed to delete service
        }
    }
}
