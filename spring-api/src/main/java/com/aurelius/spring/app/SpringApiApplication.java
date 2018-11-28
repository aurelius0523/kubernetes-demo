package com.aurelius.spring.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

import com.aurelius.spring.configuration.AsyncConfiguration;
import com.aurelius.spring.configuration.RepositoryConfiguration;
import com.aurelius.spring.configuration.UnirestConfiguration;

@SpringBootApplication
@ComponentScan(basePackages = { "com.aurelius.spring" })
@Import({ AsyncConfiguration.class, RepositoryConfiguration.class, UnirestConfiguration.class })
public class SpringApiApplication {
    public static void main(String[] args) {
	SpringApplication.run(SpringApiApplication.class, args);
    }
}
