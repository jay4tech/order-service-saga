package com.example.order.utils;

import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfig {

    @Value("${queue.name.inventory}")
    private String queueInventory;

    @Bean(name = "queueInventory")
    public Queue queueInventory() {
        return new Queue(queueInventory, true);
    }

}