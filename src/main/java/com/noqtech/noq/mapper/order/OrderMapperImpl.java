package com.noqtech.noq.mapper.order;

import com.noqtech.noq.constant.OrderConstant;
import com.noqtech.noq.dto.OrderDto;
import com.noqtech.noq.entity.Order;
import com.noqtech.noq.entity.OrderItem;
import com.noqtech.noq.mapper.orderItem.OrderItemMapperI;
import com.noqtech.noq.model.order.OrderRequest;
import com.noqtech.noq.model.order.OrderResponse;
import com.noqtech.noq.model.order.OrderStatusRequest;
import com.noqtech.noq.model.order.OrderStatusResponse;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Component
public class OrderMapperImpl implements OrderMapperI {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private OrderItemMapperI orderItemMapper;

    @Override
    public OrderDto convertRequestToDto(OrderRequest orderRequest) {
        OrderDto orderDto = new OrderDto();
        orderDto.setUserEmailId(orderRequest.getUserEmailId());
        orderDto.setOrderItemDtos(orderItemMapper.convertRequestToDto(orderRequest.getOrderItemRequests()));
        return orderDto;
    }

    @Override
    public OrderResponse convertDtoToResponse(OrderDto orderDto) {
        OrderResponse orderResponse = new OrderResponse();
        orderResponse.setOrderId(orderDto.getOrderId());
        orderResponse.setUserEmailId(orderDto.getUserEmailId());
        orderResponse.setTotalPrice(orderDto.getTotalPrice());
        orderResponse.setStatus(orderDto.getStatus());
        orderResponse.setMessage(orderDto.getMessage());
        orderResponse.setOrderItemResponses(orderItemMapper.convertDtoToResponse(orderDto.getOrderItemDtos()));
        return orderResponse;
    }

    @Override
    public List<OrderResponse> convertDtoToResponse(List<OrderDto> orderDtos) {
        List<OrderResponse> orderResponses = new ArrayList<>();
        for (OrderDto orderDto: orderDtos) {
            orderResponses.add(this.convertDtoToResponse(orderDto));
        }
        return orderResponses;
    }

    @Override
    public OrderDto convertEntityToDto(Order order, List<OrderItem> orderItems) {
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
                orderDto.setOrderItemDtos(orderItemMapper.convertEntityToDto(orderItems));
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
