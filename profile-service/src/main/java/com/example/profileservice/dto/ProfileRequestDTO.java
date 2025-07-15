package com.example.profileservice.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProfileRequestDTO {

    @NotNull
    private Long userId;

    @NotBlank
    private String bio;

    @NotBlank
    private String location;

    @NotNull
    private Integer age;
}
