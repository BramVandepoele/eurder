package com.switchfully.bram.eurder.instances.orders;

import com.switchfully.bram.eurder.exceptions.CreationFailedException;

import java.time.LocalDate;

public class ItemGroup {
    private final String itemID;
    private final int amount;
    private LocalDate shippingDate;

    public ItemGroup(String itemID, int amount) {
        this.itemID = itemID;
        this.amount = checkOrderAmount(amount);
    }

    private int checkOrderAmount(int amount) {
        if(amount <=0) throw new CreationFailedException(ItemGroup.class, "amount not valid", String.valueOf(amount));
        return amount;
    }

    public String getItemID() {
        return itemID;
    }

    public int getAmount() {
        return amount;
    }
}
