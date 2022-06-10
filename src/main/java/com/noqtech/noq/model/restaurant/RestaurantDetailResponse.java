package com.noqtech.noq.model.restaurant;

import com.noqtech.noq.entity.Item;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class RestaurantDetailResponse {
    private String restaurantName;
    private List<Item> items;
    private String message;
}
