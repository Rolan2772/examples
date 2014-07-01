package com.rolan.examples.spel.inject;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("authorBean")
public class Author {

    @Value("Antoine de Saint-Exupéry")
    private String name;
    @Value("#{bookBean.title}")
    private String bookTitle;
    @Value("#{bookBean}")
    private Book book;
    @Value("#{bookBean.getBookInfo(authorBean.name)}")
    private String fullAuthorInfo;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public String getFullAuthorInfo() {
        return fullAuthorInfo;
    }

    public void setFullAuthorInfo(String fullAuthorInfo) {
        this.fullAuthorInfo = fullAuthorInfo;
    }

    @Override
    public String toString() {
        return "Author{" +
                "name='" + name + '\'' +
                ", bookTitle='" + bookTitle + '\'' +
                ", book=" + book +
                ", fullAuthorInfo=" + fullAuthorInfo +
                '}';
    }
}
