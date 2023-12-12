package com.authenticationservice.security;

import org.springframework.security.core.Authentication;

public interface TokenService {

    Authentication getAuthByToken(String token);
    String getTokenByAuth(Authentication authentication);
}
