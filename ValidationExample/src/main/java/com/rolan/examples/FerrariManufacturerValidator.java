package com.rolan.examples;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang3.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.ConstraintViolation;
import java.lang.reflect.InvocationTargetException;

public class FerrariManufacturerValidator implements ConstraintValidator<FerrariManufacturer, String> {


    @Override
    public void initialize(FerrariManufacturer constraintAnnotation) {

    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (StringUtils.isBlank(value)) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate("{com.rolan.exmaples.NullValue}")
                    .addConstraintViolation();
            return false;
        } else if (value.length() > 10) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate("{com.rolan.exmaples.LongValue}")
                    .addConstraintViolation();
            return false;
        }
        return true;
    }
}
