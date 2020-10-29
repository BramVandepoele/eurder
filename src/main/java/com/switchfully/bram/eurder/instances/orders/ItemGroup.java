package com.switchfully.bram.eurder.instances.orders;

import java.time.LocalDate;

public class ItemGroup {
    private final String itemID;
    private final int amount;
    private LocalDate shippingDate;

    public ItemGroup(String itemID, int amount) {
        this.itemID = itemID;
        this.amount = amount;
    }

    public String getItemID() {
        return itemID;
    }

    public int getAmount() {
        return amount;
    }
}
