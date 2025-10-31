package com.bib.ojt.system.persistence.dao.role;

import com.bib.ojt.system.persistence.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;



public interface RoleRepository extends JpaRepository<Role, Long> {
}
