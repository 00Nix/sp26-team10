package com.example.backend_api_team10.repository;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.backend_api_team10.entity.Order;

@Repository
public interface OrderRepo extends JpaRepository<Order, Long> {
    List<Order> findByCustomerId(Long customerId);
    List<Order> findByCartId(Long cartId);

    @Query("SELECT COALESCE(SUM(o.totalPrice), 0) FROM Order o")
    Double getTotalRevenue();

}