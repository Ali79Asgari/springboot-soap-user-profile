package com.example.userservice.service;

import com.example.userservice.dto.UserRequestDTO;
import com.example.userservice.dto.UserResponseDTO;
import com.example.userservice.model.User;
import com.example.userservice.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public UserResponseDTO createUser(UserRequestDTO userRequestDTO) {
        User user = User.builder()
                .name(userRequestDTO.getName())
                .email(userRequestDTO.getEmail())
                .build();

        User savedUser = userRepository.save(user);
        return toDTO(savedUser);
    }

    @Override
    public UserResponseDTO getUserById(Long id) {
        User user = userRepository.findById(id).orElseThrow(
                () -> new RuntimeException("User not found")
        );
        return toDTO(user);
    }

    @Override
    public List<UserResponseDTO> getAllUsers() {
        return userRepository.findAll()
                .stream()
                .map(this::toDTO)
                .toList();
    }

    private UserResponseDTO toDTO(User user) {
        return UserResponseDTO.builder()
                .id(user.getId())
                .name(user.getName())
                .email(user.getEmail())
                .build();
    }

    ;
}
