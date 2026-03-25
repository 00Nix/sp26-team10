package com.example.backend_api_team10.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.backend_api_team10.entity.Order;

@Repository
public interface OrderRepo extends JpaRepository<Order, Long> {
    List<Order> findByCustomerId(Long customerId);
    List<Order> findByCartId(Long cartId);
}