package com.example.backend_api_team10.security;

import com.example.backend_api_team10.entity.Users;
import com.example.backend_api_team10.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomUserDetailsService implements UserDetailsService{

  @Autowired
  private UserRepo userRepo;

  @Override
  public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

    // DB Login
    Users user = userRepo.findByEmail(email).orElseThrow(() -> new UsernameNotFoundException("User not found"));

    return new org.springframework.security.core.userdetails.User(
      user.getEmail(),
      user.getPasswordHash(),

      List.of(new SimpleGrantedAuthority("ROLE_" + user.getRole().name())));

    }
  
}
