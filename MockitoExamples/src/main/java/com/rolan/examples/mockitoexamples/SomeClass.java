package com.rolan.examples.mockitoexamples;

public class SomeClass {

    private Long id;
    private String text;

    public SomeClass() {
    }

    public SomeClass(Long id, String text) {
        this.id = id;
        this.text = text;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return "SomeClass{" +
                "id=" + id +
                ", text='" + text + '\'' +
                '}';
    }
}
