package com.example.LLD.entity.account.common;

public class Contact {
    private final String phone;

    private final String email;
    public Contact(String phone, String email) {
        this.phone = phone;
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }
}
