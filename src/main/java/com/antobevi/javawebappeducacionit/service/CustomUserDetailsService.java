package com.antobevi.javawebappeducacionit.service;

import com.antobevi.javawebappeducacionit.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

// Valida que lo que ingresa el usuario coincide con lo que tengo en mi sistema
@Service
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userService.findUserByUsername(username);

        if(user == null) {
            throw new UsernameNotFoundException("User " + username + " not found.");
        }

        return org.springframework.security.core.userdetails.User.withUsername(user.getUsername()).password("{bcrypt}" + user.getPassword()).build();
    }

    /* EJEMPLO CON CONTRASEÑA HARDCODEADA (en texto plano)
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        if("user".equals(username)) {
            return org.springframework.security.core.userdetails.User.withUsername("user")
                    .password("{noop}pass") // noop define que la password no esta encriptada
                    .roles("USER").build();
        } else {
            throw new UsernameNotFoundException("User " + username + " not found.");
        }

    }
    */

}