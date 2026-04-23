package com.example.backend_api_team10.controller;

import com.example.backend_api_team10.entity.Role;
import com.example.backend_api_team10.entity.Users;
import com.example.backend_api_team10.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
@RequestMapping("/users")
@CrossOrigin(origins = "*")
public class UserController {
    
    @Autowired
    private UserService userService;

    @GetMapping
    public List<Users> getAllUsers(){
        return userService.getAllUsers();
    }

    @GetMapping("/{user_id}")
    public Optional<Users> getUserById(@PathVariable Long user_id){
        return userService.getUserById(user_id);
    }

    @PostMapping
    public Users createUser(@RequestBody Users user){
        return userService.createUser(user);
    }

    @PutMapping("/{user_id}")
    public Users updateUserRole(@PathVariable Long user_id, @RequestBody Role role) {
        return userService.updateUserRole(user_id, role);
    }

    @DeleteMapping("/{user_id}")
    public void deleteUser(@PathVariable Long user_id){
        userService.deleteUser(user_id);
    }

}
