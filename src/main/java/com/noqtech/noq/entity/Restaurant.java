package com.noqtech.noq.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Restaurant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "RESTAURANT_ID")
    private Integer restaurantId;
    @Column(name = "NAME")
    private String name;
    @Column(name = "IMAGE_URL")
    private String imageUrl;
}
