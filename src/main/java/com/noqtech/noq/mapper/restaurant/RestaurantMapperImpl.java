package com.noqtech.noq.mapper.restaurant;

import com.noqtech.noq.constant.RestaurantDetailConstant;
import com.noqtech.noq.dto.RestaurantDetailDto;
import com.noqtech.noq.dto.RestaurantDto;
import com.noqtech.noq.entity.Item;
import com.noqtech.noq.entity.Restaurant;
import com.noqtech.noq.model.restaurant.RestaurantDetailResponse;
import com.noqtech.noq.model.restaurant.RestaurantResponse;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;

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

    @Override
    public RestaurantDetailResponse convertDtoToResponse(RestaurantDetailDto restaurantDetailDto) {
        return modelMapper.map(restaurantDetailDto, RestaurantDetailResponse.class);
    }

    @Override
    public RestaurantDetailDto convertEntityToDto(Restaurant restaurant, List<Item> items) {
        RestaurantDetailDto restaurantDetailDto = new RestaurantDetailDto();
        if (Objects.isNull(restaurant)) {
            restaurantDetailDto.setMessage(RestaurantDetailConstant.RESTAURANT_NOT_FOUND);
        } else {
            restaurantDetailDto.setRestaurantId(restaurant.getRestaurantId());
            restaurantDetailDto.setRestaurantName(restaurant.getRestaurantName());
            if (Objects.isNull(items) || items.isEmpty()) {
                restaurantDetailDto.setMessage(RestaurantDetailConstant.ITEM_NOT_FOUND);
            } else {
                restaurantDetailDto.setItems(items);
                restaurantDetailDto.setMessage(RestaurantDetailConstant.RESTAURANT_AND_ITEM_FOUND);
            }
        }
        return restaurantDetailDto;
    }
}
