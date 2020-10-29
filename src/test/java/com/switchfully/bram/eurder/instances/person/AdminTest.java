package com.switchfully.bram.eurder.instances.person;

import com.switchfully.bram.eurder.instances.orders.ItemGroup;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AdminTest {
    @Test
    void WhenCreatingNewAdmin_CheckIfIdIsGenerated() {
        //given
        Admin admin = new Admin("Admin" , "Administrator", "admin@email.com");
        //when

        //then
        Assertions.assertNotNull(admin.getId());
    }

    @Test
    void WhenCreatingNewAdmin_CheckIfFirstNameIsCorrect() {
        //given
        Admin admin = new Admin("Admin" , "Administrator", "admin@email.com");
        String expectedResult = "Admin";
        //when

        //then
        Assertions.assertEquals(expectedResult, admin.getFirstName());
    }

    @Test
    void WhenCreatingNewAdmin_CheckIfLastNameIsCorrect() {
        //given
        Admin admin = new Admin("Admin" , "Administrator", "admin@email.com");
        String expectedResult = "Administrator";
        //when

        //then
        Assertions.assertEquals(expectedResult, admin.getLastName());
    }

    @Test
    void WhenCreatingNewAdmin_CheckIfEmailIsCorrect() {
        //given
        Admin admin = new Admin("Admin" , "Administrator", "admin@email.com");
        String expectedResult = "admin@email.com";
        //when

        //then
        Assertions.assertEquals(expectedResult, admin.getEmail());
    }

}