package com.rolan.examples.gwtuibinder.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.DivElement;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiTemplate;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.PopupPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;

import javax.swing.*;

@UiTemplate("MainPanel.ui.xml")
public class MainPanel extends PopupPanel {

    interface MainPanelUiBinder extends UiBinder<Widget, MainPanel> {}
    private static MainPanelUiBinder ourUiBinder = GWT.create(MainPanelUiBinder.class);

    /*@UiField
    TextBox email;*/

    public MainPanel() {
        add(ourUiBinder.createAndBindUi(this));
    }
}