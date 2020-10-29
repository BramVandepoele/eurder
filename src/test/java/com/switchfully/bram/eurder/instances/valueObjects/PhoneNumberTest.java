package com.switchfully.bram.eurder.instances.valueObjects;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PhoneNumberTest {
    @Test
    void WhenCreatingNewPhoneNumber_CheckIfCountryCodeIsCorrect() {
        //given
        PhoneNumber phoneNumber = new PhoneNumber("+32", 12345678);
        String expectedResult = "+32";
        //when

        //then
        Assertions.assertEquals(expectedResult, phoneNumber.getCountryCode());
    }

    @Test
    void WhenCreatingNewPhoneNumber_CheckIfNumberIsCorrect() {
        //given
        PhoneNumber phoneNumber = new PhoneNumber("+32", 12345678);
        int expectedResult = 12345678;
        //when

        //then
        Assertions.assertEquals(expectedResult, phoneNumber.getPhoneNumber());
    }
}