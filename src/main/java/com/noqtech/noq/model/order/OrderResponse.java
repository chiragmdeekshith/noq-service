package com.noqtech.noq.model.order;

import com.noqtech.noq.entity.OrderItem;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class OrderResponse {
    private Integer orderId;
    private String userId;
    private Double totalPrice;
    private String status;
    private List<OrderItem> orderItems;
    private String message;
}
