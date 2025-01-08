package ru.perminov.aggrewater.controllers;

import org.springframework.boot.Banner;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;

@Controller
public class PageController {

    @GetMapping("/login")
    @ResponseStatus(HttpStatus.OK)
    public String getLogin() {
        return "login";
    }

    @GetMapping("/users/{id}")
    @ResponseStatus(HttpStatus.OK)
    public String getUserById(@PathVariable Long id, Model model) {

        return "login";
    }

    @GetMapping("/users/")
    @ResponseStatus(HttpStatus.OK)
    public String getUsers(Model model) {

        return "login";
    }

    @GetMapping("/create")
    @ResponseStatus(HttpStatus.OK)
    public String getCreate() {
        return "create";
    }
}
