package com.rolan.examples.patterns.proxy;

import java.net.URL;

public class ProxyImage implements Image {

    private URL url;

    public ProxyImage(URL url) {
        this.url = url;
    }

    @Override
    public void displayImage() {
        RealImage image = new RealImage(url);
        image.displayImage();
    }
}
