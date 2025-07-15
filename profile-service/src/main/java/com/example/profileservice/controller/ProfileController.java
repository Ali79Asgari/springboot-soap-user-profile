package com.example.profileservice.controller;

import com.example.profileservice.dto.ProfileRequestDTO;
import com.example.profileservice.dto.ProfileResponseDTO;
import com.example.profileservice.service.ProfileService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/profiles")
@RequiredArgsConstructor
public class ProfileController {

    private final ProfileService profileService;

    @PostMapping
    public ResponseEntity<ProfileResponseDTO> createProfile(@Valid @RequestBody ProfileRequestDTO dto) {
        return ResponseEntity.ok(profileService.createProfile(dto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProfileResponseDTO> getProfileWithUser(@PathVariable Long id) {
        return ResponseEntity.ok(profileService.getProfileWithUser(id));
    }
}
