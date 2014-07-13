package com.rolan.examples.dictconfig.client;

import com.google.gwt.core.shared.GWT;
import com.google.gwt.i18n.client.Constants;

public interface ConfigConstants extends Constants {

    public static final ConfigConstants INSTANCE = GWT.create(ConfigConstants.class);

    @DefaultStringArrayValue({"Ferrari", "Lamborghini", "Porsche"})
    String[] cars();

    @DefaultStringArrayValue({"AK-74", "Desert Eagle 0.5"})
    String[] weapon();

    @DefaultStringArrayValue({"Cars", "Weapon"})
    String[] mailListData();
}
