package com.example.backend_api_team10.controller;

import com.example.backend_api_team10.entity.CustomerSubscription;
import com.example.backend_api_team10.service.CustomerSubscriptionService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/customer-subscriptions")
public class CustomerSubscription {
    
    private final CustomerSubscriptionService customerSubscriptionService;

    public CustomerSubscriptionController(CustomerSubscriptionController customerSubscriptionController){
        this.customerSubscriptionService = customerSubscriptionService;
    }

    @GetMapping
    public List<CustomerSubscription> getAllCustomerSubscriptions(){
        return  customerSubscriptionService.getAllCustomerSubscriptions();
    }

    @GetMapping("/{customer_sub_id}")
    public CustomerSubscription getCustomerSubscriptionById(@PathVariable Long customer_sub_id){
        return customerSubscriptionService.findById(customer_sub_id);
    }

    @PostMapping
    public CustomerSubscription createCustomerSubscription(@RequestBody CustomerSubscription customerSubscription){
        return customerSubscriptionService.createCustomerSubscription(customerSubscription);
    }

    @PutMapping("/{customer_sub_id}")
    public CustomerSubscription updateCustomerSubscription(@PathVariable Long customer_sub_id, @RequestBody CustomerSubscription customerSubscription){
        return customerSubscriptionService.updateCustomerSubscription(customer_sub_id, customerSubscription);
    }

    @DeleteMapping("/{customer_sub_id}")
    public void deleteCustomerSubscription(@PathVariable Long customer_sub_id){
        customerSubscriptionService.deleteCustomerSubscriptionService(customer_sub_id);
    }
    
}
    


