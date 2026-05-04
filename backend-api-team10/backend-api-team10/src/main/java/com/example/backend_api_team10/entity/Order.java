package com.example.backend_api_team10.entity;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private Long orderId;

    @Column(name = "customer_id", nullable = false)
    private Long customerId;

    @Column(name = "cart_id", nullable = false)
    private Long cartId;

    @Column(name = "timestamp", nullable = false)
    private LocalDateTime timestamp;

    @Column(name = "total_price", nullable = false)
    private Double totalPrice;

    @Column(nullable = false, length = 20)
    private String status;

    @Column(name = "address", nullable = false, length = 200)
    private String address;

    public Order() {}

    public Order(Long customer_id, Long cartId, LocalDateTime timestamp, 
        Double totalPrice, String status, String address) {
            this.customerId = customer_id;
            this.cartId = cartId;
            this.timestamp = timestamp;
            this.totalPrice = totalPrice;
            this.status = status;
            this.address = address;
        }

    public Long getOrderId() {
        return orderId;
    }
    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }
    public Long getCustomerId() {
        return customerId;
    }
    public void setCustomerId(Long customer_id) {
        this.customerId = customer_id;
    }
    public Long getCartId() {
        return cartId;
    }
    public void setCartId(Long cartId) {
        this.cartId = cartId;
    }
    public LocalDateTime getTimestamp() {
        return timestamp;
    }
    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }
    public Double getTotalPrice() {
        return totalPrice;
    }
    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }    
    public String getFormattedDate() {
        if (this.timestamp == null) {
            return "Pending Date";
        }
        java.time.format.DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM d, yyyy");
        return this.timestamp.format(formatter);
    }
}