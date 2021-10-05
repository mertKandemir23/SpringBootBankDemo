package com.mertkandemir.bank.service;

import com.mertkandemir.bank.dto.*;
import com.mertkandemir.bank.model.Customer;
import com.mertkandemir.bank.repository.CustomerRepository;
import lombok.*;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Data
@AllArgsConstructor

@Getter
@Setter
@Service
public class CustomerService {
    private final CustomerRepository customerRepository;
    private final CustomerDtoConverter customerDtoConverter;
    /*private final ModelMapper modelMapper;*/






    public CustomerDto createCustomer(CreateCustomerRequest customerRequest) {
        /*modelMapper.map(customerRequest,Customer.class);*/
        Customer customer = new Customer();
        customer.setId(customerRequest.getId());
        customer.setName(customerRequest.getName());
        customer.setSurName(customerRequest.getSurName());
        customer.setAdress(customerRequest.getAdress());
        customer.setCity(customerRequest.getCity());
        customer.setEmail(customerRequest.getEmail());
        customer.setDateOfBirth(customerRequest.getDateOfBirth());
        customerRepository.save(customer);
        CustomerDto customerdto = customerDtoConverter.convert(customer);
        return customerdto;
    }
            /*
               return modelMapper.map(customer,CustomerDto.class);
       */







    public List<CustomerDto> getAllCustomers() {
        List<Customer> customerList = customerRepository.findAll();

        List<CustomerDto> customerDtoList = new ArrayList<>();
        for (Customer customer : customerList) {
            customerDtoList.add(customerDtoConverter.convert(customer));
        }
        return customerDtoList;
    }




    public CustomerDto getCustomerDtoById(String id) {
      Optional<Customer> customerOptional = customerRepository.findById(id);
      return customerOptional.map(customerDtoConverter::convert).orElse(new CustomerDto());

    }




    public void deleteCustomerById(String id) {
        customerRepository.deleteById(id);
    }




    public CustomerDto updateCustomer(String id, UpdateCustomerRequest customerRequest) {
        Optional<Customer> customerOptional = customerRepository.findById(id);

        customerOptional.ifPresent(customer -> {
            customer.setName(customerRequest.getName());
            customer.setEmail(customerRequest.getEmail());
            customer.setDateOfBirth(customerRequest.getDateOfBirth());
            customer.setSurName(customerRequest.getSurName());
            customer.setCity(customerRequest.getCity());
            customer.setAdress(customerRequest.getAdress());
            customerRepository.save(customer);


        });

        return customerOptional.map(customerDtoConverter::convert).orElse(new CustomerDto());

    }

    protected Customer getCustomerById(String id){
        return customerRepository.findById(id).orElse(new Customer());
    }
}
