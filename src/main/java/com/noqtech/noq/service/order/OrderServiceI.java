package com.noqtech.noq.service.order;

import com.noqtech.noq.dto.OrderDto;

import java.util.List;

public interface OrderServiceI {
    public OrderDto newOrder(OrderDto orderDto);

    public OrderDto getOrder(Integer orderId);

    public OrderDto getOrderStatus(Integer orderId);

    public OrderDto setOrderStatus(OrderDto orderDto);

    public List<OrderDto> getOrdersByUser(String userEmailId);
}
