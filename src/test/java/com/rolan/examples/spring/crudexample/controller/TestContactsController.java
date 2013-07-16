package com.rolan.examples.spring.crudexample.controller;

import com.rolan.examples.spring.crudexample.dao.ContactsDao;
import com.rolan.examples.spring.crudexample.entity.Contact;
import java.util.Collections;
import java.util.List;
import org.hamcrest.Matchers;
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
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.mockito.Mockito;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

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
    public void testDefaultPage() throws Exception {
        List<Contact> contactsList = Collections.<Contact>emptyList();
        Mockito.when(contactsDao.getAllContacts()).thenReturn(contactsList);
        mockMvc.perform(MockMvcRequestBuilders.post("/")).
                andExpect(MockMvcResultMatchers.status().isOk()).
                andExpect(MockMvcResultMatchers.view().name("/contacts/showContacts")).
                andExpect(MockMvcResultMatchers.model().attribute("contacts", contactsList));
    }

    @Test
    public void testViewAllContacts() throws Exception {
        List<Contact> contactsList = Collections.<Contact>emptyList();
        Mockito.when(contactsDao.getAllContacts()).thenReturn(contactsList);
        mockMvc.perform(MockMvcRequestBuilders.post("/contacts/viewAllContacts")).
                andExpect(MockMvcResultMatchers.status().isOk()).
                andExpect(MockMvcResultMatchers.view().name("/contacts/showContacts")).
                andExpect(MockMvcResultMatchers.model().attribute("contacts", contactsList));
    }

    @Test
    public void testCreateContact() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/contacts/contactDetail")).
                andExpect(MockMvcResultMatchers.status().isOk()).
                andExpect(MockMvcResultMatchers.view().name("contacts/contactDetail")).
                andExpect(MockMvcResultMatchers.model().
                attribute("contact", Matchers.notNullValue()));
    }

    @Test
    public void testEditContact() throws Exception {
        Long contactId = 1L;
        Contact contact = new Contact();
        contact.setId(contactId);
        Mockito.when(contactsDao.getContactById(contactId)).thenReturn(contact);
        mockMvc.perform(MockMvcRequestBuilders.get("/contacts/contactDetail").
                param("id", Long.toString(contactId))).
                andExpect(MockMvcResultMatchers.status().isOk()).
                andExpect(MockMvcResultMatchers.view().name("contacts/contactDetail")).
                andExpect(MockMvcResultMatchers.model().attribute("contact", contact));
    }

    @Test
    public void testContactUpdate() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/contacts/contactDetail").
                param("name", "name")).
                andExpect(MockMvcResultMatchers.status().isMovedTemporarily()).
                andExpect(MockMvcResultMatchers.redirectedUrl("/contacts/viewAllContacts"));
    }

    @Test
    public void testWrongContactUpdate() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/contacts/contactDetail")).
                andExpect(MockMvcResultMatchers.status().isOk()).
                andExpect(MockMvcResultMatchers.model().attributeHasFieldErrors("contact", "name"));
    }

    @Test
    public void testDeleteContact() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/contacts/deleteContact").
                param("id", Long.toString(1L))).
                andExpect(MockMvcResultMatchers.status().isMovedTemporarily()).
                andExpect(MockMvcResultMatchers.redirectedUrl("/contacts/viewAllContacts"));
    }

    @Configuration
    static class ContactsControllerTestConfiguration {

        @Bean
        public ContactsDao contactsDao() {
            return Mockito.mock(ContactsDao.class);
        }

        @Bean
        ContactsController contactsController() throws NoSuchFieldException {
            return new ContactsController();
        }
    }
}
