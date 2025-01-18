package ru.perminov.aggrewater.service.user;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.perminov.aggrewater.dto.RequestUserCreate;
import ru.perminov.aggrewater.dto.UserDto;
import ru.perminov.aggrewater.exceptions.errors.ConflictException;
import ru.perminov.aggrewater.exceptions.errors.EntityNotFoundException;
import ru.perminov.aggrewater.mappers.UserMapper;
import ru.perminov.aggrewater.model.Role;
import ru.perminov.aggrewater.model.User;
import ru.perminov.aggrewater.repository.RoleRepository;
import ru.perminov.aggrewater.repository.UserRepository;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;


    @Override
    public UserDto create(RequestUserCreate userDto) {
        if (userRepository.existsByUsername(userDto.getEmail())) {
            throw new ConflictException("Пользователь с такой почтой уже существует");
        }

        User user = UserMapper.toEntity(userDto);
        Role role = roleRepository.findByName("ROLE_USER").orElseThrow(() -> new EntityNotFoundException("Roles not found"));
        if (user.getRoles() == null) {
            user.setRoles(new HashSet<>());
        }
        user.getRoles().add(role);
        user.setCreatedAt(LocalDateTime.now());
        user = userRepository.save(user);
        return UserMapper.toDto(user);
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
