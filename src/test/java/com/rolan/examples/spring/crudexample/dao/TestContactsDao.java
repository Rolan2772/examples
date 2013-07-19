package com.rolan.examples.spring.crudexample.dao;

import com.rolan.examples.spring.crudexample.entity.Contact;
import java.util.Properties;
import javax.sql.DataSource;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import static org.junit.Assert.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.ImportResource;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
public class TestContactsDao {

    @Autowired
    private ContactsDao contactsDao;

    @Test
    public void testGetContactById() {
        Long id = 7L;
        Contact contact = contactsDao.getContactById(id);
        assertNotNull(contact);
        assertEquals(id, contact.getId());
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
    }
}
