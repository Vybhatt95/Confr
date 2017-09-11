package com.p2.data;


import com.p2.Objects.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.io.Serializable;

@Repository
@Transactional
public class UserDao implements Dao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public User findOne(Serializable id) {
        Session s = sessionFactory.getCurrentSession();
        return (User) s.get(User.class, id);
    }
}
