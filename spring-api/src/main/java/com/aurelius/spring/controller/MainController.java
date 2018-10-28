package com.aurelius.spring.controller;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aurelius.spring.facade.PersonFacade;
import com.aurelius.spring.facade.model.PersonModel;
import com.aurelius.spring.service.ThirdPartyService;
import com.aurelius.spring.service.body.TodoBody;

@RestController
@RequestMapping("/")
@CrossOrigin("*")
public class MainController {

    @Autowired
    private PersonFacade personFacade;

    @GetMapping("/uuid")
    public String getRandomUUID() {
	return UUID.randomUUID().toString();
    }

    @GetMapping("/person")
    public PersonModel testInjection() {
	return personFacade.getPerson();
    }

}
