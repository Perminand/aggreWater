package ru.perminov.aggrewater.security;

import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.perminov.aggrewater.repository.TokenAccessRepository;
import ru.perminov.aggrewater.repository.UserRepository;
import ru.perminov.aggrewater.service.jwt.JwtService;
import ru.perminov.aggrewater.service.user.UserSecurityService;
import ru.perminov.aggrewater.service.user.UserService;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
    private final UserRepository userRepository;
    private final TokenAccessRepository tokenAccessRepository;
    private final UserService userService;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final UserSecurityService userSecurityService;

    /**
     * Регистрация пользователя
     *
     * @param request данные пользователя
     * @return токен
     */
    public JwtAuthenticationResponse signUp(UserDtoWeb request) {
        User user = userService.create(request);
        return new JwtAuthenticationResponse(user.getTokenAccess().getName());
    }

    /**
     * Аутентификация пользователя
     *
     * @param request данные пользователя
     * @return токен
     */
    public JwtAuthenticationResponse signIn(SignInRequest request) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                request.getUsername(),
                request.getPassword()
        ));
        LocalDate nowTime = LocalDate.now();
        User user = (User) userSecurityService.loadUserByUsername(request.getUsername());
        String jwt;
        TokenAccess tokenAccess = user.getTokenAccess();

        for (Role r : user.getRoles()) {
            if (r.getName().equals("ROLE_ADMIN")) {
                LocalDate endDate = nowTime.plusMonths(1);
                if (tokenAccess == null) {
                    jwt = jwtService.generateToken(user, endDate);
                    tokenAccess = new TokenAccess();
                    tokenAccess.setName(jwt);
                    tokenAccess.setDataCreated(nowTime);
                }
                tokenAccess.setEndData(endDate);
                tokenAccessRepository.save(tokenAccess);
                user.setTokenAccess(tokenAccess);
                user.setUpdatedAt(LocalDateTime.now());
                userRepository.save(user);
            }
            break;
        }

        return new JwtAuthenticationResponse(tokenAccess.getName());
    }
    }
