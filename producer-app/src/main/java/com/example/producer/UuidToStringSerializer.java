package com.example.producer;

import org.apache.kafka.common.header.Headers;
import org.apache.kafka.common.serialization.Serializer;
import org.springframework.lang.Nullable;

import java.util.Map;
import java.util.UUID;

import static java.nio.charset.StandardCharsets.UTF_8;

@SuppressWarnings("unused")
public class UuidToStringSerializer implements Serializer<UUID> {

    private static final String KEY_TYPE = "spring.message.key.type";

    @Override
    public void configure(Map<String, ?> configs, boolean isKey) {
        Serializer.super.configure(configs, isKey);
    }

    @Override
    public byte[] serialize(String topic, UUID data) {
        return serialize(topic, null, data);
    }

    @Override
    public byte[] serialize(String topic, @Nullable Headers headers, UUID data) {
        if (headers != null) {
            headers.add(KEY_TYPE, data.getClass().getName().getBytes());
        }
        return data.toString().getBytes(UTF_8);
    }

    @Override
    public void close() {
        Serializer.super.close();
    }
}
