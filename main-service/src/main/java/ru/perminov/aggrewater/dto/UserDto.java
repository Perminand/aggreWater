package ru.perminov.aggrewater.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@AllArgsConstructor
public class UserDto {

    private Long id;

    @NotBlank
    @Email
    @Size(min = 5, max = 50)
    private String email;

    @NotBlank
    @Size(min = 3, max = 50)
    private String name;
}
