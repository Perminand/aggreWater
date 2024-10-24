package ru.perminov.aggrewater.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.perminov.aggrewater.model.Role;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> getRoleByName(String roleUser);
}

