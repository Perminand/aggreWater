package ru.perminov.aggrewater.mappers;

import ru.perminov.aggrewater.dto.UserDto;
import ru.perminov.aggrewater.model.User;

public class UserMapper {
    public static User toEntity(UserDto userDto) {

        return new User(userDto.getEmail(), userDto.getUsername());
    }

    public static UserDto toDto (User user) {
        return new UserDto(user.getId(), user.getEmail(), user.getUsername());
    }
}
