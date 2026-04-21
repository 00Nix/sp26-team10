package com.example.backend_api_team10.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.backend_api_team10.entity.Customer;
import com.example.backend_api_team10.entity.CustomerSubscription;
import com.example.backend_api_team10.entity.SubscriptionPlan;
import com.example.backend_api_team10.repository.CustomerSubscriptionRepo;
import com.example.backend_api_team10.repository.CustomerRepo;
import com.example.backend_api_team10.repository.SubscriptionPlanRepo;;

@Service
public class CustomerSubscriptionService {
    
    private final CustomerSubscriptionRepo customerSubscriptionRepo;
    private final CustomerRepo customerRepo;
    private final SubscriptionPlanRepo subscriptionPlanRepo;

    public CustomerSubscriptionService(CustomerSubscriptionRepo customerSubscriptionRepo, CustomerRepo customerRepo, SubscriptionPlanRepo subscriptionPlanRepo) {
        this.customerSubscriptionRepo = customerSubscriptionRepo;
        this.customerRepo = customerRepo;
        this.subscriptionPlanRepo = subscriptionPlanRepo;
    }

    public CustomerSubscription createCustomerSubscription(Long customerId, CustomerSubscription request) {
        Customer customer = customerRepo.findById(customerId)
            .orElseThrow(() -> new RuntimeException("Customer not found"));

        if (request.getSubscriptionPlan() == null || request.getSubscriptionPlan().getPlanId() == null) {
            throw new RuntimeException("Subscription plan ID is required");
        }

        SubscriptionPlan plan = subscriptionPlanRepo.findById(request.getSubscriptionPlan().getPlanId())
            .orElseThrow(() -> new RuntimeException("Subscription plan not found"));

        CustomerSubscription newSubscription = new CustomerSubscription();
        newSubscription.setCustomer(customer);
        newSubscription.setSubscriptionPlan(plan);
        newSubscription.setStartDate(request.getStartDate());
        newSubscription.setEndDate(request.getEndDate());
        newSubscription.setStatus(request.getStatus());

        return customerSubscriptionRepo.save(newSubscription);
    }

    public List<CustomerSubscription> getAllCustomerSubscriptions(){
        return customerSubscriptionRepo.findAll();
    }

    public CustomerSubscription getCustomerSubscriptionById(Long customer_sub_id){
        return customerSubscriptionRepo.findById(customer_sub_id).orElse(null);
    }
    public Optional<CustomerSubscription> getByCustomerId(Long customer_id) {
        return customerSubscriptionRepo.findByCustomerId(customer_id);
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
