package com.rolan.examples.spring.oxm;

import com.rolan.examples.spring.oxm.jaxb.JaxbExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

public class App {

    @Autowired
    private CastorExample castorExample;

    @Autowired
    public JaxbExample jaxbExample;

    public static void main(String[] args) throws IOException {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        App app = (App) context.getBean("app");
        app.executeCastorExample();
        app.executeJaxbExample();

    }

    private void executeCastorExample() throws IOException {
        castorExample.saveSettings();
        castorExample.loadSettings();
    }

    private void executeJaxbExample() throws IOException {
        jaxbExample.save();
        jaxbExample.load();
    }


}
