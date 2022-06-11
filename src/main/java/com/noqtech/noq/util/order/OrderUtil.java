package com.noqtech.noq.util.order;

import com.noqtech.noq.entity.Item;

import java.util.List;

public class OrderUtil {
    public static Double calculateTotalPrice(List<Item> items) {
        Double total = 0.0;
        for (Item item : items) {
            total += item.getPrice();
        }
        return total;
    }
}
