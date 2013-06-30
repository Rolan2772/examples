package com.rolan.examples.spring.crudexample.dao;

import com.rolan.examples.spring.crudexample.entity.Contact;
import java.util.Collections;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository("contactsDao")
@Transactional
public class ContactsDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Transactional(readOnly = true)
    public Contact getContact(Long id) {
        return (Contact) sessionFactory.getCurrentSession().get(Contact.class, id);
    }

    @Transactional(readOnly = true)
    public List<Contact> getContacts(String name) {
        List<Contact> contacts = Collections.EMPTY_LIST;
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Contact.class);
        criteria.add(Restrictions.like("name", name + "%"));
        return contacts;
    }

    @Transactional(readOnly = true)
    public List<Contact> getAllContacts() {
        return sessionFactory.getCurrentSession().createCriteria(Contact.class).list();
    }

    public void save(Contact contact) {
        sessionFactory.getCurrentSession().save(contact);
    }

    public void update(Contact contact) {
        sessionFactory.getCurrentSession().merge(contact);
    }

    public void delete(Long id) {
        Contact contact = getContact(id);
        sessionFactory.getCurrentSession().delete(contact);
    }
}
