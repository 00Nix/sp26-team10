package com.example.backend_api_team10.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.backend_api_team10.entity.Customer;

@Repository
public interface CustomerRepo extends JpaRepository<Customer, Long> {
	Customer findByCustomerId(Long customer_id);

	@Query("SELECT COUNT(c) > 0 FROM Customer c WHERE c.user.email = :email")
    boolean existsByEmail(@Param("email")String email);
}
