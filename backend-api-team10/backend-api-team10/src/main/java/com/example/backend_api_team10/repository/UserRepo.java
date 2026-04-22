package com.example.backend_api_team10.repository;

import com.example.backend_api_team10.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface UserRepo extends JpaRepository<User, Long> {
    Optional<User> findUserById(Long user_id);
    Optional<User> findByEmail(String email);
}
