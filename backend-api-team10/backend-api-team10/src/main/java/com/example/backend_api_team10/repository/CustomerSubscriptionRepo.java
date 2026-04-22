package com.example.backend_api_team10.repository;

import java.util.Optional;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.backend_api_team10.entity.CustomerSubscription;

public interface CustomerSubscriptionRepo extends JpaRepository<CustomerSubscription, Long> {

    @Query("SELECT cs FROM CustomerSubscription cs WHERE cs.customer.customer_id = :customer_id")
    Optional<CustomerSubscription> findByCustomerId(Long customer_id);

    @Query("SELECT cs FROM CustomerSubscription cs WHERE cs.subscriptionPlan.plan_id = :plan_id")
    Optional<CustomerSubscription> findByPlanId(Long plan_id);

    @Query("SELECT cs.subscriptionPlan.name, COUNT(cs) FROM CustomerSubscription cs GROUP BY cs.subscriptionPlan.name ORDER BY COUNT(cs) DESC")
    List<Object[]> countSubscriptionsByPlan();
}