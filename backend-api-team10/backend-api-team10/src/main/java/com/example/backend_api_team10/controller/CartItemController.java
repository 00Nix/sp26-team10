package com.example.backend_api_team10.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.backend_api_team10.entity.CartItem;
import com.example.backend_api_team10.service.CartItemService;

@RestController
@RequestMapping("/api/cart-items")
public class CartItemController {

    @Autowired
    private CartItemService cartItemService;

    @PostMapping
    public CartItem create(@RequestBody CartItem item) {
        return cartItemService.createItem(item);
    }
    @GetMapping 
    public List<CartItem> getAll() {
        return cartItemService.getAllItems();
    }
    @GetMapping("/{id}")
    public CartItem getById(@PathVariable Long id) {
        return cartItemService.getById(id)
        .orElseThrow(() -> new RuntimeException("CartItem not found")); 
    }

    @GetMapping("/carts/{cartId}")
    public List<CartItem> getByCart(@PathVariable Long cartId) {
        return cartItemService.getByCart(cartId);
    }
    @PutMapping("/{id}")
    public CartItem update(@PathVariable Long id, @RequestBody CartItem item) {
        return cartItemService.updateItem(id, item);
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        cartItemService.deleteItem(id);
    }

    
}
