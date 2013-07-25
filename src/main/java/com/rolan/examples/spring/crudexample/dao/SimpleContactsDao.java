package com.rolan.examples.spring.crudexample.dao;

import com.rolan.examples.spring.crudexample.entity.Contact;
import java.util.List;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class SimpleContactsDao implements ContactsDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Contact getContactById(Long id) {
        return (Contact) sessionFactory.getCurrentSession().get(Contact.class, id);
    }

    @Override
    public List<Contact> getAllContacts() {
        return sessionFactory.getCurrentSession().createCriteria(Contact.class).list();
    }

    @Override
    public void save(Contact contact) {
        sessionFactory.getCurrentSession().save(contact);
    }

    @Override
    public void update(Contact contact) {
        sessionFactory.getCurrentSession().merge(contact);
    }

    @Override
    public void delete(Long id) {
        Contact contact = getContactById(id);
        sessionFactory.getCurrentSession().delete(contact);
    }
}
