package com.rolan.examples.spring.crudexample.controller;

import com.rolan.examples.spring.crudexample.controller.TestContactsController.ContactsControllerTestConfiguration;
import com.rolan.examples.spring.crudexample.dao.ContactsDao;
import com.rolan.examples.spring.crudexample.dao.SimpleContactsDao;
import com.rolan.examples.spring.crudexample.entity.Contact;
import java.util.Collection;
import java.util.Collections;
import org.hibernate.SessionFactory;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.mockito.Mockito.*;
import org.springframework.util.ReflectionUtils;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
public class TestContactsController {

    @Autowired
    private ContactsDao contactsDao;
    @Autowired
    private ContactsController contactsController;

    @Before
    public void setup() {
        when(contactsDao.getAllContacts()).thenReturn(Collections.<Contact>emptyList());
    }

    
    @Test
    @Ignore
    public void testGetAllContacts() throws Exception {
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(contactsController).build();
        mockMvc.perform(post("/")).andExpect(status().isOk());
    }

    @Configuration
    static class ContactsControllerTestConfiguration {

        @Bean
        public ContactsDao contactsDao() {
            return mock(SimpleContactsDao.class);
        }
        
        @Bean
        ContactsController contactsController() throws NoSuchFieldException {
            return new ContactsController();
        }
    }
}
