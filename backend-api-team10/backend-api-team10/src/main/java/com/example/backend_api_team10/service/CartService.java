package com.example.backend_api_team10.service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.backend_api_team10.entity.Cart;
import com.example.backend_api_team10.repository.CartRepo;

@Service
public class CartService {
    
    @Autowired
    private CartRepo cartRepo;

    public Cart createCart(Cart cart) {
        return cartRepo.save(cart);
    }

    public List<Cart> getAllCarts() {
        return cartRepo.findAll();
    }

    public Optional<Cart> getCartById(Long id) {
        return cartRepo.findById(id);
    }

    public Optional<Cart> getCartByCustomer(Long customerId) {
        return cartRepo.findByCustomer_CustomerId(customerId);
    }

    public Cart updateCart(Long id, Cart updatedCart) {
        return cartRepo.findById(id)
                .map(cart -> {
                    cart.setSubtotal(updatedCart.getSubtotal());
                    cart.setCustomer(updatedCart.getCustomer());
                    return cartRepo.save(cart);
                })
                .orElseThrow(() -> new RuntimeException("Cart not found"));
    }

    public void deleteCart(Long id) {
        cartRepo.deleteById(id);
    }
}