package com.aurelius.spring.facade.impl;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.aurelius.spring.async.repository.PersonRespositoryAsync;
import com.aurelius.spring.async.service.ThirdPartyServiceAsync;
import com.aurelius.spring.exception.ResourceEmptyException;
import com.aurelius.spring.facade.PersonFacade;
import com.aurelius.spring.facade.model.PersonModel;
import com.aurelius.spring.facade.model.TodoModel;
import com.aurelius.spring.facade.model.mapper.PersonMapper;
import com.aurelius.spring.repository.PersonRepository;
import com.aurelius.spring.repository.entity.Person;
import com.aurelius.spring.service.ThirdPartyService;
import com.aurelius.spring.service.body.TodoBody;

@Component
public class DefaultPersonFacade implements PersonFacade {

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private ThirdPartyService thirdPartyService;

    @Autowired
    private PersonRespositoryAsync personRepositoryAsync;

    @Autowired
    private ExecutorService cachedThreadPool;

    @Autowired
    private PersonMapper personMapper;

    @Autowired
    ThirdPartyServiceAsync thirdPartyServiceAsync;

    public PersonModel getPerson() {
	PersonModel person = new PersonModel();

	CompletableFuture<TodoBody> todoBody = thirdPartyServiceAsync.getFirstTodoAsync();
	CompletableFuture<Optional<Person>> personEntity = personRepositoryAsync.findPersonByIdAsync("1");

	personEntity.join()
	    .ifPresent((optionalPerson) -> {
		person.setId(optionalPerson.getId());
		person.setName(optionalPerson.getName());
	    });

	TodoModel todoModel = new TodoModel();
	TodoBody body = todoBody.join();
	todoModel.setCompleted(body.isCompleted());
	todoModel.setId(body.getId());
	todoModel.setTitle(body.getTitle());

	person.setFirstTodo(todoModel);

	return person;
    }

    public List<PersonModel> getPersonList() {
	return StreamSupport.stream(personRepository.findAll()
	    .spliterator(), false)
	    .map((person) -> personMapper.convertFromEntity(person))
	    .collect(Collectors.toList());
    }

    public PersonModel createPerson(PersonModel personModel) {
	Person person = personRepository.save(personMapper.convertToEntity(personModel));
	return personMapper.convertFromEntity(person);
    }

    public PersonModel updatePerson(String personId, PersonModel personModel) {
	personRepository.findById(personId)
	    .orElseThrow(() -> {
		throw new ResourceEmptyException();
	    });

	Person person = personMapper.convertToEntity(personModel);
	person.setId(personId);

	return personMapper.convertFromEntity(personRepository.save(person));
    }
}
