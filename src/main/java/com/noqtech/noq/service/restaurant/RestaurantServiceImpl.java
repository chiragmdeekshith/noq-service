package com.noqtech.noq.service.restaurant;

import com.noqtech.noq.dto.RestaurantDetailDto;
import com.noqtech.noq.dto.RestaurantDto;
import com.noqtech.noq.entity.Item;
import com.noqtech.noq.entity.Restaurant;
import com.noqtech.noq.mapper.restaurant.RestaurantMapperI;
import com.noqtech.noq.repository.ItemRepository;
import com.noqtech.noq.repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class RestaurantServiceImpl implements RestaurantServiceI {

    @Autowired
    private RestaurantMapperI restaurantMapper;
    @Autowired
    private RestaurantRepository restaurantRepository;

    @Autowired
    private ItemRepository itemRepository;

    @Override
    public List<RestaurantDto> list() {
        List<Restaurant> restaurantList = restaurantRepository.findAll();
        List<RestaurantDto> restaurantDtoList = new ArrayList<>();
        for (Restaurant restaurant : restaurantList) {
            restaurantDtoList.add(restaurantMapper.convertEntityToDto(restaurant));
        }
        return restaurantDtoList;
    }

    @Override
    public RestaurantDetailDto getDetails(Integer restaurantId) {
        Restaurant restaurant = restaurantRepository.findById(restaurantId).orElse(null);
        List<Item> items = null;
        if (Objects.nonNull(restaurant)) {
            items = itemRepository.findAllByRestaurantId(restaurantId);
        }
        RestaurantDetailDto restaurantDetailDto = restaurantMapper.convertEntityToDto(restaurant, items);
        return restaurantDetailDto;
    }
}
