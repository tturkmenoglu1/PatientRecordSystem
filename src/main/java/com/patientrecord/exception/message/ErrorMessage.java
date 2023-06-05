package com.patientrecord.exception.message;

public class ErrorMessage {
    public static final String JWTTOKEN_ERROR_MESSAGE = "JWT Token Validation Error: %s";



    public final static String PATIENT_NOT_FOUND_MESSAGE = "Patient with %d not found";


    public static final String EMAIL_NOT_FOUND_MESSAGE = "The provided email doesnt exist: %s";

    public final static String EMAIL_ALREADY_EXIST_MESSAGE = "Email: %s already exist";


    public final static String IMAGE_NOT_FOUND_MESSAGE = "Image with %s not found";

    public final static String IMAGE_USED_MESSAGE = "Image already in use";



    public final static String APPOINTMENT_NOT_FOUND_MESSAGE = "Appointment with %d not found";


    public final static String TRANSACTION_NOT_FOUND_MESSAGE = "Transaction with %d not found";




    public final static String ROLE_NOT_FOUND_MESSAGE = "The role you looking for does not exist: %s";

}
