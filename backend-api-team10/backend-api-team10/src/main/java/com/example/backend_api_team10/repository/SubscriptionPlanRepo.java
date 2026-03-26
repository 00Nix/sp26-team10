package com.example.backend_api_team10.repository;

import com.example.backend_api_team10.entity.SubscriptionPlan;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface SubscriptionPlanRepo extends JpaRepository<SubscriptionPlan, Long> {
    
    List<SubscriptionPlan> findByName(String name);

}
