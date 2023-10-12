package com.example.order.utils;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class MessageSender {

    @Autowired
    private RabbitTemplate rabbitTemplate;
    @Autowired
    @Qualifier("queueInventory")
    private Queue queueInventory;

    public void sendInventoryEvent(String message) {
        rabbitTemplate.convertAndSend(queueInventory.getName(), message);
    }
}
