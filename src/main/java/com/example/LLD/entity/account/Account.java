package com.example.LLD.entity.account;

import com.example.LLD.entity.account.common.Person;

public abstract class Account{
    private String userName;
    private String password;
    private Person person;

    public Account(String userName, String password, Person person) {
        this.userName = userName;
        this.password = password;
        this.person = person;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
}
