package com.rolan.examples.gwt.cellwidgets.client;

import com.google.gwt.cell.client.Cell;
import com.google.gwt.cell.client.NumberCell;
import com.google.gwt.cell.client.TextCell;
import com.google.gwt.core.client.GWT;
import com.google.gwt.i18n.client.NumberFormat;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.cellview.client.CellWidget;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

public class SimpleCells extends Composite {

    @UiField(provided = true)
    CellWidget<String> textCellWidget;
    @UiField(provided = true)
    CellWidget<Number> numberCellWidget;

    private SimpleUiBinder uiBinder = GWT.create(SimpleUiBinder.class);

    public SimpleCells() {
        createTextCell();
        createNumberCell();
        initWidget(uiBinder.createAndBindUi(this));
    }

    private void createTextCell() {
        Cell<String> textCell = new TextCell();
        textCellWidget = new CellWidget<>(textCell);
        textCellWidget.setValue("Hello world");
    }

    private void createNumberCell() {
        Cell<Number> numberCell = new NumberCell(NumberFormat.getPercentFormat());
        numberCellWidget = new CellWidget<>(numberCell);
        numberCellWidget.setValue(0.23);
    }

    interface SimpleUiBinder extends UiBinder<Widget, SimpleCells> {
    }
}
