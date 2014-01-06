package com.rolan.examples.regex;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class SimpleZeroMoneyMatchTest {

    private boolean expectedResult;
    private String valueString;
    private App app;

    public SimpleZeroMoneyMatchTest(String valueString, boolean expectedResult) {
        this.expectedResult = expectedResult;
        this.valueString = valueString;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> testData() {
        Object[][] data = {
                {".", false},
                {".0", false},
                {"0.0", true},
                {"0.00", true},
                {"0.000", true},
                {"00.0000", true},

                {"-", false},
                {"-0", true},
                {"-00", true},
                {"-000", true},
                {"-0000", true},
                {"-0,000", true},
                {"-0,0000", true},
                {"-00,000", true},
                {"-0,000,00", true},
                {"-0,000,000", true},
                {"-0,000,000.", false},

                {"+", false},
                {"+0", true},
                {"+00", true},
                {"+000", true},
                {"+0000", true},

                {"", false},
                {"0", true},
                {"00", true},
                {"000", true},
                {"0000", true},

                {"1", false},
                {"0.01", false}
        };
        return Arrays.asList(data);
    }

    @Before
    public void before() {
        app = new App();
    }

    @After
    public void after() {
        app = null;
    }

    @Test
    public void testMatch() {
        assertEquals("Failed to match value '" + valueString + "'.", expectedResult, app.isSimpleZeroMoney(valueString));
    }
}
