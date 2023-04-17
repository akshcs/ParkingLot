package com.example.LLD.entity.account.common;

public class Address {
    private final String city;
    private final String zipCode;
    private final String country;
    private final String state;
    private final String AddressLine1;
    private final String AddressLine2;

    public Address(String city, String zipCode, String country, String state, String addressLine1, String addressLine2) {
        this.city = city;
        this.zipCode = zipCode;
        this.country = country;
        this.state = state;
        AddressLine1 = addressLine1;
        AddressLine2 = addressLine2;
    }

    public String getZipCode() {
        return zipCode;
    }

    public String getCountry() {
        return country;
    }

    public String getState() {
        return state;
    }

    public String getAddressLine1() {
        return AddressLine1;
    }

    public String getAddressLine2() {
        return AddressLine2;
    }

    public String getCity() {
        return city;
    }
}
