package com.switchfully.bram.eurder.instances.valueObjects.price;

import java.util.Objects;

public class Price {
    private final double value;
    private final Currency currency;

    public Price(double value) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Price price = (Price) o;
        return Double.compare(price.value, value) == 0 &&
                currency == price.currency;
    }
}
