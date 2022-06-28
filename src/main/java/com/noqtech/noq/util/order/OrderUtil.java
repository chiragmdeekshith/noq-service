package com.noqtech.noq.util.order;

import com.noqtech.noq.entity.Item;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class OrderUtil {
    public static BigDecimal calculateTotalPrice(List<Item> items) {
        BigDecimal total = BigDecimal.valueOf(0);
        Set<Integer> restaurantsSet = new HashSet<>();
        for (Item item : items) {
            total = total.add(item.getPrice());
            restaurantsSet.add(item.getRestaurantId());
        }

        Integer commission = 0;
        if(restaurantsSet.size() == 1) {
            commission = 60;
        }
        else if (restaurantsSet.size() > 1 && restaurantsSet.size() < 5) {
            commission = 80;
        } else if (restaurantsSet.size() >= 5 ) {
            commission = 100;
        }

        return total.add(BigDecimal.valueOf(commission));
    }
}
