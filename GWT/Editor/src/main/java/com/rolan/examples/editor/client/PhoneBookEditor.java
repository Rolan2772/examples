package com.rolan.examples.editor.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.editor.client.*;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.uibinder.client.UiTemplate;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;
import com.rolan.examples.editor.shared.dto.Contact;
import com.rolan.examples.editor.shared.dto.Employee;
import com.rolan.examples.editor.shared.dto.PhoneBook;

@UiTemplate("PhoneBookEditor.ui.xml")
public class PhoneBookEditor extends Composite implements com.google.gwt.editor.client.Editor<PhoneBook> {

    @UiField
    ContactEditor contact;

    @UiField
    EmployeeEditor employee;

    private static PhoneBookEditorUiBinder uiBinder = GWT.create(PhoneBookEditorUiBinder.class);

    Driver driver = GWT.create(Driver.class);

    PhoneBook phoneBook;

    public PhoneBookEditor() {
        initWidget(uiBinder.createAndBindUi(this));
        phoneBook = new PhoneBook(new Employee(), new Contact());
        phoneBook.getContact().setAddress("New address");
        driver.initialize(this);
        driver.edit(phoneBook);
    }

    @UiHandler("reset")
    void onReset(ClickEvent event) {
        contact.clear();
        employee.clear();
    }

    @UiHandler("save")
    void onClickSave(ClickEvent event) {
        driver.flush();
        if (driver.hasErrors()) {
            Window.alert("There are errors on the form");
        }
    }

    @UiHandler("fetch")
    void onClickFetch(ClickEvent event) {
        driver.edit(phoneBook);
    }

    interface PhoneBookEditorUiBinder extends UiBinder<Widget, PhoneBookEditor> {
    }
    interface Driver extends SimpleBeanEditorDriver<PhoneBook, PhoneBookEditor> {
    }
}
