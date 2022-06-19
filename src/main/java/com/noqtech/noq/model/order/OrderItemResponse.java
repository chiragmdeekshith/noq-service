package com.noqtech.noq.model.order;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
public class OrderItemResponse {
    private Integer orderItemId;
    private Integer itemId;
    private String itemName;
    private Integer restaurantId;
    private String restaurantName;
    private Integer quantity;
    private BigDecimal itemPrice;
    private BigDecimal totalPrice;
}
