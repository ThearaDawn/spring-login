package com.springdb.services;

import com.springdb.entity.User;

import java.util.List;

/**
 * Created by t.daun on 7/17/2017.
 */
public interface UserService {
    User findUserByUsername(String username);

    User saveUser(User user);

    void update(User user);

    List<User> getAllUser();

    User getById(Long id);

    void deleteUser(Long id);

    List<User> getAllUserByEmail(String email);
}
