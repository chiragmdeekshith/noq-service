package com.noqtech.noq.repository;

import com.noqtech.noq.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemRepository extends JpaRepository<Item, Integer> {
    List<Item> findAllByRestaurantId(Integer restaurantId);
}
