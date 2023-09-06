package com.example.order.service;

import com.example.order.entity.Order;

import java.util.List;

public interface IOrderService {
    void deleteOrder(Long id);

    void updateOrder(Order order);

    Order createOrders(Order order);

    List<Order> getOrders();

    Order getOrder(Long id);
}
