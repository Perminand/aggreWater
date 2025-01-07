package ru.perminov.aggrewater.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.perminov.aggrewater.model.TokenAccess;

public interface TokenAccessRepository extends JpaRepository<TokenAccess, Long> {
    boolean existsByName(String username);
}
