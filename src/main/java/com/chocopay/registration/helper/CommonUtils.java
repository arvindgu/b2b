package com.chocopay.registration.helper;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class CommonUtils {

    private final static ObjectMapper mapper = new ObjectMapper();

    public static String objToString(Object object) {
        try {
            return mapper.writeValueAsString(object);
        } catch (JsonProcessingException ex) {
            throw new IllegalArgumentException("Error converting object to string", ex);
        }
    }
}
