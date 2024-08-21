package com.example.springsecuirtyexample.service;

import com.example.springsecuirtyexample.model.UserPrincipal;
import com.example.springsecuirtyexample.model.Users;
import com.example.springsecuirtyexample.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users user = userRepository.findByUsername(username);
        if(user == null) {
            System.out.printf("User not found!");
            throw new UsernameNotFoundException(username);
        }
        return new UserPrincipal(user);
    }
}
