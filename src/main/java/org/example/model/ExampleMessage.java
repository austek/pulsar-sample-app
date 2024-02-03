package com.collibra.csp.client.examples.model.v1;

import static java.util.UUID.randomUUID;

import java.time.Instant;
import java.time.OffsetDateTime;
import java.util.UUID;

public record ExampleMessage(
        UUID id, UUID createdBy, Instant createdOn, UUID lastModifiedBy, OffsetDateTime lastModifiedOn) {
    public ExampleMessage(UUID id, UUID createdBy, Instant createdOn) {
        this(id, createdBy, createdOn, randomUUID(), OffsetDateTime.now());
    }

    public ExampleMessage() {
        this(randomUUID(), randomUUID(), Instant.now(), randomUUID(), OffsetDateTime.now());
    }
}
