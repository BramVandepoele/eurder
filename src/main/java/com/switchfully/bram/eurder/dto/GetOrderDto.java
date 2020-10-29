package com.switchfully.bram.eurder.dto;

import com.switchfully.bram.eurder.instances.orders.ItemGroup;
import com.switchfully.bram.eurder.instances.valueObjects.price.Price;

import java.time.LocalDate;
import java.util.List;

public class GetOrderDto {
    private String orderId;
    private String customerId;
    private List<ItemGroup> itemGroups;
    private Price totalPrice;
    private LocalDate shippingDate;

    public LocalDate getShippingDate() {
        return shippingDate;
    }

    public GetOrderDto setShippingDate(LocalDate shippingDate) {
        this.shippingDate = shippingDate;
        return this;
    }

    public String getOrderId() {
        return orderId;
    }

    public GetOrderDto setOrderId(String orderId) {
        this.orderId = orderId;
        return this;
    }

    public String getCustomerId() {
        return customerId;
    }

    public GetOrderDto setCustomerId(String customerId) {
        this.customerId = customerId;
        return this;
    }

    public List<ItemGroup> getItemGroups() {
        return itemGroups;
    }

    public GetOrderDto setItemGroups(List<ItemGroup> itemGroups) {
        this.itemGroups = itemGroups;
        return this;
    }

    public Price getTotalPrice() {
        return totalPrice;
    }

    public GetOrderDto setTotalPrice(Price totalPrice) {
        this.totalPrice = totalPrice;
        return this;
    }
}
