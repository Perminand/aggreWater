package ru.perminov.aggrewater.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.perminov.aggrewater.dto.UserDto;
import ru.perminov.aggrewater.dto.response.JwtAuthenticationResponse;
import ru.perminov.aggrewater.security.AuthenticationService;

@RestController
@RequestMapping("/api/v1/apps/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthenticationService authenticationService;

    @PostMapping("/login")
    @ResponseStatus(HttpStatus.OK)
    public JwtAuthenticationResponse signIn(@RequestBody UserDto request) {
        return authenticationService.signIn(request);
    }


}