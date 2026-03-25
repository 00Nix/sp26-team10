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
    private CartRepo cartRepository;

    public Cart createCart(Cart cart) {
        return cartRepository.save(cart);
    }

    public List<Cart> getAllCarts() {
        return cartRepository.findAll();
    }

    public Optional<Cart> getCartById(Long id) {
        return cartRepository.findById(id);
    }

    public Optional<Cart> getCartByCustomer(Long customerId) {
        return cartRepository.findByCustomer_CustomerId(customerId);
    }

    public Cart updateCart(Long id, Cart updatedCart) {
        return cartRepository.findById(id)
                .map(cart -> {
                    cart.setSubtotal(updatedCart.getSubtotal());
                    cart.setCustomer(updatedCart.getCustomer());
                    return cartRepository.save(cart);
                })
                .orElseThrow(() -> new RuntimeException("Cart not found"));
    }

    public void deleteCart(Long id) {
        cartRepository.deleteById(id);
    }
}