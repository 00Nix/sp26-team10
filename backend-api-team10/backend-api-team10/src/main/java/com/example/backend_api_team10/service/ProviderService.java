package com.example.backend_api_team10.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.example.backend_api_team10.entity.Role;
import com.example.backend_api_team10.entity.User;
import com.example.backend_api_team10.entity.Provider;
import com.example.backend_api_team10.repository.ProviderRepo;
import com.example.backend_api_team10.repository.UserRepo;

import org.springframework.beans.factory.annotation.Autowired;


@Service
public class ProviderService {
    @Autowired
    private ProviderRepo providerRepo;

    @Autowired
    private UserRepo userRepo;

    public Provider createProvider(Provider provider) {
        User user = provider.getUser();

        if (user == null){
            throw new RuntimeException("User details are required!")
        }

        user.setRole(Role.PROVIDER);
        User savedUser = userRepo.save(user);

        provider.setUser(savedUser);

        return providerRepo.save(provider);
    }

    public List<Provider> getAllProviders(){
        return providerRepo.findAll();
    }

    public Provider getProviderById(Long provider_id){
        return providerRepo.findById(provider_id).orElse(null);
    }

    public Provider updateProvider(Long provider_id, Provider updatedProvider){
        Provider existing = providerRepo.findById(provider_id).orElse(null);
        if (existing != null){
            existing.setName(updatedProvider.getName());
            existing.setPhone(updatedProvider.getPhone());
            existing.setBiography(updatedProvider.getBiography());

            User existingUser = existing.getUser();
            User updatedUser = updatedProvider.getUser();

            if (existingUser == null){
                existingUser = new User();
            }

            if (updatedUser != null){
                existingUser.setEmail(updatedUser.getEmail());
                existingUser.setPasswordHash(updatedUser.getPasswordHash());
            }

            existingUser.setRole(Role.PROVIDER);
            User savedUser = userRepo.save(existingUser);

            existing.setUser(savedUser);

            return providerRepo.save(existing);
        }
        return null;
    }

    public void deleteProvider(Long provider_id){
        Provider provider = providerRepo.findById(provider_id).orElse(null);

        if (provider != null){
            User user = provider.getUser();
            providerRepo.delete(provider);
            
            if (user != null){
                userRepo.delete(user);
            }
        }
    }
}
