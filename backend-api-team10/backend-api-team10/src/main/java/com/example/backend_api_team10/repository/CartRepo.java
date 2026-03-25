package com.example.backend_api_team10.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.backend_api_team10.entity.Cart;

@Repository
public interface CartRepo extends JpaRepository<Cart, Long> {
    List<Cart> findByCartId(Long cartId);

    Optional<Cart> findByCustomer_CustomerId(Long customerId);

}