package com.example.consumer;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaHandler;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.List;
import java.util.TimeZone;
import java.util.UUID;

@Transactional(readOnly = true)
@Service
@KafkaListener(topics = "demo", id = "${spring.application.name}", autoStartup = "true")
public class CustomerEventConsumerService {
    private static final Logger log = LoggerFactory.getLogger(CustomerEventConsumerService.class);

    private final CustomerEventRepository customerEventRepository;

    public CustomerEventConsumerService(CustomerEventRepository customerEventRepository) {
        this.customerEventRepository = customerEventRepository;
    }

    @Transactional
    @KafkaHandler(isDefault = true)
    public void consume(ConsumerRecord<UUID, CustomerEvent> consumerRecord) {
        UUID key = consumerRecord.key();
        CustomerEvent customerEvent = consumerRecord.value();
        LocalDateTime timestamp =
                LocalDateTime.ofInstant(Instant.ofEpochMilli(consumerRecord.timestamp()),
                        TimeZone.getDefault().toZoneId());
        long offset = consumerRecord.offset();
        int partition = consumerRecord.partition();

        log.info("Consumed message at [partition={}, offset={}] with key [{}] and message {}",
                partition, offset, key, customerEvent);

        CustomerEvent savedEvent = customerEventRepository.save(customerEvent);

        log.info("Saved message {}", savedEvent);
    }

    public List<CustomerEvent> getAllEvents() {
        return customerEventRepository.findAll();
    }
}
