package ru.perminov.aggrewater.service.user;


import ru.perminov.aggrewater.dto.RequestUserCreate;
import ru.perminov.aggrewater.dto.UserDto;
import ru.perminov.aggrewater.model.User;

import java.util.List;

public interface UserService  {
    UserDto create(RequestUserCreate userDto);
    List<UserDto> getAllUsers();

    User createUser(UserDto request);
}
