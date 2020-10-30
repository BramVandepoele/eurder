package com.switchfully.bram.eurder.instances.items;

import com.switchfully.bram.eurder.instances.valueObjects.price.Price;

import java.util.UUID;

public class Item {
    private final String itemId;
    private final String name;
    private final String Description;
    private final Price price;
    private final int amount;
    private final StockUrgency stockUrgency;

    public Item(String name, String description, Price price, int amount) {
        this.itemId = UUID.randomUUID().toString();
        this.name = name;
        Description = description;
        this.price = price;
        this.amount = amount;
        this.stockUrgency = setStockUrgency(amount);
    }

    private StockUrgency setStockUrgency(int amount) {
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

    public StockUrgency getStockUrgency() {
        return stockUrgency;
    }
}
