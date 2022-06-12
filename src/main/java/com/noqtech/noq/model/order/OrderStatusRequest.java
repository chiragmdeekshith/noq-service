package com.noqtech.noq.model.order;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class OrderStatusRequest {
    private Integer orderId;
    private String status;
}
