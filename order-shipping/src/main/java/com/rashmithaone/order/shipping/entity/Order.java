package com.rashmithaone.order.shipping.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import java.util.Date;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Builder
@ToString
@JsonIgnoreProperties({"hibernateLazyInitializer"})
//@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private String trackingNumber;
    private String description;
    private Date date;
    private int quantity;
    private double orderValue;
    @OneToOne(targetEntity = Shipping.class, cascade = CascadeType.ALL)
    private Shipping shipping;

}
