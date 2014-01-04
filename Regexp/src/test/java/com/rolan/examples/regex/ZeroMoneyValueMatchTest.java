package com.rolan.examples.regex;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static junit.framework.Assert.*;

@RunWith(Parameterized.class)
public class ZeroMoneyValueMatchTest {

    private String testValue;
    private boolean expectedResult;
    private App app;

    public ZeroMoneyValueMatchTest(String testValue, boolean expectedResult) {
        this.testValue = testValue;
        this.expectedResult = expectedResult;
    }

    @Before
    public void before() {
        app = new App();
    }

    @After
    public void after() {
        app = null;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> testData() {
        Object[][] data = {
                {".", false},
                {".0", false},
                {"0.0", true},
                {"0.00", true},
                {"0.000", true},

                {"-", false},
                {"-0", true},
                {"-00", true},
                {"-000", true},
                {"-0000", false},
                {"-0,000", true},
                {"-0,0000", false},
                {"-00,000", true},
                {"-0,000,00", false},
                {"-0,000,000", true},
                {"-0,000,000.", false},

                {"+", false},
                {"+0", true},
                {"+00", true},
                {"+000", true},
                {"+0000", false},

                {"", false},
                {"0", true},
                {"00", true},
                {"000", true},
                {"0000", false}

        };
        return Arrays.asList(data);
    }

    @Test
    public void testMatch() {
        assertEquals("Failed to match string '" + testValue + "'.", expectedResult, app.isZeroMoneyValue(testValue));
    }
}
