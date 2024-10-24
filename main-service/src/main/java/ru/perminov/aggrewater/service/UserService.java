package ru.perminov.aggrewater.service;


import org.springframework.security.core.userdetails.UserDetailsService;
import ru.perminov.aggrewater.dto.UserDto;
import java.util.List;

public interface UserService extends UserDetailsService {
    UserDto create(UserDto userDto);
    List<UserDto> getAllUsers();
}
