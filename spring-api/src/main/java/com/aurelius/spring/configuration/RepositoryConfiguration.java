package com.aurelius.spring.configuration;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories(basePackages = { "com.aurelius.spring.repository" })
@EntityScan(basePackages = { "com.aurelius.spring.repository.entity" })
public class RepositoryConfiguration {

}
