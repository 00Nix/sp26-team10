package com.example.backend_api_team10.repository;

import com.example.backend_api_team10.entity.Favorite;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface FavoriteRepo extends JpaRepository<Favorite, Long> {
    
    List<Favorite> findByCustomer_CustomerId(Long customerId);
    List<Favorite> findByMeal_MealId(Long mealId);
    Optional<Favorite> findByCustomer_CustomerIdAndMeal_MealId(Long customerId, Long mealId);

    
}
