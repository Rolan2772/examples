package com.rolan.examples.editor.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.RootPanel;

public class Editor implements EntryPoint {

    public void onModuleLoad() {
        PhoneBookEditor editor = new PhoneBookEditor();
        RootPanel.get().add(editor);
    }
}
