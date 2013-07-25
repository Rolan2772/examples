package com.rolan.examples.spring.crudexample.service;

import com.rolan.examples.spring.crudexample.dao.ContactsDao;
import com.rolan.examples.spring.crudexample.entity.Contact;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class SimpleCrudService implements CrudService {

    @Autowired
    private ContactsDao contactsDao;

    @Override
    public void delete(Long id) {
        contactsDao.delete(id);
    }

    @Override
    public void save(Contact contact) {
        contactsDao.save(contact);
    }

    @Override
    public void update(Contact contact) {
        contactsDao.update(contact);
    }

    @Transactional(readOnly = true)
    @Override
    public Contact getContactById(Long id) {
        return contactsDao.getContactById(id);
    }

    @Transactional(readOnly = true)
    @Override
    public List<Contact> getAllContacts() {
        return contactsDao.getAllContacts();
    }
}
