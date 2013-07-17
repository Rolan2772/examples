package com.rolan.examples.spring.crudexample.dao;

import java.util.Properties;
import javax.sql.DataSource;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
public class TestContactsDao {

    @Autowired
    private ContactsDao contactsDao;
    @Autowired
    private EmbeddedDatabase db;

    @Configuration
    @PropertySource("classpath:/dao.properties")
    @EnableTransactionManagement
    static class ContactsDaoTestConfiguration {
        
        @Value("${jdbc.url}") 
        private String dataBaseUrl;

        @Bean
        public EmbeddedDatabase dataSource1() {
            /*EmbeddedDatabaseBuilder builder = new EmbeddedDatabaseBuilder();
             return builder.setType(EmbeddedDatabaseType.H2).build();
             */
            return null;
        }

        @Bean
        public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
            return new PropertySourcesPlaceholderConfigurer();
        }

        @Bean
        public ContactsDao contactsDao() {
            return new SimpleContactsDao();
        }

        @Bean
        public DataSource dataSource() {
            DriverManagerDataSource ds = new DriverManagerDataSource();
            ds.setDriverClassName("com.mysql.jdbc.Driver");
            ds.setUsername("crud_test");
            ds.setPassword("111111");
            ds.setUrl(dataBaseUrl);
            return ds;
        }

        private Properties hibernateProperties() {
            Properties properties = new Properties();
            properties.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
            properties.setProperty("hibernate.show_sql", "true");
            return properties;
        }

        @Bean
        public LocalSessionFactoryBean sessionFactory() {
            LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
            sessionFactory.setDataSource(dataSource());
            sessionFactory.setPackagesToScan(new String[]{
                "com.rolan.examples.spring.crudexample.entity"});
            sessionFactory.setHibernateProperties(hibernateProperties());
            return sessionFactory;
        }

        @Bean
        public HibernateTransactionManager transactionManager() {
            return new HibernateTransactionManager(sessionFactory().getObject());
        }
    }

    @Test
    public void testGetContactById() {
        contactsDao.getContactById(1L);
    }

    @After
    public void shutDown() {
        // db.shutdown();
    }
}
