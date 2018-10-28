package com.aurelius.spring.api;

import java.io.IOException;
import java.time.LocalDate;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.aurelius.spring.repository.PersonRepository;
import com.aurelius.spring.repository.entity.Person;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.mashape.unirest.http.ObjectMapper;
import com.mashape.unirest.http.Unirest;

@SpringBootApplication
@ComponentScan(basePackages = { "com.aurelius.spring" })
@EnableJpaRepositories(basePackages = { "com.aurelius.spring.repository" })
@EntityScan(basePackages = { "com.aurelius.spring.repository.entity" })
public class SpringApiApplication {

    public static void main(String[] args) {
	configureUnirest();
	SpringApplication.run(SpringApiApplication.class, args);
    }

    // TODO move this into its own configuration file
    private static void configureUnirest() {
	Unirest.setObjectMapper(new ObjectMapper() {
	    private com.fasterxml.jackson.databind.ObjectMapper jacksonObjectMapper = new com.fasterxml.jackson.databind.ObjectMapper();

	    public <T> T readValue(String value, Class<T> valueType) {
		try {
		    return jacksonObjectMapper.readValue(value, valueType);
		} catch (IOException e) {
		    throw new RuntimeException(e);
		}
	    }

	    public String writeValue(Object value) {
		try {
		    return jacksonObjectMapper.writeValueAsString(value);
		} catch (JsonProcessingException e) {
		    throw new RuntimeException(e);
		}
	    }

	});
    }

    // TODO change this to use data.sql. Nicer
    @Bean
    public CommandLineRunner demoData(PersonRepository personRepository) {
	return args -> {
	    Person person = new Person();
	    person.setBirthDate(LocalDate.now());
	    person.setName("this dude is real");
	    person.setId("1");
	    person.setMock(false);
	    personRepository.save(person);
	};
    }
}
