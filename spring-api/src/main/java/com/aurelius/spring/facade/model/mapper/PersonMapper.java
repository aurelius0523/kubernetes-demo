package com.aurelius.spring.facade.model.mapper;

import org.springframework.stereotype.Component;

import com.aurelius.spring.facade.model.PersonModel;
import com.aurelius.spring.repository.entity.Person;

@Component
public class PersonMapper {
    public PersonModel convertFromEntity(Person person) {
	PersonModel personModel = new PersonModel();
	person.setId(person.getId());
	person.setName(person.getName());
	return personModel;
    }

    public Person convertToEntity(PersonModel personModel) {
	Person person = new Person();
	person.setBirthDate(personModel.getBirthDate());
	person.setName(personModel.getName());
	return person;
    }
}
