package com.example.backend_api_team10.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.backend_api_team10.entity.Favorite;

public interface FavoriteRepo extends JpaRepository<Favorite, Long> {
    
    @Query("SELECT f FROM Favorite f LEFT JOIN f.customer c where c.customer_id = :customerId")
    List<Favorite> findByCustomerId(@Param("customerId") Long customerId);
    
    @Query("SELECT f FROM Favorite f LEFT JOIN f.meal m where m.meal_id = :mealId")
    List<Favorite> findByMealId(@Param("mealId") Long mealId);
    
    @Query("SELECT f FROM Favorite f LEFT JOIN f.customer c LEFT JOIN f.meal m where c.customer_id = :customerId AND m.meal_id = :mealId")
    Optional<Favorite> findByCustomerIdAndMealId(@Param("customerId") Long customerId, @Param("mealId") Long mealId);

    
}
