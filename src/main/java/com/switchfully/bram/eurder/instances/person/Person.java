package com.switchfully.bram.eurder.instances.person;

import java.util.UUID;

public class Person {
    private final String id;
    private final String firstName;
    private final String lastName;
    private final String email;

    public Person(String firstName, String lastName, String email) {
        this.id = UUID.randomUUID().toString();
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getId() {
        return id;
    }
}
