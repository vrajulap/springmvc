package com.wiiflex.account.service;

import java.util.List;

import com.wiiflex.account.model.User;

public interface UserService {
    void save(User user);

    User findByUsername(String username);
    
    List<User> findAllUsers();
}
