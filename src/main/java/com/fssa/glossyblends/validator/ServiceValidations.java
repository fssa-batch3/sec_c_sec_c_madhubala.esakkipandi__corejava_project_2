package com.fssa.glossyblends.validator;
 
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.fssa.glossyblends.customexception.ServiceValueInvalidException;
import com.fssa.glossyblends.model.ErrorMessages;
import com.fssa.glossyblends.model.ServiceCategory;
import com.fssa.glossyblends.model.Services;


public class ServiceValidations {
private ServiceValidations() {
		
		
	}

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
