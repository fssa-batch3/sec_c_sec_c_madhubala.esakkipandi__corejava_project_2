package com.fssa.glossyblends.ArtistServiceLayer;

import com.fssa.glossyblends.CustomException.ServiceValueInvalidException;
import com.fssa.glossyblends.DAO.ServiceProvidingDAO;
import com.fssa.glossyblends.model.Artist.Services;
import com.fssa.glossyblends.Validator.ServiceValidations; // Import the ServiceValidations class

import java.util.List;

public class ServiceProviding {
    private ServiceProvidingDAO serviceProvidingDAO;

    public ServiceProviding(ServiceProvidingDAO serviceProvidingDAO) {
        this.serviceProvidingDAO = serviceProvidingDAO;
    }

    public boolean addService(Services service) throws ServiceValueInvalidException {
        // Validate the service before adding
        if (ServiceValidations.validateService(service)) {
            return serviceProvidingDAO.addService(service);
        }
        
        return false;
    }
    
    
    public boolean updateService(Services service) throws ServiceValueInvalidException {
        // Validate the service before updating
        if (ServiceValidations.validateService(service)) {
            return serviceProvidingDAO.updateService(service);
        }
        return false;
    }
    
    
    
    

    
    
    
}
