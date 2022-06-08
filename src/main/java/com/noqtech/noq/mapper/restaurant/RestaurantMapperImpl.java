package com.noqtech.noq.mapper.restaurant;

import com.noqtech.noq.dto.RestaurantDto;
import com.noqtech.noq.entity.Restaurant;
import com.noqtech.noq.model.restaurant.RestaurantResponse;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RestaurantMapperImpl implements RestaurantMapperI {

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public RestaurantDto convertEntityToDto(Restaurant restaurant) {
        return modelMapper.map(restaurant, RestaurantDto.class);
    }

    @Override
    public RestaurantResponse convertDtoToResponse(RestaurantDto restaurantDto) {
        return modelMapper.map(restaurantDto, RestaurantResponse.class);
    }
}
