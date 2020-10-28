package com.switchfully.bram.eurder.repositories;

import com.switchfully.bram.eurder.instances.Item;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class ItemRepository {
    private final Map<String, Item> items = new HashMap<>();

    public void addItem(Item item) {
        items.put(item.getItemId(), item);
    }
}
