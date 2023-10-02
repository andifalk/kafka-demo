package com.example.consumer;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/events", produces = MediaType.APPLICATION_JSON_VALUE)
public class CustomerEventApi {

    private final CustomerEventConsumerService customerEventConsumerService;

    public CustomerEventApi(CustomerEventConsumerService customerEventConsumerService) {
        this.customerEventConsumerService = customerEventConsumerService;
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    public List<CustomerEvent> getAllEvents() {
        return customerEventConsumerService.getAllEvents();
    }
}
