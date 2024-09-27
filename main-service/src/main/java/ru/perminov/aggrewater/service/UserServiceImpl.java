package ru.perminov.aggrewater.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.perminov.aggrewater.dto.UserDto;
import ru.perminov.aggrewater.mappers.UserMapper;
import ru.perminov.aggrewater.model.User;
import ru.perminov.aggrewater.repository.UserRepository;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{
    private final UserRepository userRepository;

    @Override
    public UserDto create(UserDto userDto) {
        User user = UserMapper.toEntity(userDto);
        user = userRepository.save(user);
        UserDto userDto1 = UserMapper.toDto(user);
        return userDto1;
    }
}
