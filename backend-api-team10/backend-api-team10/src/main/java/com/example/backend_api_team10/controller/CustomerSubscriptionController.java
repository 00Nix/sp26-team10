package com.example.backend_api_team10.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.backend_api_team10.entity.CustomerSubscription;
import com.example.backend_api_team10.service.CustomerSubscriptionService;

@RestController
@RequestMapping("/customer-subscriptions")
public class CustomerSubscriptionController {
    
    private final CustomerSubscriptionService customerSubscriptionService;

    public CustomerSubscriptionController(CustomerSubscriptionService customerSubscriptionService){
        this.customerSubscriptionService = customerSubscriptionService;
    }

    @GetMapping
    public List<CustomerSubscription> getAllCustomerSubscriptions(){
        return customerSubscriptionService.getAllCustomerSubscriptions();
    }

    @GetMapping("/{customer_sub_id}")
    public CustomerSubscription getCustomerSubscriptionById(@PathVariable Long customer_sub_id) {
        return customerSubscriptionService.getCustomerSubscriptionById(customer_sub_id);
    }
    

    @PutMapping("/{customer_sub_id}")
    public CustomerSubscription updateCustomerSubscription(@PathVariable Long customer_sub_id, @RequestBody CustomerSubscription customerSubscription){
        return customerSubscriptionService.updateCustomerSubscription(customer_sub_id, customerSubscription);
    }

    @DeleteMapping("/{customer_sub_id}")
    public void deleteCustomerSubscription(@PathVariable Long customer_sub_id){
        customerSubscriptionService.deleteCustomerSubscription(customer_sub_id);
    }
    
}
    


