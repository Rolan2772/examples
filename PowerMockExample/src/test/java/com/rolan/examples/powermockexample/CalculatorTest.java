package com.rolan.examples.powermockexample;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

@RunWith(PowerMockRunner.class)
@PrepareForTest( MathUtil.class )
public class CalculatorTest {
    
    private Calculator calculator;
    
    @Before
    public void before() {
        calculator = new Calculator();
        PowerMockito.mockStatic(MathUtil.class);
        Mockito.when(MathUtil.addInteger(Mockito.anyInt(), Mockito.anyInt())).thenReturn(0);
    }
    
    @Test
    public void testMockStaticMethod() {
        Assert.assertEquals(0, calculator.add(1, 1));
        Assert.assertEquals(0, calculator.add(2, 2));
    }
    
    @Test
    public void testVerifyStaticMethod() {
        Assert.assertEquals(0, calculator.add(1, 1));
        
        PowerMockito.verifyStatic();
    }
}
