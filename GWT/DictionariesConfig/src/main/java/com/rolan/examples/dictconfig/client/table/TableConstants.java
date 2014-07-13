package com.rolan.examples.dictconfig.client.table;

import com.google.gwt.core.client.GWT;
import com.google.gwt.i18n.client.Constants;
import com.google.gwt.i18n.client.Messages;

public interface TableConstants extends Constants {

    TableConstants INSTANCE = GWT.create(TableConstants.class);

    @DefaultStringValue("First Name:")
    public String contactFirstName();

    @DefaultStringValue("Last Name:")
    public String contactLastName();

    @DefaultStringValue("Default:")
    public String defaultContact();
}
