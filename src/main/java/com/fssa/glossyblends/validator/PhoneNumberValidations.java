package com.fssa.glossyblends.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.fssa.glossyblends.model.ErrorMessages;

public class PhoneNumberValidations {

	
	
	
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
