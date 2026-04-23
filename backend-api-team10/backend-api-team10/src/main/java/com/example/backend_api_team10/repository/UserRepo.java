package com.example.backend_api_team10.repository;

import com.example.backend_api_team10.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface UserRepo extends JpaRepository<Users, Long> {
    Optional<Users> findByUserId(Long user_id);
    Optional<Users> findByEmail(String email);
}
