package com.pragma.food_court_user.domain;

public class Constants {
    private Constants(){
        throw new IllegalStateException("utility class");
    }

    public static final String INVALID_FORMAT = "The %s format is not correct";
    public static final String NAME_ROL_VALIDATIONS_EXCEPTION_MESSAGE = "The role %s was not found";
    public static final String AGE_VALIDATIONS_EXCEPTION_MESSAGE = "The user must be an adult.";
    public static final String ID_VALIDATIONS_EXCEPTION_MESSAGE = "the id %d was not found";
    public static final String INVALID_CREDENTIALS = "invalid credential: %s";
}

