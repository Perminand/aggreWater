package ru.perminov.aggrewater.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {

    private Long id;

    @NotBlank
    @Email
    @Size(min = 5, max = 50)
    private String email;

    @Size(min = 3, max = 50)
    private String username;

    @NotBlank
    @Size(min = 6)
    private String password;

    private String PasswordConfirm;

    public UserDto(Long id, String email, String name) {
        this.id = id;
        this.email = email;
        this.username = email;
    }
}
