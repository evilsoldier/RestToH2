package com.rest.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

/**
 * Utility methods for marshalling messages from specific type to JSON.
 *
 * @author Evgeni Stoykov
 */
public final class JsonUtils {

    private static final ObjectMapper objectMapper = new ObjectMapper();

    private JsonUtils() {
    }

    public static String toJson(Object data) {
        try {
            return objectMapper.writeValueAsString(data);
        } catch (JsonProcessingException e) {
            String errorMessage = "Unable to marshall message. Reason: " + e.getMessage();
            throw new IllegalStateException(errorMessage, e);
        }
    }

    public static <T> T asObject(String jsonString, Class<T> clazz) {
        try {
            return objectMapper.readValue(jsonString, clazz);
        } catch (IOException e) {
            String errorMessage = "Unable to unmarshall message. Reason: " + e.getMessage();
            throw new IllegalStateException(errorMessage, e);
        }
    }
}
