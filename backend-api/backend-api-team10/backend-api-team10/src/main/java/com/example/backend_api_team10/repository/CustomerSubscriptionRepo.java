package com.example.backend_api_team10.repository;

import com.example.backend_api_team10.entity.CustomerSubscription;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;
import java.util.concurrent.Flow.Subscription;


public interface CustomerSubscriptionRepo extends JpaRepository<CustomerSubscription, Long> {
    Optional<CustomerSubscription> findByCustomerId(Long customerId);

    Optional<CustomerSubscription> findBySubscriptionPlanId(Long subscriptionPlanId);
}
