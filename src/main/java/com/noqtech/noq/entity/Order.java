package com.noqtech.noq.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "NOQ_ORDER")
@Getter
@Setter
@NoArgsConstructor
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ORDER_ID")
    private Integer orderId;
    @Column(name = "USER_ID")
    private String userId;
    @Column(name = "TOTAL_PRICE")
    private Double totalPrice;
    @Column(name = "STATUS")
    private String status;
}
