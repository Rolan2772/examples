package com.rolan.examples.regex;


import static junit.framework.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class AppTest {

    private App app;

    @Before
    public void before() {
        app = new App();
    }

    @After
    public void after() {
        app = null;
    }

    @Test
    public void testMatchWord() {
        String word = "sdfgsdfgsd";
        assertTrue(app.isWordString(word));
    }

    @Test
    public void testNotMatchWordWithSpace() {
        String wrongWord = "sdfgsd sdfgsdfg";
        assertFalse(app.isWordString(wrongWord));
    }

    @Test
    public void testNotMatchWordWithPoint() {
        String wringWord = "sdfgsdfg.sdfgsdfg";
        assertFalse(app.isWordString(wringWord));
    }
}
