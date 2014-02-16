package com.rolan.examples.spel.operators;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("operatorsBean")
public class Operators {

    @Value("#{numbersBean.first == 100}")
    private boolean equals;
    @Value("#{numbersBean.second != 100}")
    private boolean notEquals;
    @Value("#{numbersBean.first < numbersBean.second}")
    private boolean lessThan;
    private boolean lessThanOrEquals;
    private boolean greaterThan;
    private boolean greaterThanOrEquals;

    public boolean isEquals() {
        return equals;
    }

    public void setEquals(boolean equals) {
        this.equals = equals;
    }

    public boolean isNotEquals() {
        return notEquals;
    }

    public void setNotEquals(boolean notEquals) {
        this.notEquals = notEquals;
    }

    public boolean isLessThan() {
        return lessThan;
    }

    public void setLessThan(boolean lessThan) {
        this.lessThan = lessThan;
    }

    public boolean isLessThanOrEquals() {
        return lessThanOrEquals;
    }

    public void setLessThanOrEquals(boolean lessThanOrEquals) {
        this.lessThanOrEquals = lessThanOrEquals;
    }

    public boolean isGreaterThan() {
        return greaterThan;
    }

    public void setGreaterThan(boolean greaterThan) {
        this.greaterThan = greaterThan;
    }

    public boolean isGreaterThanOrEquals() {
        return greaterThanOrEquals;
    }

    public void setGreaterThanOrEquals(boolean greaterThanOrEquals) {
        this.greaterThanOrEquals = greaterThanOrEquals;
    }

    @Override
    public String toString() {
        return "Operators{" +
                "equals=" + equals +
                ", notEquals=" + notEquals +
                ", lessThan=" + lessThan +
                '}';
    }
}
