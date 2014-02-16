package com.rolan.examples.spel.operators;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("numbersBean")
public class Numbers {

    @Value("100")
    private int first;
    @Value("150")
    private int second;
    @Value("200")
    private int third;
    @Value("250")
    private int fourth;
    @Value("300")
    private int fifth;

    public int getFirst() {
        return first;
    }

    public void setFirst(int first) {
        this.first = first;
    }

    public int getSecond() {
        return second;
    }

    public void setSecond(int second) {
        this.second = second;
    }

    public int getThird() {
        return third;
    }

    public void setThird(int third) {
        this.third = third;
    }

    public int getFourth() {
        return fourth;
    }

    public void setFourth(int fourth) {
        this.fourth = fourth;
    }

    public int getFifth() {
        return fifth;
    }

    public void setFifth(int fifth) {
        this.fifth = fifth;
    }
}
