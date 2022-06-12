package com.noqtech.noq.service.order;

import com.noqtech.noq.constant.OrderConstant;
import com.noqtech.noq.dto.OrderDto;
import com.noqtech.noq.entity.Item;
import com.noqtech.noq.entity.Order;
import com.noqtech.noq.entity.OrderItem;
import com.noqtech.noq.mapper.order.OrderMapperI;
import com.noqtech.noq.repository.ItemRepository;
import com.noqtech.noq.repository.OrderItemRepository;
import com.noqtech.noq.repository.OrderRepository;
import com.noqtech.noq.util.order.OrderUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


@Service
public class OrderServiceImpl implements OrderServiceI {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private OrderItemRepository orderItemRepository;

    @Autowired
    private OrderMapperI orderMapper;

    @Override
    public OrderDto newOrder(OrderDto orderDto) {

        // Save Order repo
        Order order = new Order();
        order.setUserId(orderDto.getUserId());
        order.setStatus(OrderConstant.IN_PROGRESS);
        List<Item> items = getItemsFromOrderItemList(orderDto.getOrderItems());
        BigDecimal totalPrice = OrderUtil.calculateTotalPrice(items);
        order.setTotalPrice(totalPrice);
        order = orderRepository.saveAndFlush(order);

        //Save OrderItem Repo
        List<OrderItem> orderItems = new ArrayList<>();
        for (OrderItem orderItem : orderDto.getOrderItems()) {
            OrderItem orderItemToSave = new OrderItem();
            orderItemToSave.setOrderId(order.getOrderId());
            orderItemToSave.setItemId(orderItem.getItemId());
            orderItems.add(orderItemToSave);
        }
        orderItems = orderItemRepository.saveAllAndFlush(orderItems);
        orderDto = orderMapper.convertEntityToDto(order, orderItems);

        return orderDto;
    }

    @Override
    public OrderDto getOrder(Integer orderId) {
        Order order = orderRepository.findById(orderId).orElse(null);
        List<OrderItem> orderItems = null;
        if (!Objects.isNull(order)) {
            orderItems = orderItemRepository.findAllByOrderId(orderId);
        }
        OrderDto orderDto = orderMapper.convertEntityToDto(order, orderItems);
        return orderDto;
    }

    @Override
    public OrderDto getOrderStatus(Integer orderId) {
        Order order = orderRepository.findById(orderId).orElse(null);
        OrderDto orderDto = orderMapper.convertEntityToDto(order, null);
        return orderDto;
    }

    @Override
    public OrderDto setOrderStatus(OrderDto orderDto) {
        Order order = orderRepository.findById(orderDto.getOrderId()).orElse(null);
        if(!Objects.isNull(order)){
            order.setStatus(orderDto.getStatus());
            order = orderRepository.saveAndFlush(order);
        }
        orderDto = orderMapper.convertEntityToDto(order, null);
        return orderDto;
    }

    private List<Item> getItemsFromOrderItemList(List<OrderItem> orderItems) {
        List<Item> items = new ArrayList<>();
        for (OrderItem orderItem : orderItems) {
            Item item = itemRepository.findById(orderItem.getItemId()).orElse(null);
            if (Objects.nonNull(item)) {
                items.add(item);
            }
        }
        return items;
    }
}
