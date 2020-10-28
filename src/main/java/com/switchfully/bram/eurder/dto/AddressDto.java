package com.switchfully.bram.eurder.dto;


public class AddressDto {
    private String streetName;
    private String houseNumber;
    private String city;
    private int postalCode;

    public String getStreetName() {
        return streetName;
    }

    public AddressDto setStreetName(String streetName) {
        this.streetName = streetName;
        return this;
    }

    public String getHouseNumber() {
        return houseNumber;
    }

    public AddressDto setHouseNumber(String houseNumber) {
        this.houseNumber = houseNumber;
        return this;
    }

    public String getCity() {
        return city;
    }

    public AddressDto setCity(String city) {
        this.city = city;
        return this;
    }

    public int getPostalCode() {
        return postalCode;
    }

    public AddressDto setPostalCode(int postalCode) {
        this.postalCode = postalCode;
        return this;
    }
}
