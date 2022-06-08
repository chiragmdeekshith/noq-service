package com.noqtech.noq.mapper.restaurant;

import com.noqtech.noq.dto.RestaurantDto;
import com.noqtech.noq.entity.Restaurant;
import com.noqtech.noq.model.restaurant.RestaurantResponse;

public interface RestaurantMapperI {
    public RestaurantDto convertEntityToDto(Restaurant restaurant);
    public RestaurantResponse convertDtoToResponse(RestaurantDto restaurantDto);
}
