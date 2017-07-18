package com.springdb.repository;

import com.springdb.entity.Role;

import java.util.List;

/**
 * Created by KUYLIM on 5/6/2017.
 */
public interface RoleRepository {
    Role getRoleById(Long id);

    void saveRole(Role role);

    void updateRole(Role role);

    List<Role> getAllRole();
}
