package com.example.producer;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class Producer {
    private static final String TOPIC = "demo";
    private final KafkaTemplate<UUID, CustomerEvent> kafkaTemplate;

    public Producer(KafkaTemplate<UUID, CustomerEvent> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public CustomerEvent send(CustomerEvent customerEvent) {
        this.kafkaTemplate.send(TOPIC, 0, System.currentTimeMillis(),
                customerEvent.getIdentifier(), customerEvent);
        return customerEvent;
    }
}
