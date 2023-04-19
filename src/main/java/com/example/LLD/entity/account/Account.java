package com.example.LLD.entity.account;

import com.example.LLD.entity.account.common.Person;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Data
@NoArgsConstructor
@AllArgsConstructor
public abstract class Account{
    private String userName;
    private String password;
    private Person person;
}
