package com.example.backend_api_team10.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.backend_api_team10.entity.Favorite;
import com.example.backend_api_team10.service.FavoriteService;

@RestController
@RequestMapping("/api/favorites")
public class FavoriteController {

    @Autowired
    private FavoriteService favoriteService;

    @PostMapping
    public Favorite add(@RequestBody Favorite favorite) {
        return favoriteService.addFavorite(favorite);
    }
    @GetMapping
    public List<Favorite> getAll() {
        return favoriteService.getAllFavorites();
    }
    @GetMapping("/customer/{customerId}")
    public List<Favorite> getByCustomer(@PathVariable Long customerId) {
        return favoriteService.getByCustomer(customerId);
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        favoriteService.removeFavorite(id);
    }
    
}
