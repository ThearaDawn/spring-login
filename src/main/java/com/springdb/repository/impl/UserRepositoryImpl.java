package com.springdb.repository.impl;

import com.springdb.entity.User;
import com.springdb.repository.UserRepository;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

/**
 * Created by k.tith on 5/6/2017.
 */
@Repository
@Transactional
public class UserRepositoryImpl implements UserRepository {

    @Autowired
    private SessionFactory sessionFactory;

    private Session getSession()
    {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public void updateUser(User user) {
        user.setDt_upd(new Date());
        getSession().merge(user);
    }

    @Override
    public void deleteUser(Long id) {
        User user = getById(id);
        user.setStatus(false);
        user.setDt_upd(new Date());
        updateUser(user);
    }

    @Override
    public List<User> getAllUser() {
        Criteria criteria = getSession().createCriteria(User.class);
        criteria.add(Restrictions.eq("status", true));
        return (List<User>) criteria.setMaxResults(10).list();
    }

    @Override
    public User getById(Long id) {
        return (User) getSession().get(User.class, id);
    }

    @Override
    public List<User> getAllUserByEmail(String email) {
        Criteria cr = sessionFactory.openSession().createCriteria(User.class);
        cr.add(Restrictions.eq("email", email));
        cr.add(Restrictions.eq("status", true));
        return (List<User>) cr.list();
    }

    @Override
    public User getByUsername(String username) {
        Criteria cr = sessionFactory.openSession().createCriteria(User.class);
        cr.add(Restrictions.eq("username", username));
        cr.add(Restrictions.eq("status", true));
        return (User) cr.uniqueResult();
    }

    @Override
    public User saveUser(User user) {

        User usr = getByUsername(user.getUsername());

        if(usr == null)
        {
            user.setDt_upd(new Date());
            user.setDt_cre(new Date());
            getSession().save(user);
        }

        return usr;
    }
}
