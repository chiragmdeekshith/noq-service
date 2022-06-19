package com.noqtech.noq.model.order;

import com.noqtech.noq.entity.OrderItem;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class OrderResponse {
    private Integer orderId;
    private String userEmailId;
    private BigDecimal totalPrice;
    private String status;
    private List<OrderItemResponse> orderItemResponses;
    private String message;
}
