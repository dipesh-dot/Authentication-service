package com.authenticationservice.security;

import com.authenticationservice.entity.User;
import com.authenticationservice.repositiry.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
@RequiredArgsConstructor
public class MyUserDetailService implements UserDetailsService {

private final UserRepository userRepository;


    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(email).orElseThrow(()->new ResponseStatusException(HttpStatus.UNAUTHORIZED,"user or Password not match"));

        MyUserDetails userDetails = new MyUserDetails(user);
//        return new MyUserDetails(user);
        return userDetails;
    }
}
