package com.bib.ojt.system.persistence.dao.user;

import org.springframework.data.jpa.repository.JpaRepository;
import com.bib.ojt.system.persistence.entity.User;

import javax.management.relation.Role;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long> {
    Optional<User> findByUsername(String username);
}
