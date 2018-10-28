package com.aurelius.spring.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.aurelius.spring.repository.entity.Person;

@Repository
public interface PersonRepository extends CrudRepository<Person, String> {

}
