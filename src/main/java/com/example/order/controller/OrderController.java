package com.example.order.controller;

import com.example.order.entity.Order;
import com.example.order.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("orders")
public class OrderController {

    @Autowired
    IOrderService orderService;

    @GetMapping("/{id}")
    public Order getOrder(@PathVariable Long id){
       return orderService.getOrder(id);
    }

    @GetMapping("/")
    public List<Order> getOrders(){
        return orderService.getOrders();
    }

    @PostMapping("/")
    public Order createOrder(@RequestBody Order order){
        return orderService.createOrders(order);
    }

    @PutMapping("/{id}")
    public void updateOrder(@RequestBody Order order){
         orderService.updateOrder(order);
    }
    @DeleteMapping("/{id}")
    public void deleteOrder(@PathVariable Long id){
         orderService.deleteOrder(id);
    }
}
