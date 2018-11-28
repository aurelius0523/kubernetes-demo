package com.aurelius.spring.async.service.impl;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionException;
import java.util.concurrent.ExecutorService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import com.aurelius.spring.async.service.ThirdPartyServiceAsync;
import com.aurelius.spring.exception.ThirdPartyHttpException;
import com.aurelius.spring.service.ThirdPartyService;
import com.aurelius.spring.service.body.TodoBody;
import com.mashape.unirest.http.exceptions.UnirestException;

@Component
public class DefaultThirdPartyServiceAsync implements ThirdPartyServiceAsync {

    @Autowired
    private ThirdPartyService thirdPartyService;

    @Autowired
    private ExecutorService cachedThreadPool;

    @Autowired
    private ExecutorService fixedThreadPool;

    @Override
    @Async
    public CompletableFuture<TodoBody> getFirstTodoAsync() {
	return CompletableFuture.supplyAsync(() -> {
	    try {
		Thread.sleep(2000);
		return thirdPartyService.getFirstTodo();
	    } catch (InterruptedException e) {
		Thread.currentThread()
		    .interrupt();
		throw new CompletionException(e);
	    } catch (UnirestException e) {
		throw new ThirdPartyHttpException(e);
	    }
	}, cachedThreadPool);
    }
}
