package com.practice.utils;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

/**
 * Created by administer on 28/5/19.
 */
public class JSONChange {
    public static Object jsonToObj(Object obj, String jsonStr) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.readValue(jsonStr, obj.getClass());
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
