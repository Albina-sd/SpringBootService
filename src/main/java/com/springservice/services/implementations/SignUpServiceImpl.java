package com.springservice.services.implementations;

import com.springservice.forms.UserForm;
import com.springservice.models.Role;
import com.springservice.models.State;
import com.springservice.models.Users;
import com.springservice.repositories.UsersRepositories;
import com.springservice.services.SignUpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service
public class SignUpServiceImpl implements SignUpService {
    private final UsersRepositories usersRepositories;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public SignUpServiceImpl(UsersRepositories usersRepositories, PasswordEncoder passwordEncoder) {
        this.usersRepositories = usersRepositories;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void signUp(UserForm userForm) {
        String hashPassword = passwordEncoder.encode(userForm.getPassword());
        Users user = Users.builder()
                .firstName(userForm.getFirstName())
                .lastName(userForm.getLastName())
                .login(userForm.getLogin())
                .hashPassword(hashPassword)
                .role(Role.USER)
                .state(State.ACTIVE)
                .build();

        usersRepositories.save(user);
    }
}
