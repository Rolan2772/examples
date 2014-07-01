package com.rolan.examples.spel.expressions;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("simpleBean")
public class SimpleBean {

    @Value("someone@mail.com")
    private String email;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
