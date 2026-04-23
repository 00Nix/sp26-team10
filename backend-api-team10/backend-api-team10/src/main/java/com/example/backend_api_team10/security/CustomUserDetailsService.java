package com.example.backend_api_team10.security;

import com.example.backend_api_team10.entity.Users;
import com.example.backend_api_team10.repository.UserRepo;
import com.example.backend_api_team10.service.AnalyticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomUserDetailsService implements UserDetailsService{

  @Autowired
  private UserRepo userRepo;

  @Autowired
  private InMemoryUserDetailsManager inMemoryUserDetailsManager;

  @Override
  public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

    // hardcoded credentials
    if (inMemoryUserDetailsManager.userExists(email)) {
      return inMemoryUserDetailsManager.loadUserByUsername(email);
    }

    // DB Login
    Users user = userRepo.findByEmail(email).orElseThrow(() -> new UsernameNotFoundException("User not found"));

    return new org.springframework.security.core.userdetails.User(
      user.getEmail(),
      user.getPasswordHash(),

      List.of(new SimpleGrantedAuthority("ROLE_" + user.getRole().name())));

    }
  
}
