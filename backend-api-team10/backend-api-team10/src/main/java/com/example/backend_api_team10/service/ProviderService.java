package com.example.backend_api_team10.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.example.backend_api_team10.entity.Role;
import com.example.backend_api_team10.entity.Users;
import com.example.backend_api_team10.entity.Provider;
import com.example.backend_api_team10.repository.ProviderRepo;
import com.example.backend_api_team10.repository.UserRepo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;


@Service
public class ProviderService {
    @Autowired
    private ProviderRepo providerRepo;

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public Provider createProvider(Provider provider) {
        Users user = provider.getUser();

        if (user == null){
            throw new RuntimeException("User details are required!");
        }

        user.setRole(Role.PROVIDER);
        user.setPasswordHash(passwordEncoder.encode(user.getPasswordHash()));

        Users savedUser = userRepo.save(user);

        provider.setUser(savedUser);

        return providerRepo.save(provider);
    }

    public List<Provider> getAllProviders(){
        return providerRepo.findAll();
    }

    public boolean existsByEmail(String email){
        return providerRepo.existsByEmail(email);
    }


    public Provider getProviderById(Long provider_id){
        return providerRepo.findById(provider_id).orElse(null);
    }

    public Provider updateProvider(Long provider_id, Provider updatedProvider){
        Provider existing = providerRepo.findById(provider_id).orElse(null);
        if (existing != null){
            existing.setPhone(updatedProvider.getPhone());
            existing.setBiography(updatedProvider.getBiography());

            Users existingUser = existing.getUser();
            Users updatedUser = updatedProvider.getUser();

            if (existingUser == null){
                existingUser = new Users();
            }

            if (updatedUser != null){
                existingUser.setEmail(updatedUser.getEmail());
                
                if (updatedUser.getPasswordHash() != null && !updatedUser.getPasswordHash().isBlank()) {
                    existingUser.setPasswordHash(passwordEncoder.encode(updatedUser.getPasswordHash()));
                }
            }

            existingUser.setRole(Role.PROVIDER);
            Users savedUser = userRepo.save(existingUser);

            existing.setUser(savedUser);

            return providerRepo.save(existing);
        }
        return null;
    }

    public void deleteProvider(Long provider_id){
        Provider provider = providerRepo.findById(provider_id).orElse(null);

        if (provider != null){
            Users user = provider.getUser();
            providerRepo.delete(provider);
            
            if (user != null){
                userRepo.delete(user);
            }
        }
    }
}
