package com.mertkandemir.bank.dto;

import com.mertkandemir.bank.model.City;
import com.mertkandemir.bank.model.Currency;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor


public class BaseAccountRequest {
    String customerId;
    Double balance;
    City city;
    Currency currency;
}
