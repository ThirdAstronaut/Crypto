package com.project.crypto.repository;

import com.project.crypto.model.person.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<User, Long> {

    @Query("FROM Users WHERE userName=:username")
    User findByUsername(@Param("username") String username);
}
