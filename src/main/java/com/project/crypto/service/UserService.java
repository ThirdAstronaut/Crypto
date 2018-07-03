package com.project.crypto.service;


import com.project.crypto.model.person.User;

import java.util.List;

public interface UserService {
    List<User> userList();

    User findOne(Long id);

    User addUser(User user);

    String deleteUser(Long id);
}
