package com.backend_api_team10;

import com.backend_api_team10.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
	Customer findByCustomerId(Long customerId);
}
