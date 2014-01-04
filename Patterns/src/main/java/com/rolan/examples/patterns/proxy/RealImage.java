package com.rolan.examples.patterns.proxy;

import java.net.URL;

public class RealImage implements Image {

    public RealImage(URL url) {
        loadImage(url);
    }

    @Override
    public void displayImage() {
        System.out.println("displaying image");
    }

    public void loadImage(URL url) {
        System.out.println("Loading from URL " + url);
    }


}
