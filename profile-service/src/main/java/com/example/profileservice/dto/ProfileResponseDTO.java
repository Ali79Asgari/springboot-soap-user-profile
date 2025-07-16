package com.example.profileservice.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProfileResponseDTO {

    private Long id;

    private Long userId;

    private String bio;

    private String location;

    private Integer age;

    private UserDTO user;
}
