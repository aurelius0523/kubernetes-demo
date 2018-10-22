package com.aurelius.spring.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = { "com.aurelius.spring" })
public class SpringApiApplication {

    public static void main(String[] args) {
	SpringApplication.run(SpringApiApplication.class, args);
    }
}
