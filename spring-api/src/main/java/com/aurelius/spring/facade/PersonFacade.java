package com.aurelius.spring.facade;

import org.springframework.stereotype.Component;

import com.aurelius.spring.facade.model.PersonModel;

@Component
public interface PersonFacade {
    public PersonModel getPerson();
}
