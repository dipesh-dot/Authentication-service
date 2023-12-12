package com.authenticationservice.security;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class LoginFailureResponse {
    private boolean success;
    private String message;
}
