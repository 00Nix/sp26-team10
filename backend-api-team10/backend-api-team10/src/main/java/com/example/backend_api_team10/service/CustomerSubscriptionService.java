package com.example.backend_api_team10.service;

import com.example.backend_api_team10.entity.CustomerSubscription;
import com.example.backend_api_team10.repository.CustomerSubscriptionRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerSubscriptionService {
    
    private final CustomerSubscriptionRepo customerSubscriptionRepo;

    public CustomerSubscriptionService(CustomerSubscriptionRepo customerSubscriptionRepo) {
        this.customerSubscriptionRepo = customerSubscriptionRepo;
    }

    public CustomerSubscription createCustomerSubscription(CustomerSubscription customerSubscription) {
        return customerSubscriptionRepo.save(customerSubscription);
    }

    public List<CustomerSubscription> getAllCustomerSubscriptions(){
        return customerSubscriptionRepo.findAll();
    }

    public CustomerSubscription getCustomerSubscriptionById(Long customer_sub_id){
        return customerSubscriptionRepo.findById(customer_sub_id).orElse(null);
    }

    public CustomerSubscription updateCustomerSubscription(Long customer_sub_id, CustomerSubscription updatedSub){
        CustomerSubscription existing = customerSubscriptionRepo.findById(customer_sub_id).orElse(null);
        if (existing != null) {
            existing.setCustomer(updatedSub.getCustomer());
            existing.setSubscriptionPlan(updatedSub.getSubscriptionPlan());
            existing.setStartDate(updatedSub.getStartDate());
            existing.setEndDate(updatedSub.getEndDate());
            return customerSubscriptionRepo.save(existing);
        } else {
            return null;
        }
    }

    public void deleteCustomerSubscription(Long customer_sub_id){
        customerSubscriptionRepo.deleteById(customer_sub_id);
    }

}
