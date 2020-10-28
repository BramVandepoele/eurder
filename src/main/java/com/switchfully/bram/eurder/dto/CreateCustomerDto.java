package com.switchfully.bram.eurder.dto;

public class CreateCustomerDto {
    private String firstName;
    private String lastName;
    private String email;
    private String streetName;
    private String houseNumber;
    private String city;
    private int postalCode;
    private String countryCode;
    private int phoneNumber;

    public String getFirstName() {
        return firstName;
    }

    public CreateCustomerDto setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public CreateCustomerDto setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public CreateCustomerDto setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getStreetName() {
        return streetName;
    }

    public CreateCustomerDto setStreetName(String streetName) {
        this.streetName = streetName;
        return this;
    }

    public String getHouseNumber() {
        return houseNumber;
    }

    public CreateCustomerDto setHouseNumber(String houseNumber) {
        this.houseNumber = houseNumber;
        return this;
    }

    public String getCity() {
        return city;
    }

    public CreateCustomerDto setCity(String city) {
        this.city = city;
        return this;
    }

    public int getPostalCode() {
        return postalCode;
    }

    public CreateCustomerDto setPostalCode(int postalCode) {
        this.postalCode = postalCode;
        return this;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public CreateCustomerDto setCountryCode(String countryCode) {
        this.countryCode = countryCode;
        return this;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public CreateCustomerDto setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }
}
