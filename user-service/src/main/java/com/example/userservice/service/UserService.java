package com.example.userservice.service;

import com.example.userservice.dto.UserRequestDTO;
import com.example.userservice.dto.UserResponseDTO;

import java.util.List;

public interface UserService {
    UserResponseDTO createUser(UserRequestDTO userRequestDTO);

    UserResponseDTO getUserById(Long id);

    List<UserResponseDTO> getAllUsers();
}
