package com.mertkandemir.bank.model;

import com.mertkandemir.bank.dto.CityDto;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Builder
public class Customer {
    @Id
    String id;

    String name;
    String surName;
    Integer dateOfBirth;
    CityDto city;
    String adress;
    String email;

}
