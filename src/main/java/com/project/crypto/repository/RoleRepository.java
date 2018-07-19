package com.project.crypto.repository;

import com.project.crypto.model.person.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
}
