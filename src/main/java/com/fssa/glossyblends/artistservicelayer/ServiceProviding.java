package com.fssa.glossyblends.artistservicelayer;

import com.fssa.glossyblends.customexception.ServiceValueInvalidException;
import com.fssa.glossyblends.dao.ServiceProvidingDAO;
import com.fssa.glossyblends.model.Services;
import com.fssa.glossyblends.validator.ServiceValidations;

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

 public boolean deleteServiceById(int artistId, int id) throws ServiceValueInvalidException {
	    boolean isDeleted = serviceProvidingDAO.deleteService(artistId, id);
	    return isDeleted;
	}

    
    
}
