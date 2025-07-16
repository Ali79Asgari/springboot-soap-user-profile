package com.example.profileservice.soap;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@XmlRootElement(name = "getUserByIdRequest", namespace = "http://example.com/userservice")
@XmlAccessorType(XmlAccessType.FIELD)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GetUserByIdRequest {
    @XmlElement(required = true)
    private Long id;
}
