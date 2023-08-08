package com.fssa.glossyblends.Validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.fssa.glossyblends.model.ErrorMessages;

public class phoneNumberValidations {

	
	
	
	public static boolean validateNumber(String number)throws IllegalArgumentException{
		
		
		String mobilePattern = "^\\d{7,15}$";

		Pattern pattern=Pattern.compile(mobilePattern);
		
		Matcher patternmatching=pattern.matcher(number);
		
		boolean isValid=patternmatching.matches();
		
		if(!isValid) {
			
			
			throw new IllegalArgumentException(ErrorMessages.INVALID_PHONE_NUMBER_FORMAT);
		}
		return true;
		
	}

}
