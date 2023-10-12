package com.example.order.model;

import lombok.Data;

@Data
public class Inventory {

    private Long id;
    private Long productId;
    private Long quantity;
}
