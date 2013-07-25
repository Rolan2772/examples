package com.rolan.examples.spring.crudexample.service;

import com.rolan.examples.spring.crudexample.entity.Contact;
import java.util.List;

public interface CrudService {

    void delete(Long id);

    void save(Contact contact);

    void update(Contact contact);

    Contact getContactById(Long id);

    List<Contact> getAllContacts();
}
