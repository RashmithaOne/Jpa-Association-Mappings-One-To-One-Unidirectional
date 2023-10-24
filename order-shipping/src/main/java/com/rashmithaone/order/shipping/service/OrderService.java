package com.rashmithaone.order.shipping.service;

import com.rashmithaone.order.shipping.dto.OrderShippingDTO;
import com.rashmithaone.order.shipping.entity.Order;
import com.rashmithaone.order.shipping.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.UUID;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public Order saveOrder(OrderShippingDTO orderShippingDTO){
        Order order = dtoToEntity(orderShippingDTO);

       return orderRepository.save(order);
    }

    private OrderShippingDTO entityToDto(Order order){

        OrderShippingDTO orderShippingDTO = new OrderShippingDTO();
        return orderShippingDTO
                .builder()
                .id(order.getId())
                .trackingNumber(UUID.randomUUID().toString().replace("-", ""))
                .description(order.getDescription())
                .date(new Date())
                .quantity(order.getQuantity())
                .orderValue(order.getOrderValue())
                .shipping(order.getShipping())
                .build();
    }

    private Order dtoToEntity(OrderShippingDTO orderShippingDTO){

        Order order = new Order();

        return order.builder()
                .id(orderShippingDTO.getId())
                .trackingNumber(UUID.randomUUID().toString().replace("-", ""))
                .description(orderShippingDTO.getDescription())
                .date(new Date())
                .quantity(orderShippingDTO.getQuantity())
                .orderValue(orderShippingDTO.getOrderValue())
                .shipping(orderShippingDTO.getShipping())
                .build();

    }
}
