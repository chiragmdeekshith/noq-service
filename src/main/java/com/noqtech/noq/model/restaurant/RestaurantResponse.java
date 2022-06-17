package com.noqtech.noq.model.restaurant;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class RestaurantResponse {
    private Integer restaurantId;
    private String name;
    private String imageUrl;
}
