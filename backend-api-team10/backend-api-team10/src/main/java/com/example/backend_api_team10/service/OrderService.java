package com.example.backend_api_team10.service;

import com.example.backend_api_team10.entity.Order;
import com.example.backend_api_team10.repository.OrderRepo;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;


@Service
public class OrderService {

	@Autowired
	private OrderRepo orderRepo;

	public Order createOrder(Order order) {
		return orderRepo.save(order);
	}
	public List<Order> getAllOrders() {
		return orderRepo.findAll();
	}
	public Optional<Order> getOrderById(Long orderId) {
		return orderRepo.findById(orderId);
	}
	public Order updateOrder(Long orderId, Order orderDetails) {
		
		return orderRepo.findById(orderId)
		.map(existingOrder -> {
		existingOrder.setCartId(orderDetails.getCartId());
		existingOrder.setTimestamp(orderDetails.getTimestamp());
		existingOrder.setTotalPrice(orderDetails.getTotalPrice());
		existingOrder.setAddress(orderDetails.getAddress());
		return orderRepo.save(existingOrder);
	})

	.orElseThrow(() -> new RuntimeException("Order not found: " + orderId));
	}
	public Order updateOrderStatus(Long orderId, String status) {
		return orderRepo.findById(orderId)
		.map(existingOrder -> {
		existingOrder.setStatus(status);
		return orderRepo.save(existingOrder);
	})
	.orElseThrow(() -> new RuntimeException("Order not found: " + orderId));
	}
	public void deleteOrder(Long orderId) {
		orderRepo.deleteById(orderId);		
	}

    public Order createForCart(Long cartId, Order order) {
		order.setCartId(cartId);
		return orderRepo.save(order);
	}

    public List<Order> getOrdersByCart(Long cartId) {
		return orderRepo.findByCartId(cartId);
	}
}