package com.mertkandemir.bank.service;


import com.mertkandemir.bank.dto.AccountDto;
import com.mertkandemir.bank.dto.AccountDtoConverter;
import com.mertkandemir.bank.dto.CreateAccountRequest;
import com.mertkandemir.bank.dto.UpdateAccountRequest;
import com.mertkandemir.bank.model.Account;
import com.mertkandemir.bank.model.Customer;
import com.mertkandemir.bank.repository.AccountRepository;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Data
@Service

public class AccountService {
    private final AccountRepository accountRepository;
    private final CustomerService customerService;
    private final AccountDtoConverter accountDtoConverter;


    public AccountDto createAccount(CreateAccountRequest createAccountRequest) {
        Customer customer = customerService.getCustomerById(createAccountRequest.getId());
        if (customer.getId() == "" || customer.getId() == null) {
            return AccountDto.builder().build();
        }


        Account account = Account.builder()
                .id(createAccountRequest.getId())
                .balance(createAccountRequest.getBalance())
                .currency(createAccountRequest.getCurrency())
                .customerId(createAccountRequest.getCustomerId())
                .city(createAccountRequest.getCity())
                .build();

        return accountDtoConverter.accountDtoConverter(accountRepository.save(account));

    }


    public AccountDto updateAccount(String id, UpdateAccountRequest request) {
        Customer customer = customerService.getCustomerById(request.getCustomerId());
        if (customer.getId() == "" || customer.getId() == null) {
            return AccountDto.builder().build();
        }

        Optional<Account> accountOptional = accountRepository.findById(id);
        accountOptional.ifPresent(account -> {
            account.setBalance(request.getBalance());
            account.setCity(request.getCity());
            account.setCustomerId(request.getCustomerId());
            account.setCurrency(request.getCurrency());
            accountRepository.save(account);
        });
        return accountOptional.map(accountDtoConverter::accountDtoConverter).orElse(new AccountDto());


    }


    public List<AccountDto> getAllAccounts() {
        List<Account> accountList = accountRepository.findAll();

        return accountList.stream().map(accountDtoConverter::accountDtoConverter).collect(Collectors.toList());
    }

    public AccountDto getAccountById(String id) {
        return accountRepository.findById(id).map(accountDtoConverter::accountDtoConverter).orElse(new AccountDto());


    }

    public void deleteAccountById(String id){
        accountRepository.deleteById(id);
    }

    public AccountDto withdrawMoney(String id,Double amount){
       Optional <Account> accountOptional = accountRepository.findById(id);
       accountOptional.ifPresent(account -> {
           if(account.getBalance()>amount){
               account.setBalance(account.getBalance()-amount);
               accountRepository.save(account);
           }else{
               System.out.println("Insufficient Funds -->Account Id: "+id+" Balance : " +account.getBalance()+" Amount : "+amount);
           }
       });

       return accountOptional.map(accountDtoConverter::accountDtoConverter).orElse(new AccountDto());
    }

    public AccountDto addMoney(String id,Double amount){
        Optional <Account> accountOptional = accountRepository.findById(id);
        accountOptional.ifPresent(account -> {
          account.setBalance(account.getBalance()+amount);
          accountRepository.save(account);
        });

        return accountOptional.map(accountDtoConverter::accountDtoConverter).orElse(new AccountDto());
    }
}

