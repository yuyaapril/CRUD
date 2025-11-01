package com.bib.ojt.system.persistence.dao.user;

import org.springframework.data.jpa.repository.JpaRepository;
import com.bib.ojt.system.persistence.entity.CustomUser;

import java.util.Optional;

public interface CustomUserRepository extends JpaRepository<CustomUser,Long> {
    Optional<CustomUser> findByUsername(String username);
}
