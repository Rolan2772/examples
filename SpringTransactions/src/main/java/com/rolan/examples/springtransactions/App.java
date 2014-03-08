package com.rolan.examples.springtransactions;

import com.rolan.examples.springtransactions.dao.impl.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App {
    
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        System.out.println("Hello Transactions :)");
        
        UserService userService = ctx.getBean(UserService.class);
        System.out.println(userService.getUsers());
    }
}
