package com.switchfully.bram.eurder.dto;

public class PhoneNumberDto {
    private String countryCode;
    private int phoneNumber;

    public String getCountryCode() {
        return countryCode;
    }

    public PhoneNumberDto setCountryCode(String countryCode) {
        this.countryCode = countryCode;
        return this;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public PhoneNumberDto setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }
}
