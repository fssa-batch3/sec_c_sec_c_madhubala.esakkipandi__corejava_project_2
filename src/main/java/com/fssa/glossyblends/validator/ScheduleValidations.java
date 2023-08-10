package com.fssa.glossyblends.validator;
import java.time.LocalDate;
import java.time.LocalDateTime;
import com.fssa.glossyblends.model.ErrorMessages;
import com.fssa.glossyblends.model.Schedule;

public class ScheduleValidations {
    private static final ScheduleValidations instance = new ScheduleValidations();
    private ScheduleValidations() {
    }
    public static ScheduleValidations getInstance() {
    	
    	
        return instance;
        
    }
    
    public static boolean validateSchedule(Schedule listOfSchedule) throws IllegalArgumentException {
        try {
            validateName(listOfSchedule.getEventName());
            validateDate(listOfSchedule.getDate());
            validateTimeOfEvent(listOfSchedule.getTimeOfEvent());
            return true;
        } catch (IllegalArgumentException ex) {
            // Add your custom handling logic here
            // For example, you can log the exception or perform some other action
          System.out.print("An error occurred while validating schedule: " + ex.getMessage());
            
            // Rethrow the exception automatically
            throw ex;
        }
    }
  
    public static boolean validateName(String eventname) throws IllegalArgumentException {
        if (eventname == null) {
            throw new IllegalArgumentException(ErrorMessages.INVALI_EVENT_NAME_NULL);
        }
        ArtistNameValidations.validateName(eventname);
        return true;
    }
    
    public static boolean validateDate(LocalDate date) throws IllegalArgumentException {
        if (date == null) {
            throw new IllegalArgumentException(ErrorMessages.DATE_EVENT_NAME_NULL);
        }
        LocalDate currentDate = LocalDate.now();
        if (date.isBefore(currentDate)) {
            throw new IllegalArgumentException(ErrorMessages.DATE_EVENT_PASSED);
        }
        return true;
    }
    
    public static boolean validateTimeOfEvent(LocalDateTime timeOfEvent) throws IllegalArgumentException {
        if (timeOfEvent == null) {
            throw new IllegalArgumentException(ErrorMessages.TIME_OF_EVENT_NULL);
        }
        return true;
    }
}
