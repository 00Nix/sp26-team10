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

    public Optional<Cart> getCartById(Long cartId) {
        return cartRepository.findById(cartId);
    }

    public Optional<Cart> getCartByCustomer(Long customer_id) {
        return cartRepository.findByCustomerId(customer_id);
    }

    public Cart updateCart(Long cartId, Cart updatedCart) {
        return cartRepository.findById(cartId)
                .map(cart -> {
                    cart.setSubtotal(updatedCart.getSubtotal());
                    cart.setCustomer(updatedCart.getCustomer());
                    return cartRepository.save(cart);
                })
                .orElseThrow(() -> new RuntimeException("Cart not found"));
    }

    public void deleteCart(Long cartId) {
        cartRepository.deleteById(cartId);
    }
}