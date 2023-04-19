package com.example.LLD.entity.account.common;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Contact {
    private String phone;
    private String email;
}
