package com.switchfully.bram.eurder.instances;

import com.switchfully.bram.eurder.instances.valueObjects.price.Price;

import java.util.UUID;

public class Item {
    private final String itemId;
    private final String name;
    private final String Description;
    private final Price price;
    private final int amount;

    public Item(String name, String description, Price price, int amount) {
        this.itemId = UUID.randomUUID().toString();
        this.name = name;
        Description = description;
        this.price = price;
        this.amount = amount;
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
}
