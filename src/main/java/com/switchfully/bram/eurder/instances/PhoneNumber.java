package com.switchfully.bram.eurder.instances;

public class PhoneNumber {
    private final String countryCode;
    private final int phoneNumber;

    public PhoneNumber(String countryCode, int phoneNumber) {
        this.countryCode = countryCode;
        this.phoneNumber = phoneNumber;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }
}
