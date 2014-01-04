package com.rolan.examples.gwtuibinder.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.RootPanel;

public class App implements EntryPoint {

  public void onModuleLoad() {
      RootPanel.get().add(new MainPanel(), 0, 0);
  }
}
