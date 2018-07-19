package com.project.crypto.service;


import com.project.crypto.model.person.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    List<User> userList();

    Optional<User> findOne(Long id);

    User addUser(User user);

    String deleteUser(Long id);
}
