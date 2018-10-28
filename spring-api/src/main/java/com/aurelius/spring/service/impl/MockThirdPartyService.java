package com.aurelius.spring.service.impl;

import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import com.aurelius.spring.service.ThirdPartyService;
import com.aurelius.spring.service.body.TodoBody;
import com.aurelius.spring.util.MockResourceUtil;
import com.mashape.unirest.http.exceptions.UnirestException;

@Primary
@Component
@Profile("service-mock")
public class MockThirdPartyService implements ThirdPartyService {
    public TodoBody getFirstTodo() throws UnirestException {
	return MockResourceUtil.fetchMockJson("getFirstTodo.json", TodoBody.class);
    }
}
