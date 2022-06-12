package com.noqtech.noq.service.restaurant;

import com.noqtech.noq.dto.RestaurantDetailDto;
import com.noqtech.noq.dto.RestaurantDto;

import java.util.List;

public interface RestaurantServiceI {
    List<RestaurantDto> list();

    RestaurantDetailDto getDetails(Integer restaurantId);
}
