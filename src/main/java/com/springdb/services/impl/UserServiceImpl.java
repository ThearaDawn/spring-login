package com.springdb.services.impl;

import com.springdb.entity.User;
import com.springdb.repository.UserRepository;
import com.springdb.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by KUYLIM on 5/6/2017.
 */
@Service
public class UserServiceImpl implements UserService {


    @Autowired
    private UserRepository userRepository;

    @Override
    public User findUserByUsername(String username) {
        return userRepository.getByUsername(username);
    }

    @Override
    public void update(User user) {
        userRepository.updateUser(user);
    }

    @Override
    public List<User> getAllUser() {
        return userRepository.getAllUser();
    }

    @Override
    public User getById(Long id) {
        return userRepository.getById(id);
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteUser(id);
    }

    @Override
    public List<User> getAllUserByEmail(String email) {
        return userRepository.getAllUserByEmail(email);
    }

    @Override
    public User saveUser(User user) {
        return userRepository.saveUser(user);
    }
}
