package com.example.consumer;

import org.apache.kafka.common.header.Headers;
import org.apache.kafka.common.serialization.Deserializer;

import java.nio.charset.StandardCharsets;
import java.util.Map;
import java.util.UUID;

public class UuidDeserializer implements Deserializer<UUID> {

    @Override
    public void configure(Map<String, ?> configs, boolean isKey) {
        Deserializer.super.configure(configs, isKey);
    }

    @Override
    public UUID deserialize(String topic, byte[] data) {
        return UUID.fromString(new String(data, StandardCharsets.UTF_8));
    }

    @Override
    public UUID deserialize(String topic, Headers headers, byte[] data) {
        return Deserializer.super.deserialize(topic, headers, data);
    }

    @Override
    public void close() {
        Deserializer.super.close();
    }
}
