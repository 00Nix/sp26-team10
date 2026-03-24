package com.example.backend_api_team10.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.backend_api_team10.entity.Customer;

@Repository
public interface CustomerRepo extends JpaRepository<Customer, Long> {
	Customer findByCustomerId(Long customerId);
	Customer findByEmail(String email);

}
