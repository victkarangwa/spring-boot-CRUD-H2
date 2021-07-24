package com.example.demo.services;

import com.example.demo.model.Customer;

import java.util.List;

public interface CustomerService {
    List<Customer> getCustomers();

    Customer getCustomerById(Long id);

    Customer insert(Customer customer);

    void updateCustomer(Long id, Customer customer);

    void deleteCustomer(Long customerID);
}
