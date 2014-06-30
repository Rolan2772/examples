package com.rolan.examples.js;



import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;

public class Greeting {

    @NotNull
    private Integer id;
    @NotEmpty
    private String content;

    public Greeting() {
    }

    public Greeting(Integer id, String content) {
        this.id = id;
        this.content = content;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
