package ru.perminov.aggrewater.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public class UserDto {
    private Long id;

    @Getter
    @NotBlank
    @Email
    @Size(min = 5, max = 50)
    private String email;

    @Getter
    @NotBlank
    @Size(min = 3, max = 50)
    private String name;
}
