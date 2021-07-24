package com.example.demo.bootstrap;

import com.example.demo.model.Category;
import com.example.demo.model.Customer;
import com.example.demo.repositories.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CustomerLoader implements CommandLineRunner {
    public final CustomerRepository customerRepository;

    public CustomerLoader(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        loadCustomers();
    }

    private void loadCustomers() {
        if (customerRepository.count() == 0) {
            customerRepository.save(
                    Customer.builder()
                            .name("John Karekezi")
                            .date_of_birth("1997-12-12")
                            .category(Category.CORPORATE)
                            .build()
            );
            customerRepository.save(
                    Customer.builder()
                            .name("Makuza Tom")
                            .date_of_birth("1989-12-12")
                            .category(Category.CORPORATE)
                            .build()
            );
            System.out.println("Sample Customers has been Loaded");
        }
    }
}
