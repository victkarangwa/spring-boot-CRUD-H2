package com.example.demo.services;

import com.example.demo.model.Customer;
import com.example.demo.repositories.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


public class CustomerServiceImpl implements CustomerService {
    CustomerRepository customerRepository;

    public CustomerServiceImpl(CustomerRepository todoRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public List<Customer> getCustomers() {
        List<Customer> customers = new ArrayList<>();
        customerRepository.findAll().forEach(customers::add);
        return customers;
    }

    @Override
    public Customer getCustomerById(Long id) {
        return customerRepository.findById(id).get();
    }

    @Override
    public Customer insert(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public void updateCustomer(Long id, Customer customer) {
        Customer customerFromDb = customerRepository.findById(id).get();
        System.out.println(customerFromDb.toString());
        customerFromDb.setCategory(customer.getCategory());
        customerFromDb.setName(customer.getName());
        customerFromDb.setDate_of_birth(customer.getDate_of_birth());
        customerFromDb.setPhoneNumber(customer.getPhoneNumber());
        customerRepository.save(customerFromDb);
    }

    @Override
    public void deleteCustomer(Long customerId) {
        customerRepository.deleteById(customerId);
    }
}
