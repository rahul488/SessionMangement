package com.example.Login.Service;

import com.example.Login.Entity.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.io.Serializable;
import java.util.*;
import java.util.stream.Collectors;

public class UserPrinciple implements UserDetails, Serializable {



    String email;
    String password;
    Set<SimpleGrantedAuthority> authority=new HashSet<>();
    User user;

    public UserPrinciple(User user) {
        this.user=user;
        email=user.getEmail();
        password=user.getPassword();
        authority= Arrays.stream(user.getRole().split(",")).map(SimpleGrantedAuthority::new).collect(Collectors.toSet());
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authority;
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
        return true;
    }


    @Override
    public int hashCode() {
        return user.getEmail().hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof User) {
            return user.getEmail().equals(((User) obj).getEmail());
        }
        return false;
    }
}
