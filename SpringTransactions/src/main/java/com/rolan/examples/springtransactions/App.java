package com.rolan.examples.springtransactions;

import com.rolan.examples.springtransactions.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App {

    private ApplicationContext ctx;
    
    public static void main(String[] args) {
        App app = new App();
        app.testRequiresNew();
    }

    public App() {
        ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        System.out.println("Hello Transactions :)");
    }

    public void test() {
        UserService userService = ctx.getBean(UserService.class);
        System.out.println(userService.getUsers());
        System.out.println("Creating user...");
        userService.createUser("Rolan");
    }

    public void testRequiresNew() {
        UserService userService = ctx.getBean(UserService.class);
        userService.requiresNewTest();
    }
}
