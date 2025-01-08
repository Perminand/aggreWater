package ru.perminov.aggrewater.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.perminov.aggrewater.model.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);

    boolean existsByUsername(String username);
}
