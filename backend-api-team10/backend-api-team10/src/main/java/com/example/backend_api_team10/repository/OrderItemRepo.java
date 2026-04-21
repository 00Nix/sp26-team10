package com.example.backend_api_team10.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

import com.example.backend_api_team10.entity.OrderItem;

@Repository
public interface OrderItemRepo extends JpaRepository<OrderItem, Long> {

    List<OrderItem> findByOrderId(Long orderId);
    List<OrderItem> findByMeal_MealId(Long mealId);
    List<OrderItem> findByPlan_PlanId(Long planId);
    
}
