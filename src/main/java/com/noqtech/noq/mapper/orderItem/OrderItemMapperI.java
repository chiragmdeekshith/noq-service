package com.noqtech.noq.mapper.orderItem;

import com.noqtech.noq.dto.OrderItemDto;
import com.noqtech.noq.entity.OrderItem;
import com.noqtech.noq.model.order.OrderItemRequest;
import com.noqtech.noq.model.order.OrderItemResponse;

import java.util.List;

public interface OrderItemMapperI {
    public List<OrderItemDto> convertRequestToDto(List<OrderItemRequest> orderItems);
    public List<OrderItemResponse> convertDtoToResponse(List<OrderItemDto> orderItemDtos);

    public List<OrderItemDto> convertEntityToDto(List<OrderItem> orderItems);
}
