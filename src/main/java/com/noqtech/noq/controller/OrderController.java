package com.noqtech.noq.controller;

import com.noqtech.noq.dto.OrderDto;
import com.noqtech.noq.mapper.order.OrderMapperI;
import com.noqtech.noq.model.order.OrderRequest;
import com.noqtech.noq.model.order.OrderResponse;
import com.noqtech.noq.model.order.OrderStatusResponse;
import com.noqtech.noq.service.order.OrderServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(name = "/")
public class OrderController {

    @Autowired
    private OrderMapperI orderMapper;

    @Autowired
    private OrderServiceI orderService;

    @PostMapping("/v1/order/newOrder")
    public ResponseEntity<OrderResponse> newOrder(@RequestBody OrderRequest orderRequest) {
        OrderDto orderDto = orderMapper.convertRequestToDto(orderRequest);
        orderDto = orderService.newOrder(orderDto);
        OrderResponse orderResponse = orderMapper.convertDtoToResponse(orderDto);
        return ResponseEntity.status(HttpStatus.OK).body(orderResponse);
    }

    @GetMapping("/v1/order/detail/{orderId}")
    public ResponseEntity<OrderResponse> getOrder(@PathVariable("orderId") Integer orderId){
        OrderDto orderDto = orderService.getOrder(orderId);
        OrderResponse orderResponse = orderMapper.convertDtoToResponse(orderDto);
        return ResponseEntity.status(HttpStatus.OK).body(orderResponse);
    }

    @GetMapping("/v1/order/status/{orderId}")
    public ResponseEntity<OrderStatusResponse> getOrderStatus(@PathVariable("orderId") Integer orderId){
        OrderDto orderDto = orderService.getOrderStatus(orderId);
        OrderStatusResponse orderStatusResponse = orderMapper.convertDtoToStatusResponse(orderDto);
        return ResponseEntity.status(HttpStatus.OK).body(orderStatusResponse);
    }

    //todo set status
}
