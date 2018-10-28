package com.aurelius.spring.facade.impl;

import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import com.aurelius.spring.facade.PersonFacade;
import com.aurelius.spring.facade.model.PersonModel;

@Component
@Primary
@Profile("facade-mock")
public class MockPersonFacadeImpl implements PersonFacade {

    public PersonModel getPerson() {
	PersonModel person = new PersonModel();
	person.setId("1");
	person.setName("mocked name");
	person.setMock(true);
	return person;
    }

}
