package com.example.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class KafkaController {
    private final KafkaTemplate<String, String> kafkaTemplate;
    private static final String TOPIC = "my-test-topic";

    @Autowired
    public KafkaController(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @PostMapping("/send-message")
    public String sendMessageToKafkaTopic(@RequestBody String message) {
        kafkaTemplate.send(TOPIC, message);
        return "Message sent to Kafka topic: " + TOPIC;
    }
}
