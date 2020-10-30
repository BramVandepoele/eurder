package com.switchfully.bram.eurder.dto;

import com.switchfully.bram.eurder.instances.items.StockUrgency;
import com.switchfully.bram.eurder.instances.valueObjects.price.Currency;

public class CreateItemDto {
    private String name;
    private String Description;
    private double priceValue;
    private Currency currency = Currency.EUR;
    private int amount;

    public double getPriceValue() {
        return priceValue;
    }

    public CreateItemDto setPriceValue(double priceValue) {
        this.priceValue = priceValue;
        return this;
    }

    public Currency getCurrency() {
        return currency;
    }

    public CreateItemDto setCurrency(Currency currency) {
        this.currency = currency;
        return this;
    }

    public String getName() {
        return name;
    }

    public CreateItemDto setName(String name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return Description;
    }

    public CreateItemDto setDescription(String description) {
        Description = description;
        return this;
    }

    public int getAmount() {
        return amount;
    }

    public CreateItemDto setAmount(int amount) {
        this.amount = amount;
        return this;
    }
}
