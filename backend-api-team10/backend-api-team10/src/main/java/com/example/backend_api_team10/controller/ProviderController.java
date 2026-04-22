package com.example.backend_api_team10.controller;

import com.example.backend_api_team10.entity.Provider;
import com.example.backend_api_team10.service.ProviderService;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping("/providers")
public class ProviderController {
 
    private final ProviderService providerService;

    public ProviderController(ProviderService providerService){
        this.providerService = providerService;
    }

    @GetMapping("/")
    public List<Provider> getAllProviders(){
        return providerService.getAllProviders();
    }
    
    @GetMapping("/{provider_id}")
    public Provider getProviderById(@PathVariable Long provider_id){
        return providerService.getProviderById(provider_id);
    }

    @PostMapping("/")
    public Provider createProvider(@RequestBody Provider provider){
        return providerService.createProvider(provider);   
    }

    @PutMapping("/{provider_id}")
    public Provider updateProvider(@PathVariable Long provider_id, @RequestBody Provider provider){
        return providerService.updateProvider(provider_id, provider);
    }

    @DeleteMapping("/{provider_id}")
    public void deleteProvider(@PathVariable Long provider_id){
        providerService.deleteProvider(provider_id);
    }

}
