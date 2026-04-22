package com.example.backend_api_team10.service;

import org.springframework.stereotype.Service;
import com.example.backend_api_team10.entity.Role;
import com.example.backend_api_team10.entity.User;
import com.example.backend_api_team10.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    
    @Autowired
    private UserRepo userRepo;

    public User createUser(User user){
        if (user.getEmail() == null || user.getPasswordHash() == null || user.getRole() == null){
            throw new RuntimeException("User must have an email, password, and role.");
        }
        return userRepo.save(user);
    }

    public List<User> getAllUsers(){
        return userRepo.findAll();
    }

    public Optional<User> getUserById(Long user_id){
        return userRepo.findUserById(user_id);
    }

    public User saveUser(User user){
        return userRepo.save(user);
    }

    public User updatUser(Long user_id, User updatedUser){
        return userRepo.findUserById(user_id)
                .map(existingUser -> {
                    existingUser.setEmail(updatedUser.getEmail());
                    existingUser.setPasswordHash(updatedUser.getPasswordHash());
                    existingUser.setRole(updatedUser.getRole());
                    return userRepo.save(existingUser);
                })
                .orElseThrow(() -> new RuntimeException("User not found :("));
                
    }

    public User updateUserRole(Long user_id, Role newRole){
        Optional<User> optionalUser = userRepo.findUserById(user_id);
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            user.setRole(newRole);
            return userRepo.save(user);
        }
        return null;
    }

    public void deleteUser(Long user_id){
        userRepo.deleteById(user_id);
    }

}
