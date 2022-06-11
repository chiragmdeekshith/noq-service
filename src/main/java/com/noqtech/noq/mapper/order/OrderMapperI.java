package com.noqtech.noq.mapper.order;

import com.noqtech.noq.dto.OrderDto;
import com.noqtech.noq.entity.Order;
import com.noqtech.noq.entity.OrderItem;
import com.noqtech.noq.model.order.OrderRequest;
import com.noqtech.noq.model.order.OrderResponse;
import com.noqtech.noq.model.order.OrderStatusResponse;

import java.util.List;

public interface OrderMapperI {
    public OrderDto convertRequestToDto(OrderRequest orderRequest);

    public OrderResponse convertDtoToResponse(OrderDto orderDto);

    public OrderDto convertEntityToDto(Order order, List<OrderItem> orderItems);

    public OrderStatusResponse convertDtoToStatusResponse(OrderDto orderDto);
}
