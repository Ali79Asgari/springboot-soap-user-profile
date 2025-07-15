package com.example.profileservice.service;

import com.example.profileservice.dto.ProfileRequestDTO;
import com.example.profileservice.dto.ProfileResponseDTO;
import com.example.profileservice.dto.UserDTO;
import com.example.profileservice.model.Profile;
import com.example.profileservice.repository.ProfileRepository;
import com.example.profileservice.soap.UserSoapClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProfileServiceImpl implements ProfileService {

    private final ProfileRepository profileRepository;
    private final UserSoapClient userSoapClient;

    @Override
    public ProfileResponseDTO createProfile(ProfileRequestDTO dto) {
        UserDTO user = userSoapClient.getUserById(dto.getUserId());

        if (user == null) {
            throw new RuntimeException("User not found");
        }

        Profile profile = Profile.builder()
                .userId(dto.getUserId())
                .bio(dto.getBio())
                .location(dto.getLocation())
                .age(dto.getAge())
                .build();

        Profile saved = profileRepository.save(profile);

        return toDto(saved, user);
    }

    @Override
    public ProfileResponseDTO getProfileWithUser(Long id) {
        Profile profile = profileRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Profile not found"));

        UserDTO user = userSoapClient.getUserById(profile.getUserId());

        return toDto(profile, user);
    }

    private ProfileResponseDTO toDto(Profile profile, UserDTO user) {
        return ProfileResponseDTO.builder()
                .id(profile.getId())
                .userId(profile.getUserId())
                .bio(profile.getBio())
                .location(profile.getLocation())
                .age(profile.getAge())
                .user(user)
                .build();
    }
}
