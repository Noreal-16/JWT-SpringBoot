package com.example.jwtloginapp.Service;

import com.example.jwtloginapp.Entity.ApiUser;
import com.example.jwtloginapp.Entity.Dto.UserDto;
import com.example.jwtloginapp.Repository.ApiUserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    public ApiUser readUserByUsername(String username);

    public void createUser(UserDto userDto);
}
