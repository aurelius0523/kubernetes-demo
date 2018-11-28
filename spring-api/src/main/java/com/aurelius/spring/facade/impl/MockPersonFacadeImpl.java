package com.aurelius.spring.facade.impl;

import java.util.List;

import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import com.aurelius.spring.facade.PersonFacade;
import com.aurelius.spring.facade.model.PersonModel;

@Component
@Primary
@Profile("facade-mock")
public class MockPersonFacadeImpl implements PersonFacade {

    @Override
    public PersonModel getPerson() {
	PersonModel person = new PersonModel();
	person.setId("1");
	person.setName("mocked name");
	return person;
    }

    @Override
    public List<PersonModel> getPersonList() {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public PersonModel createPerson(PersonModel personModel) {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public PersonModel updatePerson(String personId, PersonModel personModel) {
	// TODO Auto-generated method stub
	return null;
    }

}
