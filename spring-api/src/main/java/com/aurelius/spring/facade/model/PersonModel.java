package com.aurelius.spring.facade.model;

public class PersonModel {
    private String id;
    private String name;
    private boolean isMock;
    private TodoModel firstTodo;

    public TodoModel getFirstTodo() {
	return firstTodo;
    }

    public void setFirstTodo(TodoModel firstTodo) {
	this.firstTodo = firstTodo;
    }

    public String getId() {
	return id;
    }

    public void setId(String id) {
	this.id = id;
    }

    public String getName() {
	return name;
    }

    public void setName(String name) {
	this.name = name;
    }

    public boolean isMock() {
	return isMock;
    }

    public void setMock(boolean isMock) {
	this.isMock = isMock;
    }
}
