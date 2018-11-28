package com.aurelius.spring.configuration;

import java.io.IOException;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.mashape.unirest.http.ObjectMapper;
import com.mashape.unirest.http.Unirest;

public class UnirestConfiguration {

    @EventListener(ApplicationReadyEvent.class)
    public void configureUnirest() {
	Unirest.setObjectMapper(new ObjectMapper() {
	    private com.fasterxml.jackson.databind.ObjectMapper jacksonObjectMapper = new com.fasterxml.jackson.databind.ObjectMapper();

	    public <T> T readValue(String value, Class<T> valueType) {
		try {
		    return jacksonObjectMapper.readValue(value, valueType);
		} catch (IOException e) {
		    throw new RuntimeException(e);
		}
	    }

	    public String writeValue(Object value) {
		try {
		    return jacksonObjectMapper.writeValueAsString(value);
		} catch (JsonProcessingException e) {
		    throw new RuntimeException(e);
		}
	    }

	});
    }
}
