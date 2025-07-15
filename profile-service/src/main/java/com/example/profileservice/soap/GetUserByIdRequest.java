package com.example.profileservice.soap;

import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@XmlRootElement(name = "getUserByIdRequest")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GetUserByIdRequest {
    private Long id;
}
