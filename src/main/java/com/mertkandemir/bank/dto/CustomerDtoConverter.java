package com.mertkandemir.bank.dto;

import com.mertkandemir.bank.model.Customer;
import org.springframework.stereotype.Component;

@Component
//Servisle aynı özellikleri gösterir. Başka bir katmana ulaşacaksa service, servis katmanına ulaşacaksa component anatasyonu kullasnıyoruz.


public class CustomerDtoConverter {

    public CustomerDto convert(Customer customer) {
        CustomerDto customerDto = new CustomerDto();

        customerDto.setId(customer.getId());
        customerDto.setName(customer.getName());
        customerDto.setSurName(customer.getSurName());
        customerDto.setAdress(customer.getAdress());
        customerDto.setCity(customer.getCity());
        customerDto.setEmail(customer.getEmail());
        customerDto.setDateOfBirth(customer.getDateOfBirth());
        return customerDto;
    }
}


