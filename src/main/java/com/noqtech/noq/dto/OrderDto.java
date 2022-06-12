package com.noqtech.noq.dto;

import com.noqtech.noq.entity.OrderItem;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class OrderDto {
    private Integer orderId;
    private String userId;
    private Double totalPrice;
    private String status;
    private List<OrderItem> orderItems;
    private String message;
}
