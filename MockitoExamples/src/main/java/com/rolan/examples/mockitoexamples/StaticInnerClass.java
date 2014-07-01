package com.rolan.examples.mockitoexamples;

public class StaticInnerClass {

    private static StaticInnerClass INSTANCE;

    public static StaticInnerClass getInstance() {
        if (INSTANCE == null) {
            return new StaticInnerClass();
        }
       return INSTANCE;
    }


    public void someMethod(Callback<SomeClass> callback) {
        callback.callBack(new SomeClass(1L, "Text"));
    }
}
