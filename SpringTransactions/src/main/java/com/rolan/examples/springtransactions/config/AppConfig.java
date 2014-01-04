/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rolan.examples.springtransactions.config;

import com.rolan.examples.springtransactions.SimpleUsersDao;
import com.rolan.examples.springtransactions.UsersDao;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *
 * @author User
 */
@Configuration
public class AppConfig {
    
    @Bean
    public UsersDao getUsersDao() {
        return new SimpleUsersDao();
    } 
}
