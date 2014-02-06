package com.rolan.examples.editor.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.CssResource;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiTemplate;
import com.google.gwt.user.client.ui.*;
import com.rolan.examples.editor.shared.dto.Emplyee;

@UiTemplate("FirstEditor.ui.xml")
public class FirstEditor extends Composite implements com.google.gwt.editor.client.Editor<Emplyee> {

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

    private static FirstEditorUiBinder uiBinder = GWT.create(FirstEditorUiBinder.class);

    public FirstEditor() {
        initWidget(uiBinder.createAndBindUi(this));
        for(Widget widget : mainPanel) {
            widget.addStyleName(style.vertical());
        }
    }

    interface Style extends CssResource {
        String vertical();
    }

    interface FirstEditorUiBinder extends UiBinder<Widget, FirstEditor> {
    }
}
