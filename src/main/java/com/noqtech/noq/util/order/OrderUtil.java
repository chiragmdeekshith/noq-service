package com.noqtech.noq.util.order;

import com.noqtech.noq.entity.Item;

import java.math.BigDecimal;
import java.util.List;

public class OrderUtil {
    public static BigDecimal calculateTotalPrice(List<Item> items) {
        BigDecimal total = BigDecimal.valueOf(0);
        for (Item item : items) {
            total = total.add(item.getPrice());
        }
        return total;
    }
}
