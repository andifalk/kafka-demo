package com.example.consumer;

import org.springframework.data.repository.ListCrudRepository;

public interface CustomerEventRepository extends ListCrudRepository<CustomerEvent, Long> {
}
