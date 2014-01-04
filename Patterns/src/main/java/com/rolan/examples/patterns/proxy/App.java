package com.rolan.examples.patterns.proxy;

import java.net.URL;

public class App {

    public static void main(String... args) throws Exception {
        URL url = new URL("http://test/img.jpg");
        ProxyImage proxy = new ProxyImage(url);
        proxy.displayImage();
    }
}
