package com.rolan.examples.gwtuibinder.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Element;
import com.google.gwt.dom.client.SpanElement;
import com.google.gwt.event.dom.client.BlurEvent;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.FocusEvent;
import com.google.gwt.resources.client.CssResource;
import com.google.gwt.uibinder.client.*;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.*;

@UiTemplate("LoginPanel.ui.xml")
public class LoginPanel extends PopupPanel {

    private static MainPanelUiBinder ourUiBinder = GWT.create(MainPanelUiBinder.class);

    @UiField
    TextBox email;
    @UiField(provided = true)
    TextBox password;

    @UiField
    SpanElement emailErrorText;
    @UiField
    SpanElement passwordErrorText;
    @UiField
    Element emailError;
    @UiField
    Element passwordError;

    @UiField
    ValidationStyle validationStyle;

    public LoginPanel() {
        password = new PasswordTextBox();
        setStyleName("");
        add(ourUiBinder.createAndBindUi(this));
    }

    @UiFactory
    Button createLoginButton() {
        Button loginBtn = new Button("Login");
        return loginBtn;
    }

    @UiHandler("login")
    void submitLoginForm(ClickEvent event) {
        if (validateEmail() && validatePassword()) {
            Window.alert("Logging in");
        }
    }

    @UiHandler("email")
    void emailFocus(FocusEvent event) {
        emailError.addClassName(validationStyle.hidden());
        setBorderStyle(email, validationStyle.borderValid());
    }

    @UiHandler("email")
    void emailBlur(BlurEvent event) {
        if (validateEmail()) {
            emailError.addClassName(validationStyle.hidden());
            email.addStyleName(validationStyle.borderValid());
        } else {
            emailError.removeClassName(validationStyle.hidden());
            email.addStyleName(validationStyle.borderInvalid());
        }
    }

    private boolean validateEmail() {
        return email.getText().matches("[^\\s@]+\\@[^\\s@]+");
    }
    private boolean validatePassword() {
        return password.getText().length() >= 6;
    }

    private void setBorderStyle(TextBox textBox, String borderStyleName) {
        GWT.log("Tex box style before: " + textBox.getStyleName());
        textBox.removeStyleName(validationStyle.borderEmpty());
        textBox.removeStyleName(validationStyle.borderValid());
        textBox.removeStyleName(validationStyle.borderInvalid());
        textBox.addStyleName(borderStyleName);
        GWT.log("Tex box style after: " + textBox.getStyleName());
    }

    interface ValidationStyle extends CssResource {
        String hidden();

        String borderEmpty();

        String borderValid();

        String borderInvalid();
    }

    interface MainPanelUiBinder extends UiBinder<Widget, LoginPanel> {
    }
}