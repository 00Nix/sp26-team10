package com.example.backend_api_team10.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long user_id;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String password_hash;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    protected Role role;

    @OneToOne(mappedBy = "user")
    @JsonIgnoreProperties("user")
    private Customer customer;

    @OneToOne(mappedBy = "user")
    @JsonIgnoreProperties("user")
    private Provider provider;

    public Users(){
        
    }

    public Users(Long user_id, String email, String password_hash, Role role, Customer customer, Provider provider){
        this.user_id = user_id;
        this.email = email;
        this.password_hash = password_hash;
        this.role = role;
        this.customer = customer;
        this.provider = provider;
    }

    public void setUserId(Long user_id){
        this.user_id = user_id;
    }

    public Long getUserId(){
        return user_id;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public String getEmail(){
        return email;
    }

    public void setPasswordHash(String password_hash){
        this.password_hash = password_hash;
    }

    public String getPasswordHash(){
        return password_hash;
    }

    public void setRole(Role role){
        this.role = role;
    }

    public Role getRole(){
        return role;
    }

    public void setCustomer(Customer customer){
        this.customer = customer;   
    }

    public Customer getCustomer(){
        return customer;
    }

    public void setProvider(Provider provider){
        this.provider = provider;
    }

    public Provider getProvider(){
        return provider;
    }


}