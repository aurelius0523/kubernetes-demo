package com.aurelius.spring.controller;

import java.util.UUID;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
@CrossOrigin("*")
public class UUIDController {

    @GetMapping("/uuid")
    public String getRandomUUID() {
	return UUID.randomUUID().toString();
    }
}
