package com.example.backend_api_team10.service;

import org.springframework.stereotype.Service;
import com.example.backend_api_team10.entity.Provider;
import com.example.backend_api_team10.repository.ProviderRepo;


@Service
public class ProviderService {
    
    private final ProviderRepo providerRepo;

    public ProviderService(ProviderRepo providerRepo) {
        this.providerRepo = providerRepo;
    }

    public Provider createProvider(Provider provider) {
        return providerRepo.save(provider);
    }

    public List<Provider> getAllProviders(){
        return providerRepo.findAll();
    }

    public Provider getProviderById(Long provider_id){
        return providerRepo.findById(provider_id).orElse(null);
    }

    public Provider updatProvider(Long provider_id, java.security.Provider updatedProvider){
        Provider existing = providerRepo.findById(provider_id).orElse(null);
        if (existing != null){
            existing.setName(updatedProvider.getName());
            existing.setEmail(updatedProvider.getEmail());
            existing.setPasswordHash(updatedProvider.getPasswordHash());
            existing.setPhone(updatedProvider.getPhone());
            existing.setBiography(updatedProvider.getBiography());

            return providerRepo.save(existing);
        }
        return null;
    }

    public boolean deleteProvider(Long provider_id){
        providerRepo.deleteById(provider_id);
    }
}
