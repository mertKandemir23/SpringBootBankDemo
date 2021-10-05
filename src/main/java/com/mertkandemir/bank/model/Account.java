package com.mertkandemir.bank.model;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.Entity;
import javax.persistence.Id;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Builder

public class Account {
    @Id
    String id;
    String customerId;
    Double balance;
    City city;
    Currency currency;
}
