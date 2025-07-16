package com.example.profileservice.service;

import com.example.profileservice.dto.ProfileRequestDTO;
import com.example.profileservice.dto.ProfileResponseDTO;

public interface ProfileService {

    ProfileResponseDTO createProfile(ProfileRequestDTO profileRequestDTO);

    ProfileResponseDTO getProfileWithUser(Long id);
}
