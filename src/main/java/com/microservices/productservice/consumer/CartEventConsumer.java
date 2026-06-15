package com.microservices.productservice.consumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class CartEventConsumer {

    @KafkaListener(topics = "cart-events", groupId = "product-service-group")
    public void consumeCartEvent(String message) {
        System.out.println("Kafka event received in Product Service: " + message);
    }
}