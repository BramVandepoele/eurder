package com.switchfully.bram.eurder.dto;

import com.switchfully.bram.eurder.instances.valueObjects.price.Price;

public class GetItemDto {
    private String itemId;
    private String name;
    private String Description;
    private Price price;
    private int amount;

    public String getItemId() {
        return itemId;
    }

    public GetItemDto setItemId(String itemId) {
        this.itemId = itemId;
        return this;
    }

    public String getName() {
        return name;
    }

    public GetItemDto setName(String name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return Description;
    }

    public GetItemDto setDescription(String description) {
        Description = description;
        return this;
    }

    public Price getPrice() {
        return price;
    }

    public GetItemDto setPrice(Price price) {
        this.price = price;
        return this;
    }

    public int getAmount() {
        return amount;
    }

    public GetItemDto setAmount(int amount) {
        this.amount = amount;
        return this;
    }
}
