package com.example.LLD.entity.account.user;

import com.example.LLD.entity.account.Account;
import com.example.LLD.entity.account.common.Person;
import com.example.LLD.entity.parking.ParkingLot;

public class Admin extends Account {
    public Admin(String userName, String password, Person person) {
        super(userName, password, person);
    }
}
