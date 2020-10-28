package com.switchfully.bram.eurder.dto;

public class GetCustomerDto {
    private String id;
    private String firstName;
    private String lastName;

    public String getId() {
        return id;
    }

    public GetCustomerDto setId(String id) {
        this.id = id;
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
}
