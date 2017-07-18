package com.springdb.repository.impl;

import com.springdb.entity.Role;
import com.springdb.repository.RoleRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by KUYLIM on 5/6/2017.
 */
@Repository
@Transactional
public class RoleRepositoryImpl implements RoleRepository {

    @Autowired
    private SessionFactory sessionFactory;

    private Session getSession()
    {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public List<Role> getAllRole() {
        return getSession().createCriteria(Role.class).list();
    }

    @Override
    public void saveRole(Role role) {
        getSession().save(role);
    }

    @Override
    public void updateRole(Role role) {
        getSession().update(role);
    }

    @Override
    public Role getRoleById(Long id)  {
        return (Role) getSession().get(Role.class, id);
    }
}
