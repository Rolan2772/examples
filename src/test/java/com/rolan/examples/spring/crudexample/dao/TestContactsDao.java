package com.rolan.examples.spring.crudexample.dao;

import com.rolan.examples.spring.crudexample.entity.Contact;
import java.util.List;
import java.util.Properties;
import javax.sql.DataSource;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.ImportResource;

import static org.junit.Assert.*;
import org.junit.Ignore;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
@Transactional
public class TestContactsDao {

    @Autowired
    private ContactsDao contactsDao;
    @Autowired
    private TestDaoSupport daoSupport;
    
    @Test
    public void testGetContactById() {
        Contact expectedContact = new Contact("Test user 1", "350 Fifth Avenue, 34th floor. New York, NY");
        daoSupport.createContact(expectedContact);

        Contact actualContact = contactsDao.getContactById(expectedContact.getId());
        assertNotNull(actualContact);
        assertEquals(expectedContact, actualContact);
    }

    @Test
    public void testGetAllContacts() {
        Contact contact1 = new Contact("Test user 1", "350 Fifth Avenue, 34th floor. New York, NY");
        daoSupport.createContact(contact1);
        Contact contact2 = new Contact("Test user 2", "12755 Quincy Avenue , Holland, MI 49424");
        daoSupport.createContact(contact2);
        
        List<Contact> contacts = contactsDao.getAllContacts();
        assertEquals(2, contacts.size());
        assertTrue(contacts.contains(contact1));
        assertTrue(contacts.contains(contact2));
    }

    @Configuration
    @ImportResource("classpath:/com/rolan/examples/spring/crudexample/dao/spring-resources.xml")
    @EnableTransactionManagement
    static class ContactsDaoTestConfiguration {

        @Autowired
        @Qualifier("hibernateProperties")
        private Properties hibernateProperties;

        @Bean
        public DataSource dataSource() {
            EmbeddedDatabaseBuilder builder = new EmbeddedDatabaseBuilder();
            return builder.setType(EmbeddedDatabaseType.H2).build();
        }

        @Bean
        public ContactsDao contactsDao() {
            return new SimpleContactsDao();
        }

        @Bean
        public LocalSessionFactoryBean sessionFactory() {
            LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
            sessionFactory.setDataSource(dataSource());
            sessionFactory.setPackagesToScan(new String[]{"com.rolan.examples.spring.crudexample.entity"});
            sessionFactory.setHibernateProperties(hibernateProperties);
            return sessionFactory;
        }

        @Bean
        public HibernateTransactionManager transactionManager() {
            return new HibernateTransactionManager(sessionFactory().getObject());
        }
        
        @Bean
        public TestDaoSupport daoSupport() {
            return new TestDaoSupport();
        }
    }
}
