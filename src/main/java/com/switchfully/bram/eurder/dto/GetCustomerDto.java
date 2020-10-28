package com.switchfully.bram.eurder.dto;

public class GetCustomerDto {
    private String firstName;
    private String lastName;
    private String email;
    private AddressDto address;
    private PhoneNumberDto phoneNumber;

    public GetCustomerDto setPhoneNumber(PhoneNumberDto phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }

    public AddressDto getAddress() {
        return address;
    }

    public GetCustomerDto setAddress(AddressDto address) {
        this.address = address;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public GetCustomerDto setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public GetCustomerDto setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public GetCustomerDto setEmail(String email) {
        this.email = email;
        return this;
    }
}
