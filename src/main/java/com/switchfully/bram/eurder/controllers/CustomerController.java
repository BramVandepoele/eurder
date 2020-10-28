package com.switchfully.bram.eurder.controllers;

import com.switchfully.bram.eurder.dto.*;
import com.switchfully.bram.eurder.exceptions.NotAuthorizedException;
import com.switchfully.bram.eurder.instances.valueObjects.Address;
import com.switchfully.bram.eurder.instances.valueObjects.PhoneNumber;
import com.switchfully.bram.eurder.instances.person.Admin;
import com.switchfully.bram.eurder.instances.person.Customer;
import com.switchfully.bram.eurder.repositories.AdminRepository;
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
        myLogger.info("Creation of new customer requested.");
        Address address = new Address(createCustomerDto.getStreetName(), createCustomerDto.getHouseNumber(), createCustomerDto.getCity(), createCustomerDto.getPostalCode());
        PhoneNumber phoneNumber = new PhoneNumber(createCustomerDto.getCountryCode(), createCustomerDto.getPhoneNumber());
        Customer newCustomer = new Customer(createCustomerDto.getFirstName(), createCustomerDto.getLastName(), createCustomerDto.getEmail(), address, phoneNumber);
        customerService.addCustomer(newCustomer);

    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public Collection<GetCustomerDto> getAll(@RequestParam(required = false) String adminId) throws NotAuthorizedException {
        myLogger.info("List of all customers was requested.");
        if (adminId == null || !AdminRepository.getAdministrators().containsKey(adminId)) {
            throw new NotAuthorizedException(Admin.class, "AdminId", adminId);
        }

        return customerService.getAll().stream()
                .map(customer -> new GetCustomerDto()
                        .setId(customer.getId())
                        .setFirstName(customer.getFirstName())
                        .setLastName(customer.getLastName()))
                .collect(Collectors.toList());


    }

    @GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public GetCustomerInfoDto getById(@RequestParam(required = false) String adminId, @PathVariable String id) throws NotAuthorizedException {
        Customer customer = customerService.getById(id);
        myLogger.info("Customer requested with id {}.", customer.getId());
        if (adminId == null || !AdminRepository.getAdministrators().containsKey(adminId)) {
            throw new NotAuthorizedException(Admin.class, "AdminId", adminId);
        }

        return new GetCustomerInfoDto()
                .setId(customer.getId())
                .setFirstName(customer.getFirstName())
                .setLastName(customer.getLastName())
                .setAddress(new AddressDto()
                        .setStreetName(customer.getAddress().getStreetName())
                        .setHouseNumber(customer.getAddress().getHouseNumber())
                        .setPostalCode(customer.getAddress().getPostalCode())
                        .setCity(customer.getAddress().getCity()))
                .setEmail(customer.getEmail())
                .setPhoneNumber(new PhoneNumberDto()
                        .setCountryCode(customer.getPhoneNumber().getCountryCode())
                        .setPhoneNumber(customer.getPhoneNumber().getPhoneNumber()));
    }


}
