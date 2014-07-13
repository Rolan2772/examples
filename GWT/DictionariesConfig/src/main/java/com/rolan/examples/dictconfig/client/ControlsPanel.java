package com.rolan.examples.dictconfig.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.*;

import java.util.logging.Level;
import java.util.logging.Logger;

public class ControlsPanel extends Composite {

    Logger logger = Logger.getLogger(ControlsPanel.class.getName());

    @UiField
    CheckBox someCheckBox;
    @UiField
    RadioButton r1;
    @UiField
    RadioButton r2;
    @UiField
    Button button;
    @UiField(provided = true)
    PushButton pushButton;
    @UiField
    ListBox singleSelectList;
    @UiField
    ListBox multiSelectList;
    @UiField(provided = true)
    SuggestBox suggest;

    private static ControlsPanelUiBinder controlsPanelUiBinder = GWT.create(ControlsPanelUiBinder.class);

    public ControlsPanel() {
        pushButton = new PushButton(new Image(Resources.INSTANCE.grimace()), new Image(Resources.INSTANCE.superMan()));
        pushButton.setWidth(Resources.INSTANCE.superMan().getWidth() + "px");
        initSuggestBox();
        initWidget(controlsPanelUiBinder.createAndBindUi(this));
        for (String value : ConfigConstants.INSTANCE.mailListData()) {
            singleSelectList.addItem(value, value);
        }
        singleSelectList.setSelectedIndex(0);
        updateDependentList(0);
    }

    private void initSuggestBox() {
        MultiWordSuggestOracle oracle = new MultiWordSuggestOracle();
        for (String value : ConfigConstants.INSTANCE.cars()) {
            oracle.add(value);
        }
        suggest = new SuggestBox(oracle);
    }

    @UiHandler("singleSelectList")
    public void handleChange(ChangeEvent event) {
        Object source = event.getSource();
        if (source == singleSelectList) {
            updateDependentList(singleSelectList.getSelectedIndex());
        }
    }

    private void updateDependentList(int index) {
        String[] values = new String[0];
        switch(index) {
            case 0 :
                values = ConfigConstants.INSTANCE.cars();
                break;
            case 1 :
                values = ConfigConstants.INSTANCE.weapon();
                break;
        }
        multiSelectList.clear();
        for (String value : values) {
            multiSelectList.addItem(value, value);
        }
    }

    @UiHandler({"someCheckBox", "r1", "r2"})
    public void handleChangeValue(ValueChangeEvent<Boolean> event) {
        Object source = event.getSource();
        if (source == someCheckBox) {
            logger.log(Level.INFO, "CheckBox is " + (event.getValue() ? "enabled" : "disabled"));
        } else if (source == r1) {
            logger.log(Level.INFO, "R1 is " + (event.getValue() ? "checked" : "unchecked"));
        } else if (source == r2) {
            logger.log(Level.INFO,"R2 is " + (event.getValue() ? "checked" : "unchecked"));
            GWT.log("R2 GWT");
        }
    }

    @UiHandler("button")
    public void handleClick(ClickEvent event) {
        Object source = event.getSource();
        if (source == button) {
            logger.info("Button is clicked");
        }
    }


    interface ControlsPanelUiBinder extends UiBinder<Widget, ControlsPanel> {
    }
}