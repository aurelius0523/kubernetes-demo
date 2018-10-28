package com.aurelius.spring.util;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class MockResourceUtil {
    public static <T> T fetchMockJson(String fileName, Class<T> clazz) {
	// TODO 1. find out how to load JSON file from resource folder properly 2.
	// Handle FileNotFound 3. Error handling
	String mockJsonString = "{\"userId\": 1, \"id\": 11,\"title\": \"This is a mock todo\",\"completed\": true}";

	try {
	    return new ObjectMapper().readValue(mockJsonString, clazz);
	} catch (JsonParseException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	} catch (JsonMappingException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	} catch (IOException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}
	return null;
    }
}
