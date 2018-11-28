package com.aurelius.spring.async.repository.impl;

import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionException;
import java.util.concurrent.ExecutorService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import com.aurelius.spring.async.repository.PersonRespositoryAsync;
import com.aurelius.spring.repository.PersonRepository;
import com.aurelius.spring.repository.entity.Person;

@Component
public class DefaultPersonRepositoryAsync implements PersonRespositoryAsync {

    @Autowired
    PersonRepository personRepository;

    @Autowired
    private ExecutorService cachedThreadPool;
    @Autowired
    private ExecutorService fixedThreadPool;

    @Override
    @Async
    public CompletableFuture<Optional<Person>> findPersonByIdAsync(String id) {
	return CompletableFuture.supplyAsync(() -> {
	    try {
		Thread.sleep(1000);
		return personRepository.findById(id);

	    } catch (InterruptedException e) {
		Thread.currentThread()
		    .interrupt();
		throw new CompletionException(e);
	    }
	}, cachedThreadPool);
    }
}
