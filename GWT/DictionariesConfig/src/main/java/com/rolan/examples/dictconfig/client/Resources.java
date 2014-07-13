package com.rolan.examples.dictconfig.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.ImageResource;

public interface Resources extends ClientBundle {

    public static Resources INSTANCE = GWT.create(Resources.class);

    @Source("../public/img/super-man-icon.png")
    public ImageResource superMan();

    @Source("../public/img/grimace-icon.png")
    public ImageResource grimace();
}
