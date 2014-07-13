package com.rolan.examples.editor.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.editor.client.*;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.uibinder.client.UiTemplate;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;
import com.rolan.examples.editor.shared.dto.Contact;

@UiTemplate("ContactEditor.ui.xml")
public class ContactEditor extends Composite implements com.google.gwt.editor.client.Editor<Contact> {

    @UiField
    TextBox city;

    @UiField
    TextBox address;

    private static ContractEditorUiBinder uiBinder = GWT.create(ContractEditorUiBinder.class);

    public ContactEditor() {
        initWidget(uiBinder.createAndBindUi(this));
    }

    interface ContractEditorUiBinder extends UiBinder<Widget, ContactEditor> {
    }

    public void clear() {
        city.setText("");
        address.setText("");
    }
}
