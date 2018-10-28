package com.aurelius.spring.facade.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.aurelius.spring.exception.ThirdPartyHttpException;
import com.aurelius.spring.facade.PersonFacade;
import com.aurelius.spring.facade.model.PersonModel;
import com.aurelius.spring.facade.model.TodoModel;
import com.aurelius.spring.repository.PersonRepository;
import com.aurelius.spring.repository.entity.Person;
import com.aurelius.spring.service.ThirdPartyService;
import com.aurelius.spring.service.body.TodoBody;
import com.mashape.unirest.http.exceptions.UnirestException;

@Component
public class DefaultPersonFacade implements PersonFacade {

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private ThirdPartyService thirdPartyService;

    public PersonModel getPerson() {
	PersonModel person = new PersonModel();

	Optional<Person> personEntity = personRepository.findById("1");
	personEntity.ifPresent((optionalPerson) -> {
	    person.setId(optionalPerson.getId());
	    person.setName(optionalPerson.getName());
	    person.setMock(optionalPerson.isMock());
	});

	try {
	    TodoBody body = thirdPartyService.getFirstTodo();
	    // TODO move this to a proper mapper

	    TodoModel todoModel = new TodoModel();
	    todoModel.setCompleted(body.isCompleted());
	    todoModel.setId(body.getId());
	    todoModel.setTitle(body.getTitle());

	    person.setFirstTodo(todoModel);
	} catch (UnirestException e) {
	    throw new ThirdPartyHttpException(e);
	}
	return person;
    }
}
