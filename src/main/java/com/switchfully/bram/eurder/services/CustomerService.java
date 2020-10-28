package com.switchfully.bram.eurder.services;

import com.switchfully.bram.eurder.exceptions.CreationFailedException;
import com.switchfully.bram.eurder.exceptions.EntityNotFoundException;
import com.switchfully.bram.eurder.instances.person.Customer;
import com.switchfully.bram.eurder.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class CustomerService {
    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public void addCustomer(Customer customer) {
        emailValidation(customer.getEmail());
        firstNameValidation(customer);
        lastNameValidation(customer);
        addressValidation(customer);
        phoneNumberValidation(customer);
        customerRepository.addCustomer(customer);
    }

    private void phoneNumberValidation(Customer customer) {
        if(customer.getPhoneNumber().getCountryCode().isBlank()) throw new CreationFailedException(Customer.class, "invalid country code" , customer.getPhoneNumber().getCountryCode());
        if(customer.getPhoneNumber().getPhoneNumber() < 100000) throw new CreationFailedException(Customer.class, "invalid phone number" , String.valueOf(customer.getPhoneNumber().getPhoneNumber()));

    }

    private void addressValidation(Customer customer) {
       if(customer.getAddress().getStreetName().isBlank()) throw new CreationFailedException(Customer.class, "invalid street name" , customer.getAddress().getStreetName());
       if(customer.getAddress().getHouseNumber().isBlank()) throw new CreationFailedException(Customer.class, "invalid house number" , customer.getAddress().getHouseNumber());
       if(customer.getAddress().getCity().isBlank()) throw new CreationFailedException(Customer.class, "invalid city name" , customer.getAddress().getCity());
       if(customer.getAddress().getPostalCode() < 1000) throw new CreationFailedException(Customer.class, "invalid postal code" , String.valueOf(customer.getAddress().getPostalCode()));
    }

    private void lastNameValidation(Customer customer) {
       if(customer.getLastName().isEmpty()) throw new CreationFailedException(Customer.class, "invalid last name", customer.getLastName());
    }

    private void firstNameValidation(Customer customer) {
       if(customer.getFirstName().isBlank()) throw new CreationFailedException(Customer.class, "invalid first name", customer.getFirstName());
    }

    private void emailValidation(String email) {
        String regex = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
        if(!email.matches(regex))throw new CreationFailedException(Customer.class, "invalid format of email", email);
    }

    public Collection<Customer> getAll() {
        return customerRepository.getAll();
    }

    public Customer getById(String id) {
        Customer customer = customerRepository.getById(id);
        if(customer == null){
            throw new EntityNotFoundException(Customer.class, "Id not found" , id);
        }
        return customer;
    }
}
