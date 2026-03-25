package com.example.backend_api_team10.service;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.backend_api_team10.entity.OrderItem;
import com.example.backend_api_team10.repository.OrderItemRepo;

@Service
public class OrderItemService {

    @Autowired
    private OrderItemRepo orderItemRepository;

    
    public OrderItem createOrderItem(OrderItem orderItem) {
        return orderItemRepository.save(orderItem);
    }
    public List<OrderItem> getAllOrderItems() {
        return orderItemRepository.findAll();
    }
    public Optional<OrderItem> getOrderItemById(Long orderItemId) {
        return orderItemRepository.findById(orderItemId);
    }
    public List<OrderItem> getOrderItemsByOrderId(Long orderId) {
        return orderItemRepository.findByOrderId(orderId);
    }
    public List<OrderItem> getOrderItemsByMealId(Long mealId) {
        return orderItemRepository.findByMeal_MealId(mealId);
    }
    public List<OrderItem> getOrderItemsByPlanId(long planId) {
        return orderItemRepository.findByPlan_SubscriptionId(planId);
    }
    public OrderItem updateOrderItem(Long orderItemId, OrderItem updatedItem) {
        return orderItemRepository.findById(orderItemId)
            .map(item -> {
                item.setOrderId(updatedItem.getOrderId());
                item.setMeal(updatedItem.getMeal());
                item.setPlan(updatedItem.getPlan());
                item.setQuantity(updatedItem.getQuantity());
                item.setItemTotal(updatedItem.getItemTotal());
                return orderItemRepository.save(item);

            })
            .orElseThrow(() -> new RuntimeException("OrderItem not found with this id: " + orderItemId));
    }
    public void deleteOrderItem(Long orderItemId) {
        orderItemRepository.deleteById(orderItemId);
    }
}

