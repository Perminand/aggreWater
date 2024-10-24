package ru.perminov.aggrewater.service;

import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Import;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.perminov.aggrewater.dto.UserDto;
import ru.perminov.aggrewater.exceptions.errors.EntityNotFoundException;
import ru.perminov.aggrewater.mappers.UserMapper;
import ru.perminov.aggrewater.model.Role;
import ru.perminov.aggrewater.model.User;
import ru.perminov.aggrewater.repository.RoleRepository;
import ru.perminov.aggrewater.repository.UserRepository;

import java.util.Collections;
import java.util.List;

@Service
@Import({BCryptPasswordEncoder.class})
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;


    private EntityManager em;

    @Override
    @Transactional
    public UserDto create(UserDto userDto) {
        User user = UserMapper.toEntity(userDto);
        user.setRoles(Collections.singleton(
                roleRepository.getRoleByName("ROLE_USER").orElse(new Role("ROLE_USER"))));
        user.setPassword(bCryptPasswordEncoder.encode(userDto.getPassword()));
        user = userRepository.save(user);
        return UserMapper.toDto(user);
    }

    @Override
    public List<UserDto> getAllUsers() {
        List<User> userList = userRepository.findAll();
        return userList.stream().map(UserMapper::toDto).toList();
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByUsername(username).orElseThrow(() -> new EntityNotFoundException("Юзер не найден"));
    }
}
