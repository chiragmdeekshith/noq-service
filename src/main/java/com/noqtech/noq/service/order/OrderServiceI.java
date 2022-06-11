package com.noqtech.noq.service.order;

import com.noqtech.noq.dto.OrderDto;

public interface OrderServiceI {
    public OrderDto newOrder(OrderDto orderDto);
    public OrderDto getOrder(Integer orderId);
    public OrderDto getOrderStatus(Integer orderId);
}
