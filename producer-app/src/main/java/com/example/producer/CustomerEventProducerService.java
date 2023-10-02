package com.example.producer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;
import java.util.stream.Stream;

@Transactional
@Service
public class CustomerEventProducerService {
    private static final Logger log = LoggerFactory.getLogger(CustomerEventProducerService.class);
    private final Producer producer;

    public CustomerEventProducerService(Producer producer) {
        this.producer = producer;
    }

    public void produceEvents() {
        List<CustomerEvent> customerEvents = Stream.of(
                new CustomerEvent(UUID.randomUUID(), CustomerEventType.CREATE, "Peter", "Parker",
                        LocalDate.of(1980, 11, 10), "peter.parker@example.com"),
                new CustomerEvent(UUID.randomUUID(), CustomerEventType.CREATE, "Bruce", "Wayne",
                        LocalDate.of(1977, 1, 14), "bruce.wayne@example.com"),
                new CustomerEvent(UUID.randomUUID(), CustomerEventType.CREATE, "Clark", "Kent",
                        LocalDate.of(1977, 1, 14), "clark.kent@example.com")
        ).map(this.producer::send).toList();
        log.info("Sent {} number of events", customerEvents.size());
    }
}
