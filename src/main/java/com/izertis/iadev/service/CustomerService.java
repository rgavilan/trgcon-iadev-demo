package com.izertis.iadev.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.izertis.iadev.model.Customer;

@Service
public class CustomerService {
    private List<Customer> customers;

    public CustomerService() {
        customers = new ArrayList<>();
        customers.add(new Customer(1L, "Juan Pérez", "juan.perez@example.com", "123456789"));
        customers.add(new Customer(2L, "María García", "maria.garcia@example.com", "987654321"));
        customers.add(new Customer(3L, "Carlos Sánchez", "carlos.sanchez@example.com", "555555555"));
        customers.add(new Customer(4L, "Ana López", "ana.lopez@example.com", "444444444"));
    }

    public Customer getCustomer(Long id) {
        return customers.stream()
                .filter(customer -> customer.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public List<Customer> getCustomers() {
        return customers;
    }

    public Customer addCustomer(Customer customer) {
        customer.setId((long) (customers.size() + 1));
        customers.add(customer);
        return customer;
    }
}