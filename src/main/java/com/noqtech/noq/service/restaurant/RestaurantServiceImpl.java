package com.noqtech.noq.service.restaurant;

import com.noqtech.noq.dto.RestaurantDto;
import com.noqtech.noq.entity.Restaurant;
import com.noqtech.noq.mapper.restaurant.RestaurantMapperI;
import com.noqtech.noq.repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RestaurantServiceImpl implements RestaurantServiceI {

    @Autowired
    private RestaurantMapperI restaurantMapper;
    @Autowired
    private RestaurantRepository restaurantRepository;

    @Override
    public List<RestaurantDto> list() {
        List<Restaurant> restaurantList = restaurantRepository.findAll();
        List<RestaurantDto> restaurantDtoList = new ArrayList<>();
        for (Restaurant restaurant : restaurantList) {
            restaurantDtoList.add(restaurantMapper.convertEntityToDto(restaurant));
        }
        return restaurantDtoList;
    }
}
