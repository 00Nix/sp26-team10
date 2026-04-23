package com.example.backend_api_team10.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.backend_api_team10.entity.Customer;
import com.example.backend_api_team10.entity.Role;
import com.example.backend_api_team10.entity.Users;
import com.example.backend_api_team10.repository.CustomerRepo;
import com.example.backend_api_team10.repository.UserRepo;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepo customerRepository;

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public Customer createCustomer(Customer customer) {

        Users user = customer.getUser();

        if (user == null){
            throw new RuntimeException("User details are required!");
        }
        
        user.setRole(Role.CUSTOMER);
        user.setPasswordHash(passwordEncoder.encode(user.getPasswordHash()));

        Users savedUser = userRepo.save(user);
        customer.setUser(savedUser);

        return customerRepository.save(customer);
    }

    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    public Optional<Customer> getCustomerById(Long customer_id) {
        return customerRepository.findById(customer_id);
    }

    public Customer updateCustomer(Long customer_id, Customer updatedCustomer) {
        return customerRepository.findById(customer_id)
                .map(customer -> {
                    customer.setName(updatedCustomer.getName());
                    customer.setPhone(updatedCustomer.getPhone());
                    customer.setSubscribed(updatedCustomer.isSubscribed());
                    customer.setStatus(updatedCustomer.getStatus());

                    Users existingUser = customer.getUser();
                    Users updatedUser = updatedCustomer.getUser();

                    if (existingUser == null){
                        existingUser = new Users();
                    }

                    if (updatedUser != null){
                        existingUser.setEmail(updatedUser.getEmail());

                        if (updatedUser.getPasswordHash() != null && !updatedUser.getPasswordHash().isBlank()) {
                            existingUser.setPasswordHash(passwordEncoder.encode((updatedUser.getPasswordHash())));
                        }
                    }

                    existingUser.setRole(Role.CUSTOMER);
                    Users savedUser = userRepo.save(existingUser);
                    customer.setUser(savedUser);

                    return customerRepository.save(customer);
                })
                .orElseThrow(() -> new RuntimeException("Customer not found"));
    

    }

    public void deleteCustomer(Long customer_id) {
        Customer customer = customerRepository.findById(customer_id).orElse(null);

        if (customer != null){
            Users user = customer.getUser();
            customerRepository.delete(customer);
            
            if (user != null){
                userRepo.delete(user);
            }
        }
    }
}
 
