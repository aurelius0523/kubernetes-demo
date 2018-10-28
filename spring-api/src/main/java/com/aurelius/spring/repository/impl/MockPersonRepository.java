package com.aurelius.spring.repository.impl;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import com.aurelius.spring.repository.PersonRepository;
import com.aurelius.spring.repository.entity.Person;

@Primary
@Component
@Profile("repository-mock")
public class MockPersonRepository implements PersonRepository {

    @Override
    public long count() {
	// TODO Auto-generated method stub
	return 0;
    }

    @Override
    public void delete(Person arg0) {
	// TODO Auto-generated method stub

    }

    @Override
    public void deleteAll() {
	// TODO Auto-generated method stub

    }

    @Override
    public void deleteAll(Iterable<? extends Person> arg0) {
	// TODO Auto-generated method stub

    }

    @Override
    public void deleteById(String arg0) {
	// TODO Auto-generated method stub

    }

    @Override
    public boolean existsById(String arg0) {
	// TODO Auto-generated method stub
	return false;
    }

    @Override
    public Iterable<Person> findAll() {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public Iterable<Person> findAllById(Iterable<String> arg0) {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public Optional<Person> findById(String arg0) {
	Person person = new Person();
	person.setId("111");
	person.setMock(true);
	person.setName("fake person 111");
	person.setBirthDate(LocalDate.now());
	return Optional.of(person);
    }

    @Override
    public <S extends Person> S save(S arg0) {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public <S extends Person> Iterable<S> saveAll(Iterable<S> arg0) {
	// TODO Auto-generated method stub
	return null;
    }

}
