package com.springboot.brief11.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springboot.brief11.entity.Employee;
import com.springboot.brief11.repo.UserRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
  @Autowired
  UserRepository userRepository;

  @Override
  @Transactional
  public UserDetails loadUserByUsername(String firstName) throws UsernameNotFoundException {
    Employee user = userRepository.findByUsername(firstName)
        .orElseThrow(() -> new UsernameNotFoundException("User Not Found with username: " + firstName));
    

    return UserDetailsImpl.build(user);
  }

  
}