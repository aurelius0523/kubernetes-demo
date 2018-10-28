package com.aurelius.spring.service;

import com.aurelius.spring.service.body.TodoBody;
import com.mashape.unirest.http.exceptions.UnirestException;

public interface ThirdPartyService {
    public TodoBody getFirstTodo() throws UnirestException;
}
