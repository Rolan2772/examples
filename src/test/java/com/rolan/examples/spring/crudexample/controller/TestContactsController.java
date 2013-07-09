package com.rolan.examples.spring.crudexample.controller;

import com.rolan.examples.spring.crudexample.dao.ContactsDao;
import com.rolan.examples.spring.crudexample.entity.Contact;
import java.util.Collections;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
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

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
public class TestContactsController {

    @Autowired
    private ContactsDao contactsDao;
    @Autowired
    private ContactsController contactsController;
    private MockMvc mockMvc;

    @Before
    public void setup() {
        mockMvc = MockMvcBuilders.standaloneSetup(contactsController).build();
    }

    @Test
    public void testGetAllContacts() throws Exception {
        mockMvc.perform(post("/")).andExpect(status().isOk());
    }

    @Configuration
    static class ContactsControllerTestConfiguration {

        @Bean
        public ContactsDao contactsDao() {
            return mock(ContactsDao.class);
        }

        @Bean
        ContactsController contactsController() throws NoSuchFieldException {
            return new ContactsController();
        }
    }
}
