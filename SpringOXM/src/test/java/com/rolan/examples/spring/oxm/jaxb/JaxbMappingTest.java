package com.rolan.examples.spring.oxm.jaxb;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import static junit.framework.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"/applicationContext.xml"})
public class JaxbMappingTest {

    @Autowired
    private JaxbExample jaxbExample;

    @Test
    public void testJaxbUnmarshalling() throws IOException {
        try (FileInputStream is = new FileInputStream("book.xml")) {
            jaxbExample.load(is);
        }
        assertEquals(new Book("1", "GWT in action"), jaxbExample.getBook());
    }

    @Test
    public void testJaxbMarshalling() throws IOException {
        assertEquals(FileUtils.readFileToString(new File("book.xml")), FileUtils.readFileToString(jaxbExample.save()));
    }
}
