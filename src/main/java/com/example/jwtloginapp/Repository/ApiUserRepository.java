package com.example.jwtloginapp.Repository;

import com.example.jwtloginapp.Entity.ApiUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ApiUserRepository extends JpaRepository<ApiUser, Long> {

    Optional<ApiUser> findByUsername(String username);
}
