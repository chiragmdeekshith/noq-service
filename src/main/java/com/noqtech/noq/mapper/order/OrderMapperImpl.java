package com.noqtech.noq.mapper.order;

import com.noqtech.noq.constant.OrderConstant;
import com.noqtech.noq.dto.OrderDto;
import com.noqtech.noq.entity.Order;
import com.noqtech.noq.entity.OrderItem;
import com.noqtech.noq.model.order.OrderRequest;
import com.noqtech.noq.model.order.OrderResponse;
import com.noqtech.noq.model.order.OrderStatusRequest;
import com.noqtech.noq.model.order.OrderStatusResponse;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;

@Component
public class OrderMapperImpl implements OrderMapperI {

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public OrderDto convertRequestToDto(OrderRequest orderRequest) {
        return modelMapper.map(orderRequest, OrderDto.class);
    }

    @Override
    public OrderResponse convertDtoToResponse(OrderDto orderDto) {
        return modelMapper.map(orderDto, OrderResponse.class);
    }

    @Override
    public OrderDto convertEntityToDto(Order order, List<OrderItem> orderItems) {
        //todo convert items array into dto by counting ids
        OrderDto orderDto = new OrderDto();
        if (Objects.isNull(order)) {
            orderDto.setMessage(OrderConstant.ORDER_NOT_FOUND);
        } else {
            orderDto.setOrderId(order.getOrderId());
            orderDto.setUserEmailId(order.getUserEmailId());
            orderDto.setStatus(order.getStatus());
            orderDto.setTotalPrice(order.getTotalPrice());
            if (Objects.isNull(orderItems) || orderItems.isEmpty()) {
                orderDto.setMessage(OrderConstant.ORDER_ITEMS_NOT_FOUND);
            } else {
                orderDto.setOrderItems(orderItems);
                orderDto.setMessage(OrderConstant.ORDER_AND_ITEMS_FOUND);
            }
        }
        return orderDto;
    }

    @Override
    public OrderStatusResponse convertDtoToStatusResponse(OrderDto orderDto) {
        return modelMapper.map(orderDto, OrderStatusResponse.class);
    }

    @Override
    public OrderDto convertRequestToDto(OrderStatusRequest orderStatusRequest) {
        return modelMapper.map(orderStatusRequest, OrderDto.class);
    }
}
