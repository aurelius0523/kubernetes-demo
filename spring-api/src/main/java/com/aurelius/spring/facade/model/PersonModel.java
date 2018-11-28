package com.aurelius.spring.facade.model;

import java.time.LocalDate;

public class PersonModel {
    private String id;
    private String name;
    private LocalDate birthDate;
    private TodoModel firstTodo;

    public LocalDate getBirthDate() {
	return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
	this.birthDate = birthDate;
    }

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
}
