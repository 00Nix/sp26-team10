package com.example.backend_api_team10.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.backend_api_team10.entity.Order;
import com.example.backend_api_team10.service.OrderService;


@RestController
@RequestMapping("/api/orders")
public class OrderController {
    
    @Autowired
    private OrderService orderService;
 
    @PostMapping
    public Order createOrder(@RequestBody Order order) {
        return orderService.createOrder(order);
    }
 
    @PostMapping("/carts/{cartId}")
    public Order createForCart(@PathVariable Long cartId, @RequestBody Order order) {
        return orderService.createForCart(cartId, order);
    }
 
    @GetMapping
    public List<Order> getAllOrders() {
        return orderService.getAllOrders();
    }
 
    @GetMapping("/{id}")
    public Order getOrderById(@PathVariable Long id) {
        return orderService.getOrderById(id);
    }
 
    @GetMapping("/carts/{cartId}")
    public List<Order> getOrdersByCart(@PathVariable Long cartId) {
        return orderService.getOrdersByCart(cartId);
    }
 
    @PutMapping("/{id}")
    public Order updateOrder(@PathVariable Long id, @RequestBody Order order) {
        return orderService.updateOrder(id, order);
    }
 
    @DeleteMapping("/{id}")
    public void deleteOrder(@PathVariable Long id) {
        orderService.deleteOrder(id);
    }
}