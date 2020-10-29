package com.switchfully.bram.eurder.instances.orders;

import com.switchfully.bram.eurder.exceptions.CreationFailedException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ItemGroupTest {
    @Test
    void WhenCreatingNewItemGroup_CheckIfItemIdExists() {
        //given
        ItemGroup newItemGroup = new ItemGroup("ItemId", 4);
        //when
        String expectedResult = "ItemId";
        //then
        Assertions.assertEquals(expectedResult, newItemGroup.getItemID());

    }

    @Test
    void WhenCreatingNewItemGroup_CheckIfAmountExists() {
        //given
        ItemGroup newItemGroup = new ItemGroup("ItemId", 4);
        //when
        int expectedResult = 4;
        //then
        Assertions.assertEquals(expectedResult, newItemGroup.getAmount());
    }

    @Test
    void WhenCreatingNewItemGroup_WhenAmountSmallerThanZero_ThrowException() {
        //given

        //when

        //then
        Assertions.assertThrows(CreationFailedException.class, () ->new ItemGroup("ItemId", -2));

    }
}