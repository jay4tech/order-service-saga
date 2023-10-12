package com.example.order.client;

import com.example.order.model.Inventory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "inventory-service-saga", url = "http://localhost:8081/inventory")
public interface InventoryClient {

    @GetMapping("/product/{productId}")
    public Inventory getInventoryProductId(@PathVariable("productId") Long productId);
  
}