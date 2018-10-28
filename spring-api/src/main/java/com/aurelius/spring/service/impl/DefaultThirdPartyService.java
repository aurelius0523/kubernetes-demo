package com.aurelius.spring.service.impl;

import org.springframework.stereotype.Component;

import com.aurelius.spring.service.ThirdPartyService;
import com.aurelius.spring.service.body.TodoBody;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

@Component
public class DefaultThirdPartyService implements ThirdPartyService {
    public TodoBody getFirstTodo() throws UnirestException {
	return Unirest.get("https://jsonplaceholder.typicode.com/todos/1").asObject(TodoBody.class).getBody();
    }
}
