package com.rolan.examples.spring.crudexample.dao;

import com.rolan.examples.spring.crudexample.entity.Contact;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class TestDaoSupport {
    
    @Autowired
    private SessionFactory sessionFactory;
    
    @Transactional
    public void createContact(Contact contact) {
        sessionFactory.getCurrentSession().save(contact);
    }
}
