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
    public List<Favorite> getByCustomer(Long customer_id) {
        return favoriteRepository.findByCustomerId(customer_id);
    }
    public List<Favorite> getByMeal(Long meal_id) {
        return favoriteRepository.findByMealId(meal_id);
    }
    public void removeFavorite(Long favoriteId) {
        favoriteRepository.deleteById(favoriteId);
    }
    public Optional<Favorite> findSpecific(Long customer_id, Long meal_id) {
        return favoriteRepository.findByCustomerIdAndMealId(customer_id, meal_id);
    }
    
    
}
