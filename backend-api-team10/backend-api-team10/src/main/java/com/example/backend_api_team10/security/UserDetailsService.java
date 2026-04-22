package com.example.backend_api_team10.security;

import com.example.backend_api_team10.entity.User;
import com.example.backend_api_team10.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserDetailsService {

  @Autowired
  private UserRepo userRepo;

  public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
      
    User user = userRepo.findByEmail(email).orElse(() -> new UsernameNotFoundException("User not found"));

    return new User (
      user.getEmail(),
      user.getPasswordHash(),
      List.of(new SimpleGrantedAuthority("ROLE_" + user.getRole().name()))
    );
  }
  
}
