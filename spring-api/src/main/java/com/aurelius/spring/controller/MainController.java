package com.aurelius.spring.controller;

import java.util.UUID;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
public class MainController {

    @GetMapping("/uuid")
    public String getRandomUUID() {
	return UUID.randomUUID()
	    .toString();
    }
}
