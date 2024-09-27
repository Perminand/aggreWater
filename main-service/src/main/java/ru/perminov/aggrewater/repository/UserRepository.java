package ru.perminov.aggrewater.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.perminov.aggrewater.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
}
