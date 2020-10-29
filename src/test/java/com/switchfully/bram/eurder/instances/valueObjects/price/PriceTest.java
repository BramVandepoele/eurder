package com.switchfully.bram.eurder.instances.valueObjects.price;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PriceTest {
    @Test
    void WhenCreatingNewPrice_CheckIfValueIsCorrect() {
        //given
        Price price = new Price(123.50);
        double expectedResult = 123.50;
        //when

        //then
        Assertions.assertEquals(expectedResult, price.getValue());

    }

    @Test
    void WhenCreatingNewPrice_CheckIfCurrencyIsAdded() {
        //given
        Price price = new Price(123.50);
        //when

        //then
        Assertions.assertNotNull(price.getCurrency());

    }
}