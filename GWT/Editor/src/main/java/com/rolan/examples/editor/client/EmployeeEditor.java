package com.rolan.examples.editor.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.editor.client.SimpleBeanEditorDriver;
import com.google.gwt.resources.client.CssResource;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiTemplate;
import com.google.gwt.user.client.ui.*;
import com.rolan.examples.editor.shared.dto.Employee;

@UiTemplate("EmployeeEditor.ui.xml")
public class EmployeeEditor extends Composite implements com.google.gwt.editor.client.Editor<Employee>/*implements HasEditorDelegate<Employee>, HasEditorErrors<Employee>*/ {

    @Ignore
    @UiField
    FlowPanel mainPanel;

    @UiField
    TextBox name;

    @UiField
    TextBox position;

    @Ignore
    @UiField
    Label id;

    @Ignore
    @UiField
    Style style;

    // private EditorDelegate<Employee> employeeEditorDelegate;

    private static EmployeeEditorUiBinder uiBinder = GWT.create(EmployeeEditorUiBinder.class);

    public EmployeeEditor() {
        initWidget(uiBinder.createAndBindUi(this));
        for(Widget widget : mainPanel) {
            widget.addStyleName(style.vertical());
        }
    }

    /*@Override
    public void setDelegate(EditorDelegate<Employee> delegate) {
        this.employeeEditorDelegate = delegate;
    }

    @Override
    public void showErrors(List<EditorError> errors) {
        for (EditorError error : errors) {
            GWT.log("Employee editor eror: " + error.getMessage());
            error.setConsumed(true);
        }
    } */


    interface Style extends CssResource {
        String vertical();
    }

    public void clear() {
        name.setText("");
        position.setText("");
    }

    interface EmployeeEditorUiBinder extends UiBinder<Widget, EmployeeEditor> {
    }

    /*interface Driver extends SimpleBeanEditorDriver<Employee, EmployeeEditor> {
    } */
}
