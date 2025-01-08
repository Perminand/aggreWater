package ru.perminov.aggrewater.service.user;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.perminov.aggrewater.dto.UserDto;
import ru.perminov.aggrewater.model.User;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {


    @Override
    public UserDto create(UserDto userDto) {
        return null;
    }

    @Override
    public List<UserDto> getAllUsers() {
        return List.of();
    }

    @Override
    public User createUser(UserDto request) {
        return null;
    }
}
