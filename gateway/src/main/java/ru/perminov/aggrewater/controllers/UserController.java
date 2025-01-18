package ru.perminov.aggrewater.controllers;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.perminov.aggrewater.dto.RequestUserCreate;
import ru.perminov.aggrewater.dto.UserDto;
import ru.perminov.aggrewater.service.user.UserService;

@Slf4j
@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
@Validated
public class UserController {
    private final UserService userService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UserDto create(@Valid @RequestBody RequestUserCreate userDto) {
        UserDto userDto1 = userService.create(userDto);
        return userDto1;
    }

}
