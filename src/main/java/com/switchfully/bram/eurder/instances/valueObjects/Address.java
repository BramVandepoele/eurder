package com.switchfully.bram.eurder.instances.valueObjects;

public class Address {
    private final String streetName;
    private final String houseNumber;
    private final String city;
    private final int postalCode;

    public Address(String streetName, String houseNumber, String city, int postalCode) {
        this.streetName = streetName;
        this.houseNumber = houseNumber;
        this.city = city;
        this.postalCode = postalCode;
    }

    public String getStreetName() {
        return streetName;
    }

    public String getHouseNumber() {
        return houseNumber;
    }

    public String getCity() {
        return city;
    }

    public int getPostalCode() {
        return postalCode;
    }
}
