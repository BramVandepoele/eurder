package com.switchfully.bram.eurder.instances.person;

import com.switchfully.bram.eurder.instances.valueObjects.Address;
import com.switchfully.bram.eurder.instances.valueObjects.PhoneNumber;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CustomerTest {
    @Test
    void WhenCreatingNewCustomer_CheckIfIdIsGenerated() {
        //given
        Address address = new Address("FleetStreet", "666A", "London", 123456);
        PhoneNumber phoneNumber = new PhoneNumber("+32", 12345678);
        Customer customer = new Customer("Customer" , "Test", "customer@email.com", address, phoneNumber);
        //when

        //then
        Assertions.assertNotNull(customer.getId());
    }

    @Test
    void WhenCreatingNewCustomer_CheckIfFirstNameIsCorrect() {
        //given
        Address address = new Address("FleetStreet", "666A", "London", 123456);
        PhoneNumber phoneNumber = new PhoneNumber("+32", 12345678);
        Customer customer = new Customer("Customer" , "Test", "customer@email.com", address, phoneNumber);
        String expectedResult = "Customer";
        //when

        //then
        Assertions.assertEquals(expectedResult, customer.getFirstName());
    }

    @Test
    void WhenCreatingNewCustomer_CheckIfLastNameIsCorrect() {
        //given
        Address address = new Address("FleetStreet", "666A", "London", 123456);
        PhoneNumber phoneNumber = new PhoneNumber("+32", 12345678);
        Customer customer = new Customer("Customer" , "Test", "customer@email.com", address, phoneNumber);
        String expectedResult = "Test";
        //when

        //then
        Assertions.assertEquals(expectedResult, customer.getLastName());
    }

    @Test
    void WhenCreatingNewCustomer_CheckIfEmailIsCorrect() {
        //given
        Address address = new Address("FleetStreet", "666A", "London", 123456);
        PhoneNumber phoneNumber = new PhoneNumber("+32", 12345678);
        Customer customer = new Customer("Customer" , "Test", "customer@email.com", address, phoneNumber);
        String expectedResult = "customer@email.com";
        //when

        //then
        Assertions.assertEquals(expectedResult, customer.getEmail());
    }

    @Test
    void WhenCreatingNewCustomer_CheckIfAddressIsCorrect() {
        //given
        Address address = new Address("FleetStreet", "666A", "London", 123456);
        PhoneNumber phoneNumber = new PhoneNumber("+32", 12345678);
        Customer customer = new Customer("Customer" , "Test", "customer@email.com", address, phoneNumber);
        Address expectedResult = new Address("FleetStreet", "666A", "London", 123456);
        //when

        //then
        Assertions.assertEquals(expectedResult, customer.getAddress());
    }

    @Test
    void WhenCreatingNewCustomer_CheckIfPhoneNumberIsCorrect() {
        //given
        Address address = new Address("FleetStreet", "666A", "London", 123456);
        PhoneNumber phoneNumber = new PhoneNumber("+32", 12345678);
        Customer customer = new Customer("Customer" , "Test", "customer@email.com", address, phoneNumber);
        PhoneNumber expectedResult = new PhoneNumber("+32", 12345678);
        //when

        //then
        Assertions.assertEquals(expectedResult, customer.getPhoneNumber());
    }

}