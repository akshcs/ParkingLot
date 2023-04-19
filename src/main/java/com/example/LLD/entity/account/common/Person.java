package com.example.LLD.entity.account.common;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Person {
    private String firstName;
    private String lastName;
    private Contact contact;
    private Address address;
}
