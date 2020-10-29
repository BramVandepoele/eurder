package com.switchfully.bram.eurder.instances.valueObjects;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PhoneNumber that = (PhoneNumber) o;
        return phoneNumber == that.phoneNumber &&
                Objects.equals(countryCode, that.countryCode);
    }
}
