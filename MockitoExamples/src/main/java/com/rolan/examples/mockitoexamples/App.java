package com.rolan.examples.mockitoexamples;

public class App {

    public static void main(String... args) {

    }

    public App() {
    }

    public void someMethod(Callback<SomeClass> callback) {
        callback.callBack(new SomeClass(1L, "Text"));
    }

    public static void callStaticMethod(Callback<SomeClass> callback) {
        StaticInnerClass staticInnerClass = StaticInnerClass.getInstance();
        staticInnerClass.someMethod(callback);
    }

}
