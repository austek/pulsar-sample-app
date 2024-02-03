package com.collibra.csp.client.examples.producer;

import org.apache.pulsar.client.api.MessageId;

import com.collibra.csp.client.examples.model.v1.ExampleMessage;
import com.collibra.csp.client.exception.CspClientRuntimeException;

public interface ExampleMessageProducer {

    MessageId send(ExampleMessage message) throws CspClientRuntimeException;
}
