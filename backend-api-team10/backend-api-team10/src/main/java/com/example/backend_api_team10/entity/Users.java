package com.example.backend_api_team10.entity;

<<<<<<< Updated upstream:backend-api-team10/backend-api-team10/src/main/java/com/example/backend_api_team10/entity/Users.java
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class Users {
=======
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "users")
public class User {
>>>>>>> Stashed changes:backend-api-team10/backend-api-team10/src/main/java/com/example/backend_api_team10/entity/User.java
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long user_id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, unique = true)
    private String email;

    private String name;

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

<<<<<<< Updated upstream:backend-api-team10/backend-api-team10/src/main/java/com/example/backend_api_team10/entity/Users.java
    public Users(Long user_id, String name, String email, String password_hash, Role role, Customer customer, Provider provider){
=======
    public User(Long user_id, String email, String name,String password_hash, Role role, Customer customer, Provider provider){
>>>>>>> Stashed changes:backend-api-team10/backend-api-team10/src/main/java/com/example/backend_api_team10/entity/User.java
        this.user_id = user_id;
        this.name = name;
        this.email = email;
        this.name = name;
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

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public String getEmail(){
        return email;
    }
    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return name;
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