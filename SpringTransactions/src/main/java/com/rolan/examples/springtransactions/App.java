package com.rolan.examples.springtransactions;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Hello world!
 *
 */
public class App {
    
    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext("com.rolan.examples.springtransactions.config");
        System.out.print("Hello Transactions :)");
        
        UsersDao dao = ctx.getBean(UsersDao.class);
        System.out.println(dao.getUsers());
    }
}
