package com.aurelius.spring.repository.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class Person {
    @Id
    private String id;
    private String name;
    private LocalDate birthDate;
    private boolean isMock;

    public boolean isMock() {
	return isMock;
    }

    public void setMock(boolean isMock) {
	this.isMock = isMock;
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

    public LocalDate getBirthDate() {
	return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
	this.birthDate = birthDate;
    }

}
