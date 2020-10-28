package com.switchfully.bram.eurder.instances.person;

import com.switchfully.bram.eurder.instances.valueObjects.Address;
import com.switchfully.bram.eurder.instances.valueObjects.PhoneNumber;

public class Customer extends Person {
    private final Address address;
    private final PhoneNumber phoneNumber;

    public Customer(String firstName, String lastName, String email, Address address, PhoneNumber phoneNumber) {
        super(firstName, lastName, email);
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    public Address getAddress() {
        return address;
    }

    public PhoneNumber getPhoneNumber() {
        return phoneNumber;
    }
}
