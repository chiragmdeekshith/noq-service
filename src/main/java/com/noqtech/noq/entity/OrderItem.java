package com.noqtech.noq.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class OrderItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ORDER_ITEM_ID")
    private Integer orderItemId;
    @Column(name = "ORDER_ID")
    private Integer orderId;
    @Column(name = "ITEM_ID")
    private Integer itemId;


}
