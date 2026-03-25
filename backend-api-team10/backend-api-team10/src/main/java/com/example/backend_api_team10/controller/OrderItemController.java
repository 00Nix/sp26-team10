package com.example.backend_api_team10.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import com.example.backend_api_team10.entity.OrderItem;
import com.example.backend_api_team10.service.CartItemService;
import com.example.backend_api_team10.service.OrderItemService;

@RestController
@RequestMapping("/api/order-items")
public class OrderItemController {

    @Autowired
    private OrderItemService orderItemService;

    @PostMapping
    public OrderItem createOrderItem(@RequestBody OrderItem orderItem) {
        return orderItemService.createOrderItem(orderItem);
    }
    @GetMapping("{orderItemId}")
    public OrderItem getOrderItemById(@PathVariable Long orderItemId) {
        return orderItemService.getOrderItemById(orderItemId)
            .orElseThrow(() -> new RuntimeException("Order Item not found: " + orderItemId));
    }
    @GetMapping("/order/{orderId}")
    public List<OrderItem> getByOrderId(@PathVariable Long orderId) {
        return orderItemService.getOrderItemsByOrderId(orderId);
    }
    @GetMapping("/meal/{mealId}")
    public List<OrderItem> getByMealId(@PathVariable Long mealId) {
        return orderItemService.getOrderItemsByMealId(mealId);
    }
    @GetMapping("/plan/{planId")
    public List<OrderItem> getByPlanId(@PathVariable Long planId) {
        return orderItemService.getOrderItemsByPlanId(planId);
    }
    @PutMapping("/{orderItemId")
    public OrderItem updateOrderItem(@PathVariable Long orderItemId, @RequestBody OrderItem orderItem) {
        return orderItemService.updateOrderItem(orderItemId, orderItem);
    }
    @DeleteMapping("/{orderItemId}")
    public void deleteOrderItem(@PathVariable Long orderItemId) {
        orderItemService.deleteOrderItem(orderItemId);
    }
}
