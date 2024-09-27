package ru.perminov.aggrewater.controllers;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.perminov.aggrewater.UserDto;

import java.net.http.HttpResponse;

@Slf4j
@RestController
@RequestMapping("/users")
@Validated
public class userController {

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UserDto create (@Valid @RequestBody UserDto userDto) {
        return null;
    }

}
