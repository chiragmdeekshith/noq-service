package com.noqtech.noq.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
public class OrderItemDto {
    private Integer orderItemId;
    private Integer itemId;
    private String itemName;
    private Integer restaurantId;
    private String restaurantName;
    private Integer quantity;
    private BigDecimal itemPrice;
    private BigDecimal totalPrice;
}
