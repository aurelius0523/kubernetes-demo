package com.aurelius.spring.configuration;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * Initially the intention was to utilize Spring's built in {@link Async}
 * annotation but it returns a {@link Future} instead of
 * {@link CompletableFuture} which is less fluent and powerful, albeit having
 * its own use case
 * 
 * @author kim.loong.tan
 *
 */
@EnableAsync
public class AsyncConfiguration {

    /**
     * Ideally used for processess involving I/O, HTTP requests that can happen in
     * bursts but short lived. It is important to know that this threadpool has no
     * thread limit and can potentionally cause {@link OutOfMemoryError}
     * 
     * @return a cached thread pool
     */
    @Bean
    public ExecutorService cachedThreadPool() {
	return Executors.newCachedThreadPool();
    }

    /**
     * Ideally used for small amount of longer running tasks
     * 
     * @return a fixed thread pool
     */
    @Bean
    public ExecutorService fixedThreadPool() {
	return Executors.newFixedThreadPool(Runtime.getRuntime()
	    .availableProcessors());
    }
}
