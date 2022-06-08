package com.noqtech.noq.controller;

import com.noqtech.noq.dto.RestaurantDto;
import com.noqtech.noq.mapper.restaurant.RestaurantMapperI;
import com.noqtech.noq.model.restaurant.RestaurantResponse;
import com.noqtech.noq.service.restaurant.RestaurantServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(name = "/v1/restaurant")
public class RestaurantController {
    @Autowired
    private RestaurantMapperI restaurantMapper;
    @Autowired
    private RestaurantServiceI restaurantService;

    @GetMapping("/v1/restaurant/list")
    public ResponseEntity<List<RestaurantResponse>> list() {
        List<RestaurantDto> restaurantDtoList = restaurantService.list();
        List<RestaurantResponse> restaurantResponseList = new ArrayList<>();
        for (RestaurantDto restaurantDto : restaurantDtoList) {
            restaurantResponseList.add(restaurantMapper.convertDtoToResponse(restaurantDto));
        }
        return ResponseEntity.status(HttpStatus.OK).body(restaurantResponseList);
    }
}
