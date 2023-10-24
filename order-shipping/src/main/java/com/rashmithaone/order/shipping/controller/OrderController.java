package com.rashmithaone.order.shipping.controller;

import com.rashmithaone.order.shipping.dto.OrderShippingDTO;
import com.rashmithaone.order.shipping.entity.Order;
import com.rashmithaone.order.shipping.service.OrderService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/orders")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping("/insert")
    public ResponseEntity<Order> saveOrder(@RequestBody OrderShippingDTO orderShippingDTO){
        return new ResponseEntity<>(orderService.saveOrder(orderShippingDTO), HttpStatus.CREATED);
    }
}
