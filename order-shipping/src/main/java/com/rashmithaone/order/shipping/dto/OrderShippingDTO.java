package com.rashmithaone.order.shipping.dto;

import com.rashmithaone.order.shipping.entity.Shipping;
import jakarta.persistence.Id;
import lombok.*;

import java.util.Date;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
@Builder
public class OrderShippingDTO {

    private Integer id;
    private String trackingNumber;
    private String description;
    private Date date;
    private int quantity;
    private double orderValue;
    private Shipping shipping;
}
