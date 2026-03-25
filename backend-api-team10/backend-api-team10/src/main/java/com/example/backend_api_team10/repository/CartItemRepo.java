package com.example.backend_api_team10.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.backend_api_team10.entity.CartItem;

public interface CartItemRepo extends JpaRepository<CartItem, Long> {

    List<CartItem> findByCart_CartId(Long cartId);
    
}
