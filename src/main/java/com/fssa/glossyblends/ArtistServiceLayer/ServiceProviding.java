package com.fssa.glossyblends.ArtistServiceLayer;

import com.fssa.glossyblends.CustomException.ServiceValueInvalidException;
import com.fssa.glossyblends.DAO.ServiceProvidingDAO;
import com.fssa.glossyblends.Validator.ServiceValidations; // Import the ServiceValidations class
import com.fssa.glossyblends.model.Services;

import java.util.List;

public class ServiceProviding {
    private ServiceProvidingDAO serviceProvidingDAO;

    public ServiceProviding(ServiceProvidingDAO serviceProvidingDAO) {
        this.serviceProvidingDAO = serviceProvidingDAO;
    }


    public boolean addService(Services service) throws ServiceValueInvalidException {
        if (ServiceValidations.validateService(service)) {
            return serviceProvidingDAO.addService(service);
        } else {
            throw new ServiceValueInvalidException("Invalid service values");
        }
    }
    
    
    public boolean updateService(Services service) throws ServiceValueInvalidException {
        // Validate the service before updating
        if (!ServiceValidations.validateService(service)) {
        	return false;
        }
        
        serviceProvidingDAO.updateService(service);
        return true;
    }
    
    
    public List<Services> getServicesByArtistId(int id)throws ServiceValueInvalidException{
    	
    	
		return serviceProvidingDAO.getServicesByArtistId(id);
    	
    	
    }
    

 public Services getServiceById(int id,int artistId)throws ServiceValueInvalidException{
    	
    	System.out.println("sdf");
		return serviceProvidingDAO.getServiceById(id, artistId);
    	
    	
    }


 public boolean deleteServiceById(int id, int artistId) throws ServiceValueInvalidException {
	    if ( serviceProvidingDAO.deleteService(artistId, id)) {
	        return true; // Return true if service was deleted
	    }
	    return false; 
	}

    
    
}
