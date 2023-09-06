package com.example.order.service;

import com.example.order.entity.Order;
import com.example.order.repository.OrderRepository;
import com.example.order.utils.MessageSender;
import com.example.order.utils.UtilityMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService implements IOrderService{

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    MessageSender messageSender;

    @Override
    public void deleteOrder(Long id) {
        orderRepository.deleteById(id);
    }

    @Override
    public void updateOrder(Order order) {
        Order orderDb = orderRepository.findById(order.getId()).orElse(null);
        if(orderDb !=null) {
            order.setId(orderDb.getId());
            orderRepository.save(order);
        }
    }

    @Override
    public Order createOrders(Order order) {
        Order savedOrder = orderRepository.save(order);
        messageSender.send(UtilityMapper.getJsonString(savedOrder));
        return savedOrder;
    }

    @Override
    public List<Order> getOrders() {
        return orderRepository.findAll();
    }

    @Override
    public Order getOrder(Long id) {
        return orderRepository.findById(id).orElse(null);
    }
}
