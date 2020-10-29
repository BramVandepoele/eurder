package com.switchfully.bram.eurder.services;

import com.switchfully.bram.eurder.exceptions.CreationFailedException;
import com.switchfully.bram.eurder.instances.orders.Order;
import com.switchfully.bram.eurder.repositories.CustomerRepository;
import com.switchfully.bram.eurder.repositories.ItemRepository;
import com.switchfully.bram.eurder.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class OrderService {
    private final OrderRepository orderRepository;
    public final ItemRepository itemRepository;
    public final CustomerRepository customerRepository;

    @Autowired
    public OrderService(OrderRepository orderRepository, ItemRepository itemRepository, CustomerRepository customerRepository) {
        this.orderRepository = orderRepository;
        this.itemRepository = itemRepository;
        this.customerRepository = customerRepository;
    }

    public void addOrder(Order order) {
        validateItemGroups(order);
        orderRepository.addOrder(order);

    }

    private void validateItemGroups(Order order) {
        if(order.getItemGroups().size() == 0) throw new CreationFailedException(OrderService.class, "order is empty");
    }

    public Collection<Order> getAll() {
        return orderRepository.getAll();
    }

    public double calculatePrice(String itemID, int amount) {
        return itemRepository.getPrice(itemID, amount);
    }

    public int getStock(String itemID) {
        return itemRepository.getStock(itemID);
    }

    public void checkCustomerId(String customerId) {
        customerRepository.getById(customerId);
    }

    public void checkItemId(String itemID) {
        itemRepository.checkItemId(itemID);
    }
}
