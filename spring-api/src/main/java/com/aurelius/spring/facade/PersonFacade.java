package com.aurelius.spring.facade;

import java.util.List;

import org.springframework.stereotype.Component;

import com.aurelius.spring.facade.model.PersonModel;

@Component
public interface PersonFacade {
    public PersonModel getPerson();

    public List<PersonModel> getPersonList();

    public PersonModel createPerson(PersonModel personModel);

    public PersonModel updatePerson(String personId, PersonModel personModel);

}
