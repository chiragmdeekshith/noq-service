package com.noqtech.noq.mapper.orderItem;

import com.noqtech.noq.dto.OrderItemDto;
import com.noqtech.noq.entity.Item;
import com.noqtech.noq.entity.OrderItem;
import com.noqtech.noq.entity.Restaurant;
import com.noqtech.noq.model.order.OrderItemRequest;
import com.noqtech.noq.model.order.OrderItemResponse;
import com.noqtech.noq.repository.ItemRepository;
import com.noqtech.noq.repository.RestaurantRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Component
public class OrderItemMapperImpl implements OrderItemMapperI{

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private RestaurantRepository restaurantRepository;

    @Override
    public List<OrderItemDto> convertRequestToDto(List<OrderItemRequest> orderItemRequests) {
        List<OrderItemDto> orderItemDtos = new ArrayList<>();
        for(OrderItemRequest orderItemRequest: orderItemRequests){
            OrderItemDto orderItemDto = new OrderItemDto();
            orderItemDto.setItemId(orderItemRequest.getItemId());
            orderItemDto.setQuantity(orderItemRequest.getQuantity());
            orderItemDtos.add(orderItemDto);
        }
        return orderItemDtos;
    }

    @Override
    public List<OrderItemResponse> convertDtoToResponse(List<OrderItemDto> orderItemDtos) {
        List<OrderItemResponse> orderItemResponses = new ArrayList<>();
        for(OrderItemDto orderItemDto: orderItemDtos){
            orderItemResponses.add(modelMapper.map(orderItemDto, OrderItemResponse.class));
        }
        return orderItemResponses;
    }

    @Override
    public List<OrderItemDto> convertEntityToDto(List<OrderItem> orderItems) {
        List<OrderItemDto> orderItemDtos = new ArrayList<>();
        Item item = null;
        Restaurant restaurant = null;
        for(OrderItem orderItem: orderItems){
            OrderItemDto orderItemDto = new OrderItemDto();
            orderItemDto.setOrderItemId(orderItem.getOrderItemId());
            orderItemDto.setQuantity(orderItem.getQuantity());
            orderItemDto.setItemId(orderItem.getItemId());

            item = itemRepository.findById(orderItemDto.getItemId()).orElse(null);
            if(Objects.nonNull(item)){
                orderItemDto.setItemName(item.getName());
                orderItemDto.setItemPrice(item.getPrice());
                orderItemDto.setRestaurantId(item.getRestaurantId());
                orderItemDto.setTotalPrice(orderItemDto.getItemPrice().multiply(BigDecimal.valueOf(orderItemDto.getQuantity())));
            }
            if(Objects.nonNull(orderItemDto.getRestaurantId())){
                restaurant = restaurantRepository.findById(orderItemDto.getRestaurantId()).orElse(null);
            }
            if(Objects.nonNull(restaurant)){
                orderItemDto.setRestaurantName(restaurant.getName());
            }
            orderItemDtos.add(orderItemDto);
        }
        return orderItemDtos;
    }
}
