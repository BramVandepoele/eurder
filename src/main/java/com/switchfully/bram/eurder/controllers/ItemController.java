package com.switchfully.bram.eurder.controllers;

import com.switchfully.bram.eurder.dto.CreateItemDto;
import com.switchfully.bram.eurder.exceptions.NotAuthorizedException;
import com.switchfully.bram.eurder.instances.Item;
import com.switchfully.bram.eurder.instances.person.Admin;
import com.switchfully.bram.eurder.instances.valueObjects.price.Price;
import com.switchfully.bram.eurder.repositories.AdminRepository;
import com.switchfully.bram.eurder.services.ItemService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.stream.Collectors;

@RestController
@RequestMapping(path = "/items")
public class ItemController {
    private final Logger myLogger = LoggerFactory.getLogger(ItemController.class);
    private final ItemService itemService;

    @Autowired
    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public void createItem(@RequestParam(required = false) String adminId, @RequestBody CreateItemDto createItemDto) throws NotAuthorizedException {
        myLogger.info("Creation of new item requested.");
        if (adminId == null || !AdminRepository.getAdministrators().containsKey(adminId)) {
            throw new NotAuthorizedException(Admin.class, "AdminId", adminId);
        }

        Price price = new Price(createItemDto.getPriceValue(), createItemDto.getCurrency());
        Item newItem = new Item(createItemDto.getName(), createItemDto.getDescription(), price, createItemDto.getAmount());
        itemService.addItem(newItem);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public Collection<GetItemDto> getAll(){
        return itemService.getAll().stream()
                .map(item -> new GetItemDto()
                .setItemId(item.getItemId())
                .setName(item.getName())
                .setDescription(item.getDescription())
                .setPrice(item.getPrice())
                .setAmount(item.getAmount()))
                .collect(Collectors.toList());
    }
}
