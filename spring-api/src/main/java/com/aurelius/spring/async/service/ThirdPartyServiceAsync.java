package com.aurelius.spring.async.service;

import java.util.concurrent.CompletableFuture;

import com.aurelius.spring.service.body.TodoBody;

public interface ThirdPartyServiceAsync {
    public CompletableFuture<TodoBody> getFirstTodoAsync();
}
