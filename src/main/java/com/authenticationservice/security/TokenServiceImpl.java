package com.authenticationservice.security;


import com.authenticationservice.utils.SecurityUtilsConstant;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class TokenServiceImpl implements TokenService{

    Map<String,AuthToken>map = new HashMap<>();

    @Override
    public Authentication getAuthByToken(String token) {

        AuthToken authToken = map.getOrDefault(token,new AuthToken());
        return !authToken.isExpire() ? authToken.getAuthentication() : null;
    }

    @Override
    public String getTokenByAuth(Authentication authentication) {

        String token = authentication.getName();
        AuthToken authToken = generateNewToken(token);
        authToken.setAuthentication(authentication);
        map.put(authToken.getToken(),authToken);


        return authToken.getToken();
    }


    private AuthToken generateNewToken(String username){
        AuthToken authToken = new AuthToken();
        authToken.setDateTime(LocalDateTime.now());
        String token = Jwts.builder()
                .setSubject(username)
                .setExpiration(new Date(SecurityUtilsConstant.EXPIRE_TIME+System.currentTimeMillis()))
                .signWith(SignatureAlgorithm.HS512,SecurityUtilsConstant.SECRET)
                .compact();
        authToken.setToken(token);
        return  authToken;
    }
}
