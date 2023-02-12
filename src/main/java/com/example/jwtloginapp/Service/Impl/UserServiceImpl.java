package com.example.jwtloginapp.Service.Impl;

import com.example.jwtloginapp.Entity.ApiUser;
import com.example.jwtloginapp.Entity.Dto.UserDto;
import com.example.jwtloginapp.Repository.ApiUserRepository;
import com.example.jwtloginapp.Service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final ApiUserRepository apiUserRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public ApiUser readUserByUsername(String username) {
        return apiUserRepository.findByUsername(username).orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public void createUser(UserDto userDto) {
        ApiUser user = new ApiUser();
        Optional<ApiUser> byUsername = apiUserRepository.findByUsername(userDto.getUsername());
        if (byUsername.isPresent()) {
            throw new RuntimeException("User already registered. Please use diferent username");
        }
        user.setUsername(userDto.getUsername());
        user.setPassword(bCryptPasswordEncoder.encode(userDto.getPassword()));
        user.setRole(userDto.getRole());
        apiUserRepository.save(user);
    }
}
