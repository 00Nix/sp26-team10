package com.example.backend_api_team10.repository;

<<<<<<< Updated upstream
import com.example.backend_api_team10.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface UserRepo extends JpaRepository<Users, Long> {
    Optional<Users> findByUserId(Long user_id);
    Optional<Users> findByEmail(String email);

    @Query("SELECT CASE WHEN COUNT(u) > 0 THEN true ELSE false END FROM Users u WHERE u.email = :email")
    boolean existsByEmail(@Param("email") String email);
    
=======
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.backend_api_team10.entity.User;

public interface UserRepo extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
>>>>>>> Stashed changes
}
