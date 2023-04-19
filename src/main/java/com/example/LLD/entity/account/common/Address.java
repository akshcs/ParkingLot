package com.example.LLD.entity.account.common;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Address {
    private String city;
    private String zipCode;
    private String country;
    private String state;
    private String AddressLine1;
    private String AddressLine2;
}
