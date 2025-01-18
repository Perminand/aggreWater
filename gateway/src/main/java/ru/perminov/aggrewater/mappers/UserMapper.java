package ru.perminov.aggrewater.mappers;

import ru.perminov.aggrewater.dto.RequestUserCreate;
import ru.perminov.aggrewater.dto.UserDto;
import ru.perminov.aggrewater.model.User;

public class UserMapper {
    public static UserDto toDto (User user) {
        return new UserDto(user.getId(), user.getUsername(), user.getUsername());
    }

    public static User toEntity(RequestUserCreate userDto) {
        return User.builder()
                .username(userDto.getEmail())
                .password(userDto.getRealPassword())
                .build();
    }
}
