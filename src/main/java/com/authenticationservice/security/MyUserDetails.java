package com.authenticationservice.security;

import com.authenticationservice.entity.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import java.util.Collection;

public class MyUserDetails implements UserDetails {
    private String email;
    private String password;
    private String name;
    private boolean isActive;

   public  MyUserDetails(User user){
       this.email = user.getEmail();
       this.password = user.getPassword();
       this.name=user.getName();
       this.isActive = user.isActive();
   }
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return isActive;
    }


public String getName(){
       return name;
}
}
