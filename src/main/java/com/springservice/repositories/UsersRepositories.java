package com.springservice.repositories;

import com.springservice.models.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsersRepositories extends JpaRepository<Users, Long> {
    Optional<Users> findByLogin(String login);
}
