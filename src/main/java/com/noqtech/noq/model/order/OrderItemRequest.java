package com.noqtech.noq.model.order;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class OrderItemRequest {
    private Integer itemId;
    private Integer quantity;
}
