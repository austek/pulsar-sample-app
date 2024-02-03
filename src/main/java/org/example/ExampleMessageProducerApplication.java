package org.example;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.pulsar.annotation.PulsarListener;
import org.springframework.pulsar.core.PulsarTemplate;

@SpringBootApplication
public class ExampleMessageProducerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ExampleMessageProducerApplication.class, args);
    }

    @Bean
    ApplicationRunner runner1(PulsarTemplate<String> pulsarTemplate) {
        String topic1 = "your-topic-goes-here";
        return args -> {
            for (int i = 0; i < 10; i++) {
                pulsarTemplate.send(topic1, "This is message " + (i + 1));
            }
        };
    }

    @PulsarListener(subscriptionName = "subscription-1", topics = "your-topic-goes-here")
    void listen1(String message) {
        System.out.println("***** " + message);
    }
}
