package com.switchfully.bram.eurder.repositories;

import com.switchfully.bram.eurder.exceptions.CreationFailedException;
import com.switchfully.bram.eurder.exceptions.EntityNotFoundException;
import com.switchfully.bram.eurder.instances.person.Customer;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
public class CustomerRepository {
    private final Map<String, Customer> customers = new HashMap<>();

    public void addCustomer(Customer customer) {
        checkEmailIsUnique(customer);
        save(customer);
    }

    private void save(Customer customer) {
        customers.put(customer.getId(), customer);
    }

    private void checkEmailIsUnique(Customer customer) {
        if(customers.values().stream()
        .anyMatch(customer1 -> customer1.getEmail().equals(customer.getEmail()))){
            throw new CreationFailedException(Customer.class, "E-mail address already in use", customer.getEmail());
        }
    }

    public Collection<Customer> getAll() {
        return new ArrayList<>(customers.values());
    }

    public Customer getById(String id) {
        assertIdExists(id);
        return customers.get(id);
    }

    private void assertIdExists(String id) {
        if(customers.get(id) == null) throw new EntityNotFoundException(CustomerRepository.class, "CustomerId not found", id);
    }
}
