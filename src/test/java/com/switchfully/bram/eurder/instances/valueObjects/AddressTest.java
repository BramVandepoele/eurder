package com.switchfully.bram.eurder.instances.valueObjects;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AddressTest {
    @Test
    void WhenCreatingNewAddress_CheckIfStreetNameIsCorrect() {
        //given
        Address address = new Address("Baker street" , "221B", "London" ,1234);
        String expectedResult = "Baker street";
        //when

        //then
        Assertions.assertEquals(expectedResult, address.getStreetName());
    }

    @Test
    void WhenCreatingNewAddress_CheckIfHouseNumberIsCorrect() {
        //given
        Address address = new Address("Baker street" , "221B", "London" ,1234);
        String expectedResult = "221B";
        //when

        //then
        Assertions.assertEquals(expectedResult, address.getHouseNumber());
    }

    @Test
    void WhenCreatingNewAddress_CheckIfCityIsCorrect() {
        //given
        Address address = new Address("Baker street" , "221B", "London" ,1234);
        String expectedResult = "London";
        //when

        //then
        Assertions.assertEquals(expectedResult, address.getCity());
    }

    @Test
    void WhenCreatingNewAddress_CheckIfPostalCodeIsCorrect() {
        //given
        Address address = new Address("Baker street" , "221B", "London" ,1234);
        int expectedResult = 1234;
        //when

        //then
        Assertions.assertEquals(expectedResult, address.getPostalCode());
    }
}