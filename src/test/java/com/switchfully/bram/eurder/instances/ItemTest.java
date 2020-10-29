package com.switchfully.bram.eurder.instances;

import com.switchfully.bram.eurder.instances.valueObjects.price.Price;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ItemTest {
    @Test
    void WhenCreatingNewItem_CheckIfIdIsGenerated() {
        //given
        Price price = new Price(123.50);
        Item item = new Item("TestItem", "Test item", price, 3);
        //when

        //then
        Assertions.assertNotNull(item.getItemId());
    }

    @Test
    void WhenCreatingNewItem_CheckIfNameIsCorrect() {
        //given
        Price price = new Price(123.50);
        Item item = new Item("TestItem", "Test item", price, 3);
        String expectedResult = "TestItem";
        //when

        //then
        Assertions.assertEquals(expectedResult, item.getName());
    }

    @Test
    void WhenCreatingNewItem_CheckIfDescriptionIsCorrect() {
        //given
        Price price = new Price(123.50);
        Item item = new Item("TestItem", "Test item", price, 3);
        String expectedResult = "Test item";
        //when

        //then
        Assertions.assertEquals(expectedResult, item.getDescription());
    }

    @Test
    void WhenCreatingNewItem_CheckIfPriceIsCorrect() {
        //given
        Price price = new Price(123.50);
        Item item = new Item("TestItem", "Test item", price, 3);
        Price expectedResult = new Price(123.50);
        //when

        //then
        Assertions.assertEquals(expectedResult, item.getPrice());
    }

    @Test
    void WhenCreatingNewItem_CheckIfAmountIsCorrect() {
        //given
        Price price = new Price(123.50);
        Item item = new Item("TestItem", "Test item", price, 3);
        int expectedResult = 3;
        //when

        //then
        Assertions.assertEquals(expectedResult, item.getAmount());
    }
}