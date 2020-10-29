package com.switchfully.bram.eurder.instances.valueObjects.price;

public class Price {
    private final double value;
    private final Currency currency;

    public Price(double value, Currency currency) {
        this.value = value;
        this.currency = Currency.EUR;
    }

    public double getValue() {
        return value;
    }

    public Currency getCurrency() {
        return currency;
    }

    @Override
    public String toString() {
        return value + " " + currency;
    }
}
