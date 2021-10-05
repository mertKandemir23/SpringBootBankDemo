package com.mertkandemir.bank.dto;

import com.mertkandemir.bank.model.City;
import com.mertkandemir.bank.model.Currency;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AccountDto {

    String id;
    String customerId;
    Double balance;
    City city;
    Currency currency;
}
