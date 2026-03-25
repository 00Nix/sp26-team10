package com.example.backend_api_team10.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.backend_api_team10.entity.CustomerSubscription;

public interface CustomerSubscriptionRepo extends JpaRepository<CustomerSubscription, Long> {
    Optional<CustomerSubscription> findByCustomerId(Long customer_id);

    Optional<CustomerSubscription> findBySubscriptionPlanId(Long plan_id);
}
