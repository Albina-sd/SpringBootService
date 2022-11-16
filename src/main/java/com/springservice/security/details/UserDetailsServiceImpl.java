package com.springservice.security.details;

import com.springservice.models.Users;
import com.springservice.repositories.UsersRepositories;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UsersRepositories usersRepositories;

    public UserDetailsServiceImpl(UsersRepositories usersRepositories) {
        this.usersRepositories = usersRepositories;
    }

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        Optional<Users> user = usersRepositories.findByLogin(login);

        return new UserDetailsImpl(usersRepositories.findByLogin(login)
                .orElseThrow(IllegalArgumentException::new));
    }
}
