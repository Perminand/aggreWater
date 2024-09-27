package ru.perminov.aggrewater;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;


public class UserDto {
    private Long id;
    @NotBlank
    @Email
    @Size(min = 5, max = 50)
    private String mail;
    @NotBlank
    @Size(min = 3, max = 50)
    private String name;
}
