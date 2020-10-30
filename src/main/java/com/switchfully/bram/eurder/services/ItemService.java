package com.switchfully.bram.eurder.services;

import com.switchfully.bram.eurder.exceptions.CreationFailedException;
import com.switchfully.bram.eurder.instances.items.Item;
import com.switchfully.bram.eurder.repositories.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class ItemService {
    private final ItemRepository itemRepository;

    @Autowired
    public ItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public void addItem(Item item) {
        validateName(item);
        validateDescription(item);
        validatePrice(item);
        validateAmount(item);
        itemRepository.addItem(item);
    }

    private void validateName(Item item) {
        if(item.getName().isBlank()) throw new CreationFailedException(ItemService.class, "invalid name", item.getName());
    }

    private void validateDescription(Item item) {
        if(item.getDescription().isBlank()) throw new CreationFailedException(ItemService.class, "invalid description", item.getDescription());
    }

    private void validatePrice(Item item) {
        if(item.getPrice().getValue() <=0) throw new CreationFailedException(ItemService.class, "invalid price", item.getPrice().toString());
    }

    private void validateAmount(Item item) {
        if(item.getAmount() <= 0) throw new CreationFailedException(ItemService.class, "invalid amount", String.valueOf(item.getAmount()));
    }

    public Collection<Item> getAll() {
        return itemRepository.getAll();
    }
}
