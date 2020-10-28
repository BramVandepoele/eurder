package com.switchfully.bram.eurder.exceptions;

import org.springframework.util.StringUtils;

public class CustomerCreationFailedException extends RuntimeException{
    public CustomerCreationFailedException(Class clazz, String... searchParamsMap) {
        super(CustomerCreationFailedException.generateMessage(clazz.getSimpleName(), searchParamsMap[0] , searchParamsMap[1]));
    }

    private static String generateMessage(String entity, String paramName, String paramValue) {
        return StringUtils.capitalize(entity) +
                " creation failed due to " +  paramName + " with value '" + paramValue + "'";
    }
}
