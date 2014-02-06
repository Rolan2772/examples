package com.rolan.examples.spring.oxm.jaxb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.oxm.Marshaller;
import org.springframework.oxm.Unmarshaller;

import javax.xml.transform.Result;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.*;

public class JaxbExample {

    @Autowired
    @Qualifier(value = "jaxbMapper")
    private Marshaller marshaller;

    @Autowired
    @Qualifier(value = "jaxbMapper")
    private Unmarshaller unmarshaller;

    @Autowired
    private Book book;

    public static final String FILE_NAME = "book.xml";

    public File save() throws IOException {
        try (OutputStream os = new FileOutputStream(FILE_NAME)) {
            marshaller.marshal(book, new StreamResult(os));
        }
        return new File(FILE_NAME);
    }

    public void load() throws IOException {
        try(InputStream in = new FileInputStream(FILE_NAME)) {
            load(in);
        }
    }

    public void load(InputStream in) throws IOException {
        this.book = (Book) unmarshaller.unmarshal(new StreamSource(in));
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }
}
