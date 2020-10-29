package com.switchfully.bram.eurder.controllers;

import com.switchfully.bram.eurder.dto.CreateOrderDto;
import com.switchfully.bram.eurder.dto.GetOrderDto;
import com.switchfully.bram.eurder.exceptions.CreationFailedException;
import com.switchfully.bram.eurder.instances.orders.ItemGroup;
import com.switchfully.bram.eurder.instances.orders.Order;
import com.switchfully.bram.eurder.instances.valueObjects.price.Price;
import com.switchfully.bram.eurder.services.OrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(path = "/orders")
public class OrderController {
    private final Logger myLogger = LoggerFactory.getLogger(OrderController.class);
    private final OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public void createOrder(@RequestBody CreateOrderDto createOrderDto) {
        myLogger.info("Creation of new order requested");
        checkCustomerId(createOrderDto.getCustomerId());
        for (ItemGroup itemGroup : createOrderDto.getItemGroups()) {
            checkItemId(itemGroup.getItemID());
            checkAmount(itemGroup.getAmount());
        }
        Order newOrder = new Order(createOrderDto.getCustomerId(), createOrderDto.getItemGroups(), calculateTotalPrice(createOrderDto.getItemGroups()), calculateShippingDate(createOrderDto.getItemGroups()));
        orderService.addOrder(newOrder);
    }

    private void checkItemId(String itemID) {
        orderService.checkItemId(itemID);
    }

    private void checkCustomerId(String customerId) {
        orderService.checkCustomerId(customerId);
    }

    private void checkAmount(int amount){
        if (amount <= 0) throw new CreationFailedException(OrderController.class, "amount invalid", String.valueOf(amount));
    }

    private LocalDate calculateShippingDate(List<ItemGroup> itemGroups) {
        for (ItemGroup itemGroup : itemGroups) {
            if (itemGroup.getAmount() > orderService.getStock(itemGroup.getItemID())) {
                return LocalDate.now().plusDays(7);
            }
        }
        return LocalDate.now().plusDays(1);
    }

    private Price calculateTotalPrice(List<ItemGroup> itemGroups) {
        double total = 0;
        for (ItemGroup itemGroup : itemGroups) {
            total += orderService.calculatePrice(itemGroup.getItemID(), itemGroup.getAmount());
        }
        return new Price(total);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public Collection<GetOrderDto> getAll() {
        myLogger.info("List of all orders was requested");
        return orderService.getAll().stream()
                .map(order -> new GetOrderDto()
                        .setOrderId(order.getOrderId())
                        .setCustomerId(order.getCustomerId())
                        .setItemGroups(order.getItemGroups())
                        .setTotalPrice(order.getTotalPrice())
                        .setShippingDate(order.getShippingdate()))
                .collect(Collectors.toList());
    }
}
