package com.example.backend_api_team10.controller;

import java.util.List;
import java.util.concurrent.Flow.Subscription;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.backend_api_team10.entity.Customer;
import com.example.backend_api_team10.entity.Review;
import com.example.backend_api_team10.entity.CustomerSubscription;
import com.example.backend_api_team10.service.CustomerService;
import com.example.backend_api_team10.service.ReviewService;
import com.example.backend_api_team10.service.CustomerSubscriptionService;



@RestController
@RequestMapping("/api/customers")
@CrossOrigin(origins = "*")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @Autowired
    private CustomerSubscriptionService customerSubscriptionService;
 
    @Autowired
    private ReviewService reviewService;
 
    @PostMapping
    public Customer createCustomer(@RequestBody Customer customer) {
        return customerService.createCustomer(customer);
    }
 
    /** Modify customer profile: PUT /api/customers/{id} */
    @PutMapping("/{id}")
    public Customer updateCustomer(@PathVariable Long id, @RequestBody Customer customer) {
        return customerService.updateCustomer(id, customer);
    }
 
    @GetMapping
    public List<Customer> getAllCustomers() {
        return customerService.getAllCustomers();
    }
 
    @GetMapping("/{id}")
    public Customer getCustomerById(@PathVariable Long id) {
        return customerService.getCustomerById(id)
                .orElseThrow(() -> new RuntimeException("Customer not found"));
    }
 
    @DeleteMapping("/{id}")
    public void deleteCustomer(@PathVariable Long id) {
        customerService.deleteCustomer(id);
    }
 
    @PostMapping("/{customerId}/subscriptions")
    public Subscription subscribe(@PathVariable Long customerId,
                                  @RequestBody Subscription subscription) {
        return customerSubscriptionService.createForCustomer(customerId, subscription);
    }
 
    @GetMapping("/{customerId}/subscriptions")
    public List<Subscription> getSubscriptions(@PathVariable Long customerId) {
        return customerSubscriptionService.getByCustomer(customerId);
    }
 
    
    @PostMapping("/{customerId}/reviews")
    public Review writeReview(@PathVariable Long customerId,
                               @RequestBody Review review) {
        return reviewService.createForSubscribedCustomer(customerId, review);
    }
}