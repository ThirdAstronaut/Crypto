package com.project.crypto.repository;

import com.project.crypto.model.person.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    User findBySurname(String surname);
}
