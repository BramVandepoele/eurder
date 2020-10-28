package com.switchfully.bram.eurder.dto;

public class GetCustomerInfoDto {
    private String id;
    private String firstName;
    private String lastName;
    private String email;
    private AddressDto address;
    private PhoneNumberDto phoneNumber;

    public String getId() {
        return id;
    }

    public GetCustomerInfoDto setId(String id) {
        this.id = id;
        return this;
    }

    public GetCustomerInfoDto setPhoneNumber(PhoneNumberDto phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }

    public AddressDto getAddress() {
        return address;
    }

    public GetCustomerInfoDto setAddress(AddressDto address) {
        this.address = address;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public GetCustomerInfoDto setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public GetCustomerInfoDto setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public GetCustomerInfoDto setEmail(String email) {
        this.email = email;
        return this;
    }
}
