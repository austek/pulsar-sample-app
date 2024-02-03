package com.collibra.csp.client.examples;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@EnableWebMvc
@Slf4j
public class ExampleMessageProducerApplication {

    public static void main(String[] args) {
        registerShutdownHook();
        SpringApplication.run(ExampleMessageProducerApplication.class, args);
    }

    private static void registerShutdownHook() {
        Runtime.getRuntime().addShutdownHook(new Thread(() -> log.info("Application Shutting down...")));
    }
}
