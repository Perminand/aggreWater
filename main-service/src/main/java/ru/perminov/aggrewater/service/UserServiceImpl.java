package ru.perminov.aggrewater.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.perminov.aggrewater.dto.UserDto;
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
}
