package com.noqtech.noq.model.order;

import com.noqtech.noq.entity.OrderItem;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class OrderRequest {
    private String userEmailId;
    private List<OrderItem> orderItems;
}
