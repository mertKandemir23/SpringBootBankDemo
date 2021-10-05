package com.mertkandemir.bank.dto;

import com.mertkandemir.bank.model.Account;
import org.springframework.stereotype.Component;

@Component
public class AccountDtoConverter {
    public AccountDto accountDtoConverter(Account account) {
        return AccountDto.builder()
                .id(account.getId())
                .balance(account.getBalance())
                .city(account.getCity())
                .currency(account.getCurrency())
                .customerId(account.getCustomerId())
                .build();

    }
}
