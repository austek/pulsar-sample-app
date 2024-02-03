package com.collibra.csp.client.examples.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan({"com.collibra.csp.client.config"})
public class ExampleProducerConfig {

    private static final String EXAMPLE_TOPIC = "persistent://playground/test/test.topic3.v1";

    private String getTopicName() {
        return EXAMPLE_TOPIC;
    }

    @Bean
    @Qualifier("exampleProducerTopicV1")
    public String getTopic() {
        return getTopicName();
    }
}
