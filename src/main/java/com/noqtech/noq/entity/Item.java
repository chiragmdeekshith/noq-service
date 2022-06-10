package com.noqtech.noq.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ITEM_ID")
    private Integer itemId;
    @Column(name = "RESTAURANT_ID")
    private Integer restaurantId;
    @Column(name = "NAME")
    private String name;
    @Column(name = "PRICE")
    private Double price;
}
