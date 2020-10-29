package com.switchfully.bram.eurder.repositories;

import com.switchfully.bram.eurder.exceptions.CreationFailedException;
import com.switchfully.bram.eurder.exceptions.EntityNotFoundException;
import com.switchfully.bram.eurder.instances.Item;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class ItemRepository {
    private final Map<String, Item> items = new HashMap<>();

    public double getPrice(String itemID, int amount) {
        return (items.get(itemID).getPrice().getValue()*amount);
    }

    public void checkItemId(String itemID) {
        if(!items.containsKey(itemID)) throw new EntityNotFoundException(Item.class, "Item id does not exist", itemID);
    }

    public void addItem(Item item) {
        items.put(item.getItemId(), item);
    }

    public Collection<Item> getAll() {
        return new ArrayList<>(items.values());
    }

    public int getStock(String itemID) {
        return items.get(itemID).getAmount();
    }
}
