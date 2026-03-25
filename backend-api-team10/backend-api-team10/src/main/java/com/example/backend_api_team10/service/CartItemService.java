package com.example.backend_api_team10.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.backend_api_team10.entity.CartItem;
import com.example.backend_api_team10.repository.CartItemRepo;

import java.util.List;
import java.util.Optional;


@Service
public class CartItemService {

    @Autowired
    private CartItemRepo cartItemRepository;

    public CartItem createItem(CartItem item) {
        return cartItemRepository.save(item);
    }
    public Optional<CartItem> getById(long id) {
        return cartItemRepository.findById(id);
    }
    public List<CartItem> getByCart(Long cartId) {
        return cartItemRepository.findByCart_CartId(cartId);
    }
    public List<CartItem> getAllItems() {
        return cartItemRepository.findAll();
    }
    public CartItem updateItem(Long id, CartItem updatedItem) {
        return cartItemRepository.findById(id)
            .map(item -> {
                item.setQuantity(updatedItem.getQuantity());
                item.setCart(updatedItem.getCart());
                item.setMeal(updatedItem.getMeal());
                item.setMealPlan(updatedItem.getMealPlan());
                return cartItemRepository.save(item);
            })
            .orElseThrow(() -> new RuntimeException("CartItem not found"));
    }
        public void deleteItem(long id) {
            cartItemRepository.deleteById(id);
        }
    }
