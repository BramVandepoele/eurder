package com.switchfully.bram.eurder.controllers;

import com.switchfully.bram.eurder.dto.AddressDto;
import com.switchfully.bram.eurder.dto.CreateCustomerDto;
import com.switchfully.bram.eurder.dto.GetCustomerDto;
import com.switchfully.bram.eurder.dto.PhoneNumberDto;
import com.switchfully.bram.eurder.instances.Address;
import com.switchfully.bram.eurder.instances.PhoneNumber;
import com.switchfully.bram.eurder.instances.person.Customer;
import com.switchfully.bram.eurder.services.CustomerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.stream.Collectors;

@RestController
@RequestMapping(path = "/customers")
public class CustomerController {
    private final Logger myLogger = LoggerFactory.getLogger(CustomerController.class);

    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public void createCustomer(@RequestBody CreateCustomerDto createCustomerDto) {
        myLogger.info("Creation of new member requested.");
        Address address = new Address(createCustomerDto.getStreetName(), createCustomerDto.getHouseNumber(), createCustomerDto.getCity(), createCustomerDto.getPostalCode());
        PhoneNumber phoneNumber = new PhoneNumber(createCustomerDto.getCountryCode(), createCustomerDto.getPhoneNumber());
        Customer newCustomer = new Customer(createCustomerDto.getFirstName(), createCustomerDto.getLastName(), createCustomerDto.getEmail(), address, phoneNumber);
        customerService.addCustomer(newCustomer);

    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public Collection<GetCustomerDto> getAll() {
        myLogger.info("List of all customers was requested.");

        return customerService.getAll().stream()
                .map(customer -> new GetCustomerDto()
                        .setFirstName(customer.getFirstName())
                        .setLastName(customer.getLastName())
                        .setEmail(customer.getEmail())
                        .setAddress(new AddressDto()
                                .setStreetName(customer.getAddress().getStreetName())
                                .setHouseNumber(customer.getAddress().getHouseNumber())
                                .setPostalCode(customer.getAddress().getPostalCode())
                                .setCity(customer.getAddress().getCity()))
                        .setPhoneNumber(new PhoneNumberDto()
                                .setCountryCode(customer.getPhoneNumber().getCountryCode())
                                .setPhoneNumber(customer.getPhoneNumber().getPhoneNumber()))
                )
                        .collect(Collectors.toList());


    }

}
