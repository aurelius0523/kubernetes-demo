package com.aurelius.spring.async.repository;

import java.util.Optional;
import java.util.concurrent.CompletableFuture;

import com.aurelius.spring.repository.entity.Person;

public interface PersonRespositoryAsync {
    public CompletableFuture<Optional<Person>> findPersonByIdAsync(String id);
}
