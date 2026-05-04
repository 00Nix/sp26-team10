package com.example.backend_api_team10.service;

<<<<<<< Updated upstream
import org.springframework.stereotype.Service;
import com.example.backend_api_team10.entity.Role;
import com.example.backend_api_team10.entity.Users;
import com.example.backend_api_team10.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;


=======
>>>>>>> Stashed changes
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.backend_api_team10.entity.Role;
import com.example.backend_api_team10.entity.User;
import com.example.backend_api_team10.repository.UserRepo;

@Service
public class UserService {
    
    @Autowired
    private UserRepo userRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public Users createUser(Users user){
        if (user.getEmail() == null || user.getPasswordHash() == null || user.getRole() == null){
            throw new RuntimeException("User must have an email, password, and role.");
        }
        user.setPasswordHash(passwordEncoder.encode(user.getPasswordHash()));

        return userRepo.save(user);
    }

    public List<Users> getAllUsers(){
        return userRepo.findAll();
    }

<<<<<<< Updated upstream
    public Optional<Users> getUserById(Long user_id){
        return userRepo.findByUserId(user_id);
=======
    public Optional<User> getUserById(Long user_id){
        return userRepo.findById(user_id);
>>>>>>> Stashed changes
    }

    public Users saveUser(Users user){
        return userRepo.save(user);
    }

<<<<<<< Updated upstream
    public Users updateUser(Long user_id, Users updatedUser){
        return userRepo.findByUserId(user_id)
=======
    public User updateUser(Long user_id, User updatedUser){
        return userRepo.findById(user_id)
>>>>>>> Stashed changes
                .map(existingUser -> {
                    existingUser.setEmail(updatedUser.getEmail());

                    if (updatedUser.getPasswordHash() != null && !updatedUser.getPasswordHash().isBlank()) {
                    existingUser.setPasswordHash(passwordEncoder.encode(updatedUser.getPasswordHash()));

                    }   
                    existingUser.setRole(updatedUser.getRole());
                    return userRepo.save(existingUser);
                })
                .orElseThrow(() -> new RuntimeException("User not found :("));
                
    }

<<<<<<< Updated upstream
    public Users updateUserRole(Long user_id, Role newRole){
        Optional<Users> optionalUser = userRepo.findByUserId(user_id);
=======
    public User updateUserRole(Long user_id, Role newRole){
        Optional<User> optionalUser = userRepo.findById(user_id);
>>>>>>> Stashed changes
        if (optionalUser.isPresent()) {
            Users user = optionalUser.get();
            user.setRole(newRole);
            return userRepo.save(user);
        }
        return null;
    }

    public void deleteUser(Long user_id){
        userRepo.deleteById(user_id);
    }

}
