package com.example.jwtloginapp.Entity.Dto;

import lombok.Data;

@Data
public class UserDto {
    private String username;
    private String password;
    private String role;
}
