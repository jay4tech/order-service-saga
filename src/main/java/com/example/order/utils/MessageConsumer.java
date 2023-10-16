package com.example.order.utils;


import com.example.order.model.Payment;
import com.example.order.service.IOrderService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class MessageConsumer {

    @Autowired
    IOrderService orderService;

    @RabbitListener(queues = {"${queue.name.order}"})
    public void receive(@Payload String message) {
        System.out.println("Message " + message);
        Payment payment = UtilityMapper.responseToModel(message);
        if (payment != null) {

            orderService.updateOrder(payment);

        }
    }

}