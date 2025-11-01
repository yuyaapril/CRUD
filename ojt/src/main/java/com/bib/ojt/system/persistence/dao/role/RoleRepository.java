package com.bib.ojt.system.persistence.dao.role;

import com.bib.ojt.system.persistence.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(String admin);
    // Role findByName(String name);
}
