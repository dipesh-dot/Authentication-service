package com.authenticationservice.security;


import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LoginSuccessResponse {
    private boolean success;
    private String token;
    private String name;
}
