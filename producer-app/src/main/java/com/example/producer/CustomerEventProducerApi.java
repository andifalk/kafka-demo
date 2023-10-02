package com.example.producer;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/send")
public class CustomerEventProducerApi {

    private final CustomerEventProducerService customerEventProducerService;

    public CustomerEventProducerApi(CustomerEventProducerService customerEventProducerService) {
        this.customerEventProducerService = customerEventProducerService;
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    public String send() {
        customerEventProducerService.produceEvents();
        return "Send Success";
    }
}
