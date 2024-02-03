package com.collibra.csp.client.examples.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.collibra.csp.client.examples.model.v1.ExampleMessage;
import com.collibra.csp.client.examples.producer.ExampleMessageProducer;
import com.collibra.csp.client.exception.CspClientRuntimeException;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/send")
@Slf4j
@RequiredArgsConstructor
public class SendController {

    private final ExampleMessageProducer messageProducer;

    @PostMapping("/example")
    public ResponseEntity<String> sendMessageJson() {
        try {
            String messageId = messageProducer.send(new ExampleMessage()).toString();
            log.info("Sent Message ID: {}", messageId);
            return ResponseEntity.ok(messageId);
        } catch (CspClientRuntimeException e) {
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }
}
