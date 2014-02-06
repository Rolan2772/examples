package com.rolan.examples.editor.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.RootPanel;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class Editor implements EntryPoint {

    public void onModuleLoad() {
        FirstEditor editor = new FirstEditor();
        RootPanel.get().add(editor);
    }
}
