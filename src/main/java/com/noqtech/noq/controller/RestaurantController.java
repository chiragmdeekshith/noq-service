package com.noqtech.noq.controller;

import com.noqtech.noq.dto.RestaurantDetailDto;
import com.noqtech.noq.dto.RestaurantDto;
import com.noqtech.noq.mapper.restaurant.RestaurantMapperI;
import com.noqtech.noq.model.restaurant.RestaurantDetailResponse;
import com.noqtech.noq.model.restaurant.RestaurantResponse;
import com.noqtech.noq.service.restaurant.RestaurantServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(name = "/")
public class RestaurantController {
    @Autowired
    private RestaurantMapperI restaurantMapper;
    @Autowired
    private RestaurantServiceI restaurantService;

    @GetMapping("/v1/restaurants")
    public ResponseEntity<List<RestaurantResponse>> list() {
        List<RestaurantDto> restaurantDtoList = restaurantService.list();
        List<RestaurantResponse> restaurantResponseList = new ArrayList<>();
        for (RestaurantDto restaurantDto : restaurantDtoList) {
            restaurantResponseList.add(restaurantMapper.convertDtoToResponse(restaurantDto));
        }
        return ResponseEntity.status(HttpStatus.OK).body(restaurantResponseList);
    }

    @GetMapping("/v1/restaurant/{restaurantId}")
    public ResponseEntity<RestaurantDetailResponse> getDetails(@PathVariable("restaurantId") Integer restaurantId) {
        RestaurantDetailDto restaurantDetailDto = restaurantService.getDetails(restaurantId);
        RestaurantDetailResponse restaurantDetailResponse = restaurantMapper.convertDtoToResponse(restaurantDetailDto);
        return ResponseEntity.status(HttpStatus.OK).body(restaurantDetailResponse);
    }
}
