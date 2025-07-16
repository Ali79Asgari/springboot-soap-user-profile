package com.example.profileservice.soap;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@XmlRootElement(name = "getUserByIdResponse")
@XmlAccessorType(XmlAccessType.FIELD)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GetUserByIdResponse {
    private Long id;
    private String name;
    private String email;
}
