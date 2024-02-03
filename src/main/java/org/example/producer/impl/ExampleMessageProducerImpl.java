package com.collibra.csp.client.examples.producer.impl;

import org.apache.pulsar.client.api.MessageId;
import org.apache.pulsar.client.api.PulsarClientException;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.pulsar.core.PulsarTemplate;
import org.springframework.stereotype.Service;

import com.collibra.csp.client.examples.model.v1.ExampleMessage;
import com.collibra.csp.client.examples.producer.ExampleMessageProducer;
import com.collibra.csp.client.exception.CspClientRuntimeException;

@Service
public class ExampleMessageProducerImpl implements ExampleMessageProducer {

    private final PulsarTemplate<ExampleMessage> producer;
    private final String topicName;

    public ExampleMessageProducerImpl(
            PulsarTemplate<ExampleMessage> producer, @Qualifier("exampleProducerTopicV1") String topicName) {
        this.producer = producer;
        this.topicName = topicName;
    }

    @Override
    public MessageId send(ExampleMessage message) throws CspClientRuntimeException {
        try {
            return producer.newMessage(message).withTopic(topicName).send();
        } catch (PulsarClientException e) {
            throw new CspClientRuntimeException(e);
        }
    }
}
