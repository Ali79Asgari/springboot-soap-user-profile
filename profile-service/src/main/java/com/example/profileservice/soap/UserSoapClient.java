package com.example.profileservice.soap;

import com.example.profileservice.dto.UserDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.ws.client.core.WebServiceTemplate;

@Component
@RequiredArgsConstructor
public class UserSoapClient {

    private final WebServiceTemplate webServiceTemplate;

    public UserDTO getUserById(Long userId) {
        GetUserByIdRequest request = new GetUserByIdRequest();
        request.setId(userId);

        GetUserByIdResponse response = (GetUserByIdResponse)
                webServiceTemplate.marshalSendAndReceive(request);

        if (response == null || response.getId() == null) {
            return null;
        }

        return UserDTO.builder()
                .id(response.getId())
                .name(response.getName())
                .email(response.getEmail())
                .build();
    }
}
