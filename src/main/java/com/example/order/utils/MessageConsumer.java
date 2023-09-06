package com.example.order.utils;


import com.example.order.entity.Order;
import com.example.order.repository.OrderRepository;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class MessageConsumer {

    @Autowired
    OrderRepository orderRepository;

    @RabbitListener(queues = {"${queue.name.order}"})
    public void receive(@Payload String message) {
        System.out.println("Message " + message);
        Order orderDetails = UtilityMapper.responseToModel(message);
        if (orderDetails != null) {
            Order orderDb = orderRepository.findById(orderDetails.getId()).orElse(null);
            if (orderDb != null) {
                orderDb.setStatus(orderDetails.getStatus());
                orderRepository.save(orderDb);
            }
        }
    }

}