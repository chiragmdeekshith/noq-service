package com.noqtech.noq.dto;

import com.noqtech.noq.entity.OrderItem;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class OrderDto {
    private Integer orderId;
    private String userEmailId;
    private BigDecimal totalPrice;
    private String status;
    private List<OrderItem> orderItems;
    private String message;
}
