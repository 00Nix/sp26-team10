package com.example.backend_api_team10.service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.backend_api_team10.entity.Favorite;
import com.example.backend_api_team10.repository.FavoriteRepo;

@Service
public class FavoriteService {

    @Autowired
    private FavoriteRepo favoriteRepository;

    public Favorite addFavorite(Favorite favorite) {
        return favoriteRepository.save(favorite);
    }
    public List<Favorite> getAllFavorites() {
        return favoriteRepository.findAll();
    }
    public List<Favorite> getByCustomer(Long customerId) {
        return favoriteRepository.findByCustomer_CustomerId(customerId);
    }
    public List<Favorite> getByMeal(Long mealId) {
        return favoriteRepository.findByMeal_MealId(mealId);
    }
    public void removeFavorite(Long id) {
        favoriteRepository.deleteById(id);
    }
    public Optional<Favorite> findSpecific(Long customerId, Long mealId) {
        return favoriteRepository.findByCustomer_CustomerIdAndMeal_MealId(customerId, mealId);
    }
    
    
}
