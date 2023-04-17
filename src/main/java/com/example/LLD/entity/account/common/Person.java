package com.example.LLD.entity.account.common;

public class Person {
    private final String firstName;
    private final String lastName;
    private final Contact contact;
    private final Address address;

    public Person(String firstName, String lastName, Contact contact, Address address) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.contact = contact;
        this.address = address;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Contact getContact() {
        return contact;
    }

    public Address getAddress() {
        return address;
    }
}
