package com.springservice.security.details;

import com.springservice.models.State;
import com.springservice.models.Users;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;

public class UserDetailsImpl implements UserDetails {
    public UserDetailsImpl(Users users) {
        this.users = users;
    }

    public Users getUsers() {
        return users;
    }

    private Users users;
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        String role = users.getRole().name();
        SimpleGrantedAuthority simpleGrantedAuthority = new SimpleGrantedAuthority(role);
        return Collections.singletonList(simpleGrantedAuthority);
    }

    @Override
    public String getPassword() {
        return users.getHashPassword();
    }

    @Override
    public String getUsername() {
        return users.getLogin();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return !users.getState().equals(State.BANNED);
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return users.getState().equals(State.ACTIVE);
    }
}
