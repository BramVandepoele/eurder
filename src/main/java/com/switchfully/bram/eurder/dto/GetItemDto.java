package com.switchfully.bram.eurder.dto;

import com.switchfully.bram.eurder.instances.items.StockUrgency;
import com.switchfully.bram.eurder.instances.valueObjects.price.Price;

public class GetItemDto {
    private String itemId;
    private String name;
    private String Description;
    private Price price;
    private int amount;
    private StockUrgency stockUrgency;

    public StockUrgency getStockUrgency() {
        return stockUrgency;
    }

    public GetItemDto setStockUrgency(StockUrgency stockUrgency) {
        this.stockUrgency = stockUrgency;
        return this;
    }

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
