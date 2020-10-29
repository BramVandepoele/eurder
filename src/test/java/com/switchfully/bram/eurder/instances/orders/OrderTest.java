package com.switchfully.bram.eurder.instances.orders;

import com.switchfully.bram.eurder.instances.valueObjects.price.Currency;
import com.switchfully.bram.eurder.instances.valueObjects.price.Price;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class OrderTest {
    @Test
    void WhenCreatingNewOrder_CheckIfOrderIdIsGenerated() {
        //given
        ItemGroup itemGroup = new ItemGroup("ItemId", 3);
        List<ItemGroup> itemGroups = new ArrayList<>();
        itemGroups.add(itemGroup);
        Order order = new Order("Customer Id", itemGroups, new Price(123), LocalDate.now());
        //when

        //then
        Assertions.assertNotNull(order.getOrderId());

    }

    @Test
    void WhenCreatingNewOrder_CheckIfCustomerIdExists() {
        //given
        ItemGroup itemGroup = new ItemGroup("ItemId", 3);
        List<ItemGroup> itemGroups = new ArrayList<>();
        itemGroups.add(itemGroup);
        Order order = new Order("Customer Id", itemGroups, new Price(123), LocalDate.now());
        String expectedResult = "Customer Id";
        //when

        //then
        Assertions.assertEquals(expectedResult, order.getCustomerId());

    }

    @Test
    void WhenCreatingNewOrder_CheckIfItemGroupsIsAdded() {
        //given
        ItemGroup itemGroup = new ItemGroup("ItemId", 3);
        List<ItemGroup> itemGroups = new ArrayList<>();
        itemGroups.add(itemGroup);
        Order order = new Order("Customer Id", itemGroups, new Price(123), LocalDate.now());
        //when

        //then
        Assertions.assertNotNull(order.getItemGroups());
    }

    @Test
    void WhenCreatingNewOrder_CheckIfTotalPriceIsAdded() {
        //given
        ItemGroup itemGroup = new ItemGroup("ItemId", 3);
        List<ItemGroup> itemGroups = new ArrayList<>();
        itemGroups.add(itemGroup);
        Price price = new Price(123);
        Order order = new Order("Customer Id", itemGroups, price , LocalDate.now());
        //when

        //then
        Assertions.assertEquals(price, order.getTotalPrice());

    }

}