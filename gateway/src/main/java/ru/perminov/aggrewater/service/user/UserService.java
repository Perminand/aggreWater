package ru.perminov.aggrewater.service.user;


import ru.perminov.aggrewater.dto.UserDto;
import java.util.List;

public interface UserService  {
    UserDto create(UserDto userDto);
    List<UserDto> getAllUsers();
}
