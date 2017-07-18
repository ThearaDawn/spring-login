package com.springdb.repository;

import com.springdb.entity.User;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by k.tith on 5/6/2017.
 */

@Transactional
public interface UserRepository {

    User getByUsername(String username);

    User saveUser(User user);

    void updateUser(User user);

    void deleteUser(Long id);

    List<User> getAllUser();

    User getById(Long id);

    List<User> getAllUserByEmail(String email);
}
