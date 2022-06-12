package com.noqtech.noq.dto;

import com.noqtech.noq.entity.Item;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class RestaurantDetailDto {
    private Integer restaurantId;
    private String restaurantName;
    private List<Item> items;
    private String message;
}
