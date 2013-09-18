package com.rolan.examples.spring.crudexample.dao;

import com.rolan.examples.spring.crudexample.entity.User;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class UsersDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Transactional(readOnly = true)
    public List<User> getUsers() {
        Query query = sessionFactory.getCurrentSession().createQuery(
                "from User where status.id = :status and priority = (select min(priority) from User where status.id = :status)");
        query.setParameter("status", 1L);
        return query.list();
    }
}
