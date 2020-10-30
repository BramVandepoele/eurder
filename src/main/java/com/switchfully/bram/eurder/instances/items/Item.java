package com.switchfully.bram.eurder.instances.items;

import com.switchfully.bram.eurder.instances.valueObjects.price.Price;

import java.util.UUID;

public class Item {
    private final String itemId;
    private  String name;
    private  String Description;
    private Price price;
    private int amount;
    private StockUrgency stockUrgency;

    public Item(String name, String description, Price price, int amount) {
        this.itemId = UUID.randomUUID().toString();
        this.name = name;
        Description = description;
        this.price = price;
        this.amount = amount;
        this.stockUrgency = calculateStockUrgency(amount);
    }

    public StockUrgency calculateStockUrgency(int amount) {
        if(amount < 5) return StockUrgency.STOCK_LOW;
        if(amount < 10) return StockUrgency.STOCK_MEDIUM;
        return StockUrgency.STOCK_HIGH;
    }

    public String getItemId() {
        return itemId;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return Description;
    }

    public Price getPrice() {
        return price;
    }

    public int getAmount() {
        return amount;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public void setPrice(Price price) {
        this.price = price;
    }

    public void setStockUrgency(StockUrgency stockUrgency) {
        this.stockUrgency = stockUrgency;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public StockUrgency getStockUrgency() {
        return stockUrgency;


    }
}
