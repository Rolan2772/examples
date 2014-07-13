package com.rolan.examples;

import org.junit.BeforeClass;
import org.junit.Test;

import javax.validation.*;
import java.util.Set;

import static junit.framework.Assert.assertEquals;

public class CarValidationTest {

    private static Validator validator;

    @BeforeClass
    public static void setUp() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Test
    public void testCarValidation() {
        Car car = new Car();
        Set<ConstraintViolation<Car>> violations = validator.validate(car);

        assertEquals(1, violations.size());
        assertEquals("should not be empty", violations.iterator().next().getMessage());
    }

    @Test
    public void testFerrariManufacturerValidation() {
        Car car = new Car();
        car.setManufacturer("Very long manufacturer name");
        Set<ConstraintViolation<Car>> violations = validator.validate(car);

        assertEquals(1, violations.size());
        assertEquals("should not be empty", violations.iterator().next().getMessage());
    }
}
