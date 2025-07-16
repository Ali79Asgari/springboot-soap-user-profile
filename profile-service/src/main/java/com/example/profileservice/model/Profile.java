package com.example.profileservice.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "profiles")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class Profile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long userId;

    private String bio;

    private String location;

    private Integer age;
}
