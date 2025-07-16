package com.example.userservice.soap;

import com.example.userservice.model.User;
import com.example.userservice.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
@RequiredArgsConstructor
public class UserEndpoint {

    private static final String NAMESPACE = "http://example.com/userservice";

    private final UserRepository userRepository;

    @PayloadRoot(namespace = NAMESPACE, localPart = "getUserByIdRequest")
    @ResponsePayload
    public GetUserByIdResponse getUserById(@RequestPayload GetUserByIdRequest getUserByIdRequest) {
        User user = userRepository.findById(getUserByIdRequest.getId())
                .orElseThrow(() -> new RuntimeException("User not found"));

        return new GetUserByIdResponse(user.getId(), user.getName(), user.getEmail());
    }
}
