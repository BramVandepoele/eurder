package com.switchfully.bram.eurder.repositories;

import com.switchfully.bram.eurder.instances.orders.Order;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
public class OrderRepository {
    private final Map<String, Order> orders = new HashMap<>();

    public void addOrder(Order order) {
        orders.put(order.getOrderId(), order);
    }

    public Collection<Order> getAll() {
        return new ArrayList<>(orders.values());
    }
}
