package com.mertkandemir.bank;

import com.mertkandemir.bank.dto.CityDto;
import com.mertkandemir.bank.dto.CreateCustomerRequest;
import com.mertkandemir.bank.model.Account;
import com.mertkandemir.bank.model.City;
import com.mertkandemir.bank.model.Currency;
import com.mertkandemir.bank.model.Customer;
import com.mertkandemir.bank.repository.AccountRepository;
import com.mertkandemir.bank.repository.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class BankApplication implements CommandLineRunner {
    private final AccountRepository accountRepository;
    private final CustomerRepository customerRepository;

    public BankApplication(AccountRepository accountRepository, CustomerRepository customerRepository) {
        this.accountRepository = accountRepository;
        this.customerRepository = customerRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(BankApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Customer c1 = Customer.builder()
                .id("1903")
                .city(CityDto.ISTANBUL)
                .adress("Çekmeköy")
                .name("Mert")
                .surName("Kandemir")
                .email("mertkandemir23@gmail.com")
                .dateOfBirth(22091998)
                .build();
        Customer c2 = Customer.builder()
                .id("1991")
                .name("Volkan")
                .surName("Dirice")
                .city(CityDto.GİRESUN)
                .adress("Sanayi")
                .dateOfBirth(1991)
                .email("vdirice1991@gmail.com")
                .build();



        customerRepository.saveAll(Arrays.asList(c1,c2));
        Account a1 = Account.builder()
                .id("3428")
                .customerId("1282")
                .city(City.GİRESUN)
                .balance(3000.0)
                .currency(Currency.TRY)
                .build();
        Account a2 = Account.builder()
                .id("3425")
                .customerId("241221")
                .city(City.ERZURUM)
                .balance(1903.0)
                .currency(Currency.TRY)
                .build();



        accountRepository.saveAll(Arrays.asList(a1,a2));


    }
}
