package com.aurelius.spring.util;

import java.io.File;
import java.io.IOException;

import org.springframework.core.io.ClassPathResource;

import com.aurelius.spring.exception.MockResourceException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class MockResourceUtil {
    private MockResourceUtil() {
	// prevent initialization
    }

    public static <T> T fetchMockJson(String fileName, Class<T> clazz) {
	try {
	    File file = new ClassPathResource("mocks/" + fileName).getFile();
	    return new ObjectMapper().readValue(file, clazz);
	} catch (IOException e) {
	    throw new MockResourceException(e);
	}
    }
}
