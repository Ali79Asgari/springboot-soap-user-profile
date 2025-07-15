package com.example.profileservice.soap;

import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@XmlRootElement(name = "getUserByIdResponse")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GetUserByIdResponse {
    private Long id;
    private String name;
    private String email;
}
