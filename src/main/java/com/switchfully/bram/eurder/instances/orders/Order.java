package com.switchfully.bram.eurder.instances.orders;

import com.switchfully.bram.eurder.instances.valueObjects.price.Price;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public class Order {
    private final String orderId;
    private final String customerId;
    private final List<ItemGroup> itemGroups;
    private final Price totalPrice;
    private final LocalDate shippingdate;

    public Order(String customerId, List<ItemGroup> itemGroups, Price totalPrice, LocalDate shippingdate) {
        this.shippingdate = shippingdate;
        this.orderId = UUID.randomUUID().toString();
        this.customerId = customerId;
        this.itemGroups = itemGroups;
        this.totalPrice = totalPrice;
    }

    public List<ItemGroup> getItemGroups() {
        return itemGroups;
    }

    public String getOrderId() {
        return orderId;
    }

    public String getCustomerId() {
        return customerId;
    }

    public Price getTotalPrice() {
        return totalPrice;
    }

    public LocalDate getShippingdate() {
        return shippingdate;
    }
}
