package com.example.backend_api_team10.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.backend_api_team10.entity.Customer;
import com.example.backend_api_team10.entity.Provider;
import com.example.backend_api_team10.entity.Users;
import com.example.backend_api_team10.repository.UserRepo;
import com.example.backend_api_team10.service.CustomerService;
import com.example.backend_api_team10.service.ProviderService;

import jakarta.servlet.http.HttpSession;

@Controller
public class AuthController {
    
    private final CustomerService customerService;
    private final ProviderService providerService;
    private final PasswordEncoder passwordEncoder;
    private final UserRepo userRepo;

    public AuthController(CustomerService customerService, ProviderService providerService, PasswordEncoder passwordEncoder, UserRepo userRepo) {
        this.customerService = customerService;
        this.providerService = providerService;
        this.passwordEncoder = passwordEncoder;
        this.userRepo = userRepo;
    }

    // login
    @GetMapping("/login")
    public String login(Model model, @RequestParam(required = false) String error, @RequestParam(required = false) String logout, @RequestParam(required = false) String registered) {
        
        if (error != null) {
            model.addAttribute("error", true);
        }

        if (logout != null) {
            model.addAttribute("logout", true);
        }

        if (registered != null) {
            model.addAttribute("registered", true);
        }

        return "login";
    }



    // registration management
    @GetMapping("/register")
    public String register(Model model, @RequestParam(required = false) String error, @RequestParam(required = false) String duplicate) {

        if (error != null) {
            model.addAttribute("error", true);
        }

        if (duplicate != null) {
            model.addAttribute("duplicate", true);
        }

        return "register";
    }

    @PostMapping("/register")
    public String registerUser(@RequestParam String name, @RequestParam String email, @RequestParam String password, @RequestParam(required = false) String phone, @RequestParam String role) {
        
        if (name == null || name.isBlank() 
        || email == null || email.isBlank()
        || password == null || password.isBlank()
        || role == null || role.isBlank()) {
            return "redirect:/register?error=true";
        }

        String normalizedRole = role.trim().toUpperCase();
        String normalizedEmail = email.trim().toLowerCase();

        if (userRepo.existsByEmail(normalizedEmail)) {
            return "redirect:/register?duplicate=true";
        }

        String encodedPassword = passwordEncoder.encode(password);

        if ("CUSTOMER".equals(normalizedRole)) {
           
            Users user = new Users();
            user.setName(name.trim());
            user.setEmail(normalizedEmail);
            user.setPasswordHash(encodedPassword);
            user.setRole(com.example.backend_api_team10.entity.Role.CUSTOMER);

            Customer customer = new Customer();
            customer.setName(name.trim());
            customer.setUser(user);
            customer.setPhone(phone);
            customer.setStatus("ACTIVE");
            customer.setSubscribed(false);

            customerService.createCustomer(customer);

            return "redirect:/login?registered=true";
        }

        if ("PROVIDER".equals(normalizedRole)) {
           
            Users user = new Users();
            user.setName(name.trim());
            user.setEmail(normalizedEmail);
            user.setPasswordHash(encodedPassword);
            user.setRole(com.example.backend_api_team10.entity.Role.PROVIDER);

            Provider provider = new Provider();
            provider.setUser(user);
            provider.setPhone(phone);
            provider.setBiography("");

            providerService.createProvider(provider);

            return "redirect:/provider/profile";
        }

        return "redirect:/register?error=true";

    }

    @GetMapping("/")
    public String homeRedirect(Authentication authentication, HttpSession session) {

        if (authentication == null || !authentication.isAuthenticated() || authentication.getPrincipal().equals("anonymousUser")){
            return "redirect:/customer/index";
        }

        userRepo.findByEmail(authentication.getName()).ifPresent(user -> {
            if (user.getCustomer() != null) {
                session.setAttribute("LoggedInCustomerId", user.getCustomer().getCustomerId());
                session.setAttribute("LoggedInCustomerName", user.getCustomer().getName());
            }
        });


        for (GrantedAuthority auth : authentication.getAuthorities()) {
            
            if ("ROLE_PROVIDER".equals(auth.getAuthority())) {
                return "redirect:/provider/dashboard";
            }

            if ("ROLE_CUSTOMER".equals(auth.getAuthority())) {
                return "redirect:/customer/index";
            }
        }

        return "redirect:/login";
    }

    @GetMapping("/403")
    public String accessDenied() {
        return "403";
    }

}
