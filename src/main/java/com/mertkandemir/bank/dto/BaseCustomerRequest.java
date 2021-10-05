package com.mertkandemir.bank.dto;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class BaseCustomerRequest {

    String name;
    String surName;
    Integer dateOfBirth;
    CityDto city;
    String adress;
    String email;
}
