package com.example.backend_api_team10.repository;

import com.example.backend_api_team10.entity.Provider;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface ProviderRepo extends JpaRepository<Provider, Long> {
    List<Provider>findByProviderId(Long provider_id);

    @Query("SELECT COUNT(p) > 0 FROM Provider p WHERE p.user.email = :email")
    boolean existsByEmail(@Param("email")String email);
    Optional<Provider> findByUserEmail(String email);
}
