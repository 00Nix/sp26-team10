package com.example.backend_api_team10.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.backend_api_team10.entity.Cart;

@Repository
public interface CartRepo extends JpaRepository<Cart, Long> {
    List<Cart> findByCartId(Long cartId);

    @Query("SELECT c FROM Cart c LEFT JOIN c.customer cust WHERE cust.customer_id = :customerid")
    Optional<Cart> findByCustomerId(@Param("customerid") Long customerid);

}