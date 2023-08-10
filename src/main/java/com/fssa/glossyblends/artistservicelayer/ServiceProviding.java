package com.fssa.glossyblends.artistservicelayer;

import com.fssa.glossyblends.customexception.ServiceValueInvalidException;
import com.fssa.glossyblends.dao.ServiceProvidingDAO;
import com.fssa.glossyblends.model.Services;
import com.fssa.glossyblends.validator.ServiceValidations;

import java.sql.SQLException;
import java.util.List;

public class ServiceProviding {
    public boolean addService(Services service) {
        try {
            if (ServiceValidations.validateService(service)) {
                return ServiceProvidingDAO.addService(service);
            } else {
                throw new ServiceValueInvalidException("Invalid service values");
            }
        } catch (ServiceValueInvalidException e) {
            e.printStackTrace();
            return false;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean updateService(Services service) throws ServiceValueInvalidException {
        try {
            if (!ServiceValidations.validateService(service)) {
                return false;
            }

            ServiceProvidingDAO.updateService(service);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<Services> getServicesByArtistId(int id) {
        try {
            return ServiceProvidingDAO.getServicesByArtistId(id);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public Services getServiceById(int id, int artistId) {
        try {
            return ServiceProvidingDAO.getServiceById(id, artistId);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public boolean deleteServiceById(int artistId, int id) {
        try {
            return ServiceProvidingDAO.deleteService(artistId, id);
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
