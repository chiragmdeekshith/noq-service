package com.noqtech.noq.mapper.restaurant;

import com.noqtech.noq.dto.RestaurantDetailDto;
import com.noqtech.noq.dto.RestaurantDto;
import com.noqtech.noq.entity.Item;
import com.noqtech.noq.entity.Restaurant;
import com.noqtech.noq.model.restaurant.RestaurantDetailResponse;
import com.noqtech.noq.model.restaurant.RestaurantResponse;

import java.util.List;

public interface RestaurantMapperI {
    public RestaurantDto convertEntityToDto(Restaurant restaurant);
    public RestaurantResponse convertDtoToResponse(RestaurantDto restaurantDto);
    public RestaurantDetailResponse convertDtoToResponse(RestaurantDetailDto restaurantDetailDto);
    public RestaurantDetailDto convertEntityToDto(Restaurant restaurant, List<Item> items);
}
