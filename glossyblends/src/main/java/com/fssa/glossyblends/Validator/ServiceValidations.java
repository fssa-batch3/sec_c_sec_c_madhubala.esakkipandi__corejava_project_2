package com.fssa.glossyblends.Validator;
 
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.fssa.glossyblends.CustomException.ServiceValueInvalidException;
import com.fssa.glossyblends.model.Artist.ErrorMessages;
import com.fssa.glossyblends.model.Artist.ServiceCategory;
import com.fssa.glossyblends.model.Artist.Services;


public class ServiceValidations {
	

    public static boolean validateService(Services service) throws ServiceValueInvalidException {
        if (service == null) {
            throw new ServiceValueInvalidException(ErrorMessages.INVALID_SERVICE_OBJECT_NULL);
        } 
        else {
            validateCategory(service.getCategory());
            validateServiceName(service.getName());
            validatePrice(service.getCost());
            validateServiceImageUrl(service.getSampleImage());
        }
            return true;
    }

    private static boolean validateCategory(ServiceCategory category) throws ServiceValueInvalidException {
        if (category == null) {
            throw new ServiceValueInvalidException();
        }
        return true;
    }

    private static boolean validateServiceName(String serviceName) throws ServiceValueInvalidException {
        if (serviceName == null) {
            throw new ServiceValueInvalidException(ErrorMessages.INVALID_SERVICE_NAME_NULL);
        }

        
        String regex = "^[a-zA-Z]+$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(serviceName);
        boolean isValid = matcher.matches();

        if (!isValid) {
            throw new ServiceValueInvalidException(ErrorMessages.INVALID_SERVICE_NAME_PATTERN);
        }
        return true;

    }

    private static boolean validatePrice(double price) throws IllegalArgumentException {
    	
        if (price < 0) {
            throw new IllegalArgumentException(ErrorMessages.INVALID_SERVICE_PRICE_NULL);
        }
        return true;
    }

    
    private static boolean validateServiceImageUrl(String url) throws ServiceValueInvalidException {
        if (url == null) {
            throw new ServiceValueInvalidException(ErrorMessages.INVALID_SERVICE_URL_NULL);
        }
        
        ImageUrlValidations.validateImageUrl(url);
        return true;
    }

	

}
